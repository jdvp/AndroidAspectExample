#!/usr/bin/env bash

# This is the location of the gradle-wrapper file we are validating
wrapperLocation="gradle/wrapper/gradle-wrapper.jar"

# Gets the list of versions from Gradle and finds the lines that mention wrapper checksums
checksumUrlLines=$(curl -s https://services.gradle.org/versions/all | grep "wrapperChecksumUrl")

# Parse out the URLs
checksumUrls=$(echo "$checksumUrlLines" | grep -o --line-buffered "https.*sha256")

# Only take major releases (ignoring RCs, Milestones, etc.)
majorReleaseUrls=$(echo "$checksumUrls" | grep -v "rc" | grep -v "milestone" | grep -v "snapshot")

# Only check Gradle 6.7.1 and above checksums
# You can change this if your project started on an older version like 4.10.2
# Since I know I started this project around 6.7 I don't need to even check older versions   
postVersionUrls=$(echo "$majorReleaseUrls" | sed '/6.7.1/q')

checkShaSum() {
  case "$OSTYPE" in
    # Bash Shell included in Git for Windows should have the sha256sum function
    msys*)    echo "$1" | sha256sum --check ;;
    cygwin*)  echo "$1" | sha256sum --check ;;
    # Linux and Mac should have the shasum function
    *)        echo "$1" | shasum -a 256 --check ;;
  esac
}

while read -r url; do
  gradleReleaseVersion=$(echo "$url" | grep -o "gradle-.*-wrapper.jar")
  echo "Checking if $wrapperLocation matches sha256 from gradle release : $gradleReleaseVersion"
  checksum=$(curl -s --location "$url")
  sha256sumOutput=$(checkShaSum "$checksum  $wrapperLocation")
  if [[ "$sha256sumOutput" == "$wrapperLocation: OK" ]]; then
    echo "$wrapperLocation checksum matches checksum from url : $url"
    echo "Gradle wrapper checksum is valid"
    exit
  fi
done < <(echo "$postVersionUrls")

echo "Failure: Gradle wrapper checksum does not appear to be valid"
exit 1

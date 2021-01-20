# AndroidAspectExample
Project to show examples of leveraging Aspect-Oriented Programming techniques

Aspects are defined in AspectLogging.java and affect MainActivity.java. 
In order to see that the code has been injected, build the app and check the app/build directory for the 
ajc-transform.log file which will show which advices have been added to the project during the build process.

If you run the app, the aspects added will simply log when a button is clicked or onCreate happens.

Created as a sample for the following Medium article:
[Aspect-Oriented Programming in Android](https://link.medium.com/XYs0fWKrC7)

### Releases
Please see the [GitHub Releases Page](https://github.com/jdvp/AndroidAspectExample/releases)
for this example if you want to see details for a specific Android Gradle Plugin (AGP) version.

---

As of v4.1.0, this sample project leverages the following Gradle Plugin for weaving aspects:
[gradle-aspectj-pipeline-plugin](https://github.com/Ibotta/gradle-aspectj-pipeline-plugin)

Previously, this project was leveraging [android-gradle-aspectj](https://github.com/Archinamon/android-gradle-aspectj).
For information on why I made the switch, you might be interested in reading my article "[Switching AspectJ Plugins in Android](https://jdvp.me/articles/Switching-AspectJ-Plugins-Android)".

Code required using either plugin is the same since they both use the same aspectjrt library under the hood. The only difference is the required plugin setup in our gradle files.
## AndroidAspectExample
Project to show examples of leveraging Aspect-Oriented Programming techniques

Aspects are defined in AspectLogging.java and affect MainActivity.java. 
In order to see that the code has been injected, build the app and check the app/build directory for the 
ajc-transform.log file which will show which advices have been added to the project during the build process.

If you run the app, the aspects added will simply log when a button is clicked or onCreate happens.

Created as a sample for the following Medium article:
[Aspect-Oriented Programming in Android](https://jdvp.medium.com/aspect-oriented-programming-in-android-159054d52757)

## Releases
Please see the [GitHub Releases Page](https://github.com/jdvp/AndroidAspectExample/releases)
for this example if you want to see details for a specific Android Gradle Plugin (AGP) version.
Each release version for this sample project will correspond to the same AGP version.

## Notes

#### Plugin Change

As of v4.1.0, this sample project leverages the following Gradle Plugin for weaving aspects:

[gradle-aspectj-pipeline-plugin](https://github.com/Ibotta/gradle-aspectj-pipeline-plugin)

Previously, this project was leveraging [android-gradle-aspectj](https://github.com/Archinamon/android-gradle-aspectj).
For information on why I made the switch, you might be interested in reading my article "[Switching AspectJ Plugins in Android](https://jdvp.me/articles/Switching-AspectJ-Plugins-Android)".

Code required using either plugin is the same since they both use the same aspectjrt library under the hood. The only difference is the required plugin setup in our gradle files.

#### Kotlin 1.5.0 Support

This is more of an issue with AspectJ than this project or even the gradle-aspectj-pipeline-plugin project, but Kotlin code compiled with Kotlin version 1.5.0 now uses invokedynamic to to compile Single Abstract Method functions ([see here](https://kotlinlang.org/docs/whatsnew15.html#sam-adapters-via-invokedynamic) for informaton in the documentation). This means that lambdas in Kotlin using this version or above will not be weaved as expected as the compiled bytecode will not be able to be matched by AspectJ pointcuts.

To get around this for now, enable the following in project-level build.gradle files:  
```
kotlinOptions {
    freeCompilerArgs = ["-Xsam-conversions=class"]
}
```

You can read more about the issue [here](https://github.com/Ibotta/gradle-aspectj-pipeline-plugin/issues/8) if interested.

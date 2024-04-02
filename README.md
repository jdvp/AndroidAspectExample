## AndroidAspectExample
Project to show examples of leveraging Aspect-Oriented Programming (AOP) techniques

Aspects are defined in AspectLogging.java and affect MainActivity.java. 
In order to see that the code has been injected, build the app and check the app/build directory for the 
ajc-transform.log file which will show which advices have been added to the project during the build process.

If you run the app, the aspects added will simply log when a button is clicked or onCreate happens.

Created as a sample for my article "[Aspect-Oriented Programming in Android]".

## Releases
Please see the [GitHub Releases Page]
for this example if you want to see details for a specific Android Gradle Plugin (AGP) version.
Each release version for this sample project will correspond to the same AGP version.

## Notes

#### Plugin Change

As of v4.1.0, this sample project leverages the following Gradle Plugin for weaving aspects:

[gradle-aspectj-pipeline-plugin]

Previously, this project was leveraging [android-gradle-aspectj].
For information on why I made the switch, you might be interested in reading my article "[Switching AspectJ Plugins in Android]".

Code required using either plugin is the same since they both use the same aspectjrt library under the hood. The only difference is the required plugin setup in our gradle files.

#### Kotlin 1.5.0 Support

This is more of an issue with AspectJ than this project or even the gradle-aspectj-pipeline-plugin project, but Kotlin code compiled with Kotlin version 1.5.0 now uses invokedynamic to to compile Single Abstract Method functions ([see here] for information in the documentation). This means that lambdas in Kotlin using this version or above will not be weaved as expected as the compiled bytecode will not be able to be matched by AspectJ pointcuts.

To get around this for now, enable the following in project-level build.gradle files:  
```groovy
kotlinOptions {
    freeCompilerArgs = ["-Xsam-conversions=class"]
}
```

You can read more about the issue [here] if interested.

### Using newer versions of AspectJ

If you are using AspectJ for some other reason and so want to leverage a different version of the library
other than the one suggested by the Ibotta Plugin (1.9.6), which is used to compile the plugin, you can
generally do so freely up until version 1.9.21 of the AspectJ Plugin (`org.aspectj:aspectjrt`).

If you have a minSdk of 25 or lower, 1.9.22 will likely give you problems. My testing seems to indicate 
that this can be fixed by [desugaring].

First, make sure the requisite compile option is set
```groovy
compileOptions {
    coreLibraryDesugaringEnabled true
}
```

Then, include the desugaring dependency
```groovy
coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")
```

Make sure to update this dependency to latest as required.

#### Why I don't recommend AOP in 2023

In late January 2023, the AOP plugin that this project uses, [gradle-aspectj-pipeline-plugin], indicated
that the project would no longer be maintained due to issues with the upcoming AGP 8.0.0 updates removing
required APIs. In response, I wrote "[Why I Don't Recommend Aspect-Oriented Programming in Android in 2023]",
an article that explains why I would be hesitant to use AOP in an enterprise application in 2023.

I did do some research and came to the conclusion that the plugin [would not be broken] by AGP 8.0.0
and as such I will continue updating this sample project (playing both sides??) until the plugin
begins to stop working with AGP or Kotlin updates. 

That being said, even though I am going to continue updating this sample app for the foreseeable future,
I would recommend reading "[Why I Don't Recommend Aspect-Oriented Programming in Android in 2023]"
and really thinking about if you actually need to leverage AOP in your project before continuing on
and playing around with the sample project.


[Aspect-Oriented Programming in Android]: https://jdvp.me/articles/AOP-in-Android
[GitHub Releases Page]: https://github.com/jdvp/AndroidAspectExample/releases
[gradle-aspectj-pipeline-plugin]: https://github.com/Ibotta/gradle-aspectj-pipeline-plugin
[android-gradle-aspectj]: https://github.com/Archinamon/android-gradle-aspectj
[Switching AspectJ Plugins in Android]: https://jdvp.me/articles/Switching-AspectJ-Plugins-Android
[see here]: https://kotlinlang.org/docs/whatsnew15.html#sam-adapters-via-invokedynamic
[here]: https://github.com/Ibotta/gradle-aspectj-pipeline-plugin/issues/8
[Why I Don't Recommend Aspect-Oriented Programming in Android in 2023]: https://jdvp.me/articles/AOP-in-Android-2023
[would not be broken]: https://github.com/Ibotta/gradle-aspectj-pipeline-plugin/issues/34
[desugaring]: https://android-developers.googleblog.com/2023/02/api-desugaring-supporting-android-13-and-java-nio.html

# AndroidAspectExample
Project to show examples of leveraging Aspect-Oriented Programming techniques

Aspects are defined in AspectLogging.java and affect MainActivity.java. 
In order to see that the code has been injected, build the app and check the app/build directory for the 
ajc-transform.log file which will show which advices have been added to the project during the build process.

If you run the app, the aspects added will simply log when a button is clicked or onCreate happens.

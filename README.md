# Jakie

## What is it?

A java-keylogger that runs hidden in the background and captures keystrokes.

## How does it work?

The project uses JNativeHook that leverages platform-dependent native code to create low-level system-wide hooks.

## Using Locally

If you want to run this project locally,

### Requirements

1. Java 7 or above
2. Windows 7,8 or 10

### Build

For the first download/clone of this repo,

1. Import the JKey1 folder as a Java project using your IDE (Eclipse/Netbeans).
2. If the IDE dows not detect the `lib` folder, then [add its contents as external jars](http://www.wikihow.com/Add-JARs-to-Project-Build-Paths-in-Eclipse-(Java)).
3. Run as Java application.

### Run

To directly use it.

1. Click runner.bat from compiled folder. This will start the app in background (You can check this under processes in TaskManager).
2. Type anything, anywhere.
3. To stop the app. Press `F9` key.
4. Check the locally created serverLogs.txt for all the logged keystrokes.

### Future Work

* Move dependencies to config.
* Log function keys as well. (Find another way to end application)
* Translate mouse positions to scalable locations _(Yes the application also supports logging mouse position. Though, currently this is too much info and not logged)_. 

## Disclamer

Need I say.

## Licence

Licenced under GNU GENERAL PUBLIC LICENSE v3.0. It is free to copy and distribute.

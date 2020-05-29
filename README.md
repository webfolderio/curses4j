# curses4j

[![AppVeyor](https://img.shields.io/appveyor/ci/WebFolder/curses4j.svg?label=Windows-GNU/Linux)](https://ci.appveyor.com/project/WebFolder/curses4j) (https://circleci.com/gh/webfolderio/curses4j) [![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

This is an easy-to-use, fully cross-platform Java wrapper for the [ncurses](https://en.wikipedia.org/wiki/Ncurses) in GNU/Linux and [PDCurses](https://en.wikipedia.org/wiki/PDCurses) in Windows. The project is able to load the OS-specific native implementation of curses at runtime which means you can deploy the same binary to GNU/Linux & Windows.

Supported Java Versions
-----------------------

Oracle & OpenJDK 64-bit Java 8, 11.

Both the JRE and the JDK are suitable for use with this library.

Supported Platforms
-------------------
* Windows 8 & Windows 10
* GNU/Linux

How it is tested
----------------
curses4j is regularly tested on [appveyor](https://ci.appveyor.com/project/WebFolder/curses4j) (Windows) and [circleci](https://circleci.com/gh/webfolderio/curses4j) (Ubuntu).

Integration with Maven
----------------------

To use the official release of curses4j, please use the following snippet in your `pom.xml` file.

Add the following to your POM's `<dependencies>` tag:

```xml
<dependency>
    <groupId>io.webfolder</groupId>
    <artifactId>curses4j</artifactId>
    <version>1.1.0</version>
</dependency>
```

License
-------
Licensed under the [MIT](https://github.com/webfolderio/curses4j/blob/master/LICENSE). You can integrate and use this project in your applications for __free__!
You can even change the source code and redistribute (even resell it).


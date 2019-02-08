# curses4j

[![AppVeyor](https://img.shields.io/appveyor/ci/WebFolder/curses4j.svg?label=Windows)](https://ci.appveyor.com/project/WebFolder/curses4j) [![circleci](https://img.shields.io/appveyor/ci/WebFolder/curses4j.svg?label=Ubuntu)](https://circleci.com/gh/webfolderio/curses4j) [![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

This is an easy-to-use, fully cross-platform Java wrapper for the [ncurses](https://en.wikipedia.org/wiki/Ncurses) in GNU/Linux and [PDCurses](https://en.wikipedia.org/wiki/PDCurses). The project is able to load the OS-specific native implementation of curses at runtime which means you can deploy the same binary to Windows & GNU/Linux.

Whether you just need colors & styles, build a simple interactive command line tool or a complexe terminal application: this is the absolute terminal library for Java.

Supported Java Versions
-----------------------

Oracle & OpenJDK Java 8, 11.

Both the JRE and the JDK are suitable for use with this library.

Supported Platforms
-------------------
* Windows 8 & Windows 10 (64-bit)
* GNU/Linux (64-bit)

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
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

License
-------
Licensed under the [MIT](https://github.com/webfolderio/curses4j/blob/master/LICENSE).

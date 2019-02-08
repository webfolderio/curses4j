#!/bin/bash

gcc -fPIC -Wall -shared -I$JAVA_HOME/include -I$JAVA_HOME/include/linux src/main/native/curses4j.c -o libcurses4j.dylib -lncurses -ltinfo
strip libcurses4j.dylib
cp libcurses4j.dylib src/main/resources/META-INF
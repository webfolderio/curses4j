#!/bin/bash

gcc -fPIC -Wall -shared -I$JAVA_HOME/include -I$JAVA_HOME/include/linux src/main/native/curses4j.c -o libcurses4j.so -lncurses -ltinfo
strip libcurses4j.so
cp libcurses4j.so src/main/resources/META-INF
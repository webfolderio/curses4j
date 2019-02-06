#!/bin/bash

gcc -fPIC -Wall -shared -I$JAVA_HOME/include -I$JAVA_HOME/include/linux src/main/native/pdcurses4j.c -o libpdcurses4j.so -lncurses -ltinfo
cp libpdcurses4j.so src/main/resources/META-INF
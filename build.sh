#!/bin/bash

mkdir build
cd build
cmake ..
strip libcurses4j.so
cp libcurses4j.so src/main/resources/META-INF
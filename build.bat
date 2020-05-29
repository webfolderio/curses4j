curl -L "https://github.com/wmcbrine/PDCurses/archive/3.9.zip" --output 3.9.zip
"%JAVA_HOME%\bin\jar.exe" xf 3.9.zip
copy /Y src\main\native\libobjs.mif PDCurses-3.9\common\libobjs.mif
copy /Y src\main\native\Makefile.vc PDCurses-3.9\wincon\Makefile.vc
copy /Y src\main\native\curses4j.c PDCurses-3.9\pdcurses\curses4j.c
cd PDCurses-3.9\wincon
nmake -f Makefile.vc UTF8=Y WIDE=Y DLL=Y clean all
cd ..
cd ..
copy /Y PDCurses-3.9\wincon\pdcurses.dll src\main\resources\META-INF\curses4j.dll
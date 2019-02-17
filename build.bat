call "C:\Program Files (x86)\Microsoft Visual Studio 12.0\VC\vcvarsall.bat" amd64
"%JAVA_HOME%\bin\jar.exe" xf 3.8.zip
copy /Y src\main\native\libobjs.mif PDCurses-3.8\common\libobjs.mif
copy /Y src\main\native\Makefile.vc PDCurses-3.8\wincon\Makefile.vc
copy /Y src\main\native\curses4j.c PDCurses-3.8\pdcurses\curses4j.c
cd PDCurses-3.8\wincon
nmake -f Makefile.vc UTF8=Y WIDE=Y DLL=Y clean all
cd ..
cd ..
copy /Y PDCurses-3.8\wincon\pdcurses.dll src\main\resources\META-INF\curses4j.dll
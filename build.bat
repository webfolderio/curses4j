call "C:\Program Files (x86)\Microsoft Visual Studio\2017\Community\VC\Auxiliary\Build\vcvars64.bat"
"%JAVA_HOME%\bin\jar.exe" xf 3.7.zip
copy /Y src\main\native\libobjs.mif PDCurses-3.7\common\libobjs.mif
copy /Y src\main\native\Makefile.vc PDCurses-3.7\wincon\Makefile.vc
copy /Y src\main\native\curses4j.c PDCurses-3.7\pdcurses\curses4j.c
cd PDCurses-3.7\wincon
nmake -f Makefile.vc UTF8=Y WIDE=Y DLL=Y clean all
cd ..
cd ..
copy /Y PDCurses-3.7\wincon\pdcurses.dll src\main\resources\META-INF\curses4j.dll
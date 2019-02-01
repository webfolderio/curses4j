curl -O pdcurses.zip https://github.com/wmcbrine/PDCurses/archive/3.7.zip --output pdcurses.zip
jar xf pdcurses.zip
copy /Y src\main\native\libobjs.mif PDCurses-3.7\common\libobjs.mif
copy /Y src\main\native\Makefile.vc PDCurses-3.7\wincon\Makefile.vc
copy /Y src\main\native\pdcurses4j.c PDCurses-3.7\pdcurses\pdcurses4j.c
cd PDCurses-3.7\wincon
nmake -f Makefile.vc UTF8=Y WIDE=Y DLL=Y clean all
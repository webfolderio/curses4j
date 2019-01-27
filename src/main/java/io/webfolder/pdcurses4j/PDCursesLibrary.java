package io.webfolder.pdcurses4j;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

interface PDCursesLibrary extends Library {

	PDCursesLibrary INSTANCE = (PDCursesLibrary) Native.load("pdcurses", PDCursesLibrary.class);

	Pointer initscr();

	int wrefresh(Pointer win);

	int endwin();

	int wprintw(Pointer win, String s);

	int start_color();

	int init_pair(short pair, short fg, short bg);

	int wattr_on(Pointer win, long attrs, Pointer opts);

	int wattr_off(Pointer win, long attr, Pointer opts);

	int getmaxy(Pointer win);

	int getmaxx(Pointer win);

	int beep();

	int wbkgdset(Pointer pointer, long ch);
	
	int curs_set(int visibility);

	int wget_wch(Pointer win, Pointer wch);

	int wclear(Pointer win);

	int werase(Pointer win);

	boolean has_colors();

	boolean can_change_color();

	int flash();

	int scrollok(Pointer win, boolean bf);

	void PDC_set_title(String title);
}

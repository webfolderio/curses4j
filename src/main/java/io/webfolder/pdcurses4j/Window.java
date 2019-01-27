package io.webfolder.pdcurses4j;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import static io.webfolder.pdcurses4j.PDCursesLibrary.INSTANCE;
import static com.sun.jna.Pointer.NULL;

public class Window {

	private final Pointer peer;

	public Window() {
		this.peer = INSTANCE.initscr();
	}

	public static final short COLOR_BLACK = 0;
	public static final short COLOR_RED = 1;
	public static final short COLOR_GREEN = 2;
	public static final short COLOR_BLUE = 4;
	public static final short COLOR_CYAN = (COLOR_BLUE | COLOR_GREEN);
	public static final short COLOR_MAGENTA = (COLOR_RED | COLOR_BLUE);
	public static final short COLOR_YELLOW = (COLOR_RED | COLOR_GREEN);
	public static final short COLOR_WHITE = 7;

	public static final long PDC_COLOR_SHIFT = 24;

	public static long A_COLOR = 0xff000000;

	public static final int SIZEOF_WCHAR_T = 2;

	public static long COLOR_PAIR(long n) {
		return (n << PDC_COLOR_SHIFT) & A_COLOR;
	}

	public static long PAIR_NUMBER(long n) {
		return (n & A_COLOR) >> PDC_COLOR_SHIFT;
	}

	public int wrefresh() {
		return INSTANCE.wrefresh(peer);
	}

	public int end() {
		return INSTANCE.endwin();
	}

	public int wprintw(String str) {
		return INSTANCE.wprintw(peer, str);
	}

	public int start_color() {
		return INSTANCE.start_color();
	}

	public int init_pair(int pair, short fg, short bg) {
		return INSTANCE.init_pair((short) pair, fg, bg);
	}

	public void wattr_on(long attrs) {
		INSTANCE.wattr_on(peer, attrs, NULL);
	}

	public void wattr_off(long attrs) {
		INSTANCE.wattr_off(peer, attrs, NULL);
	}

	public void wbkgdset(long attrs) {
		INSTANCE.wbkgdset(peer, attrs);
	}

	public int getmaxy(Window window) {
		return INSTANCE.getmaxy(window.peer);
	}

	public int getmaxx(Window window) {
		return INSTANCE.getmaxx(window.peer);
	}

	public int beep() {
		return INSTANCE.beep();
	}

	public int curs_set(int visibility) {
		return INSTANCE.curs_set(visibility);
	}

	public char wget_wch() {
		long address = 0;
		try {
			address = Native.malloc(SIZEOF_WCHAR_T);
			Pointer ptr = new Pointer(address);
			int ret = INSTANCE.wget_wch(peer, ptr);
			if (ret == 0) {
				return (char) ptr.getChar(0);
			} else {
				return 0;
			}
		} finally {
			if (address > 0) {
				Native.free(address);
			}
		}
	}

	public int wclear() {
		return INSTANCE.wclear(peer);
	}	

	public int werase() {
		return INSTANCE.werase(peer);
	}

	public boolean has_colors() {
		return INSTANCE.has_colors();
	}

	public boolean can_change_color() {
		return INSTANCE.can_change_color();
	}

	public int flash() {
		return INSTANCE.flash();
	}

	public int scrollok(boolean bf) {
		return INSTANCE.scrollok(peer, bf);
	}

	public void setTitle(String title) {
		INSTANCE.PDC_set_title(title);
	}
}

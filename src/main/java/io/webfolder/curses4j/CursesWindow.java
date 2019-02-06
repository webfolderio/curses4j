package io.webfolder.curses4j;

import static java.lang.System.getProperty;
import static java.lang.System.load;
import static java.nio.file.Files.copy;
import static java.nio.file.Files.createTempFile;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static java.util.Locale.ENGLISH;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

class CursesWindow {

    private static final String OS = getProperty("os.name").toLowerCase(ENGLISH);

    private static final boolean WINDOWS = OS.startsWith("windows");

    long peer;

    static {
        ClassLoader cl = CursesWindow.class.getClassLoader();
        Path libFile;
        String library = WINDOWS ? "META-INF/curses4j.dll" : "META-INF/libcurses4j.so";
        try (InputStream is = cl.getResourceAsStream(library)) {
            libFile = createTempFile("curses4j", WINDOWS ? ".dll" : ".so");
            copy(is, libFile, REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        libFile.toFile().deleteOnExit();
        load(libFile.toAbsolutePath().toString());
    }

    native static int curses4j_beep();

    native static int curses4j_can_change_color();

    native static int curses4j_color_pair(int n);

    native static int curses4j_color_pairs();

    native static int curses4j_colors();

    native static int curses4j_def_shell_mode();

    native static int curses4j_endwin();

    native static int curses4j_flash();

    native static int curses4j_has_colors();

    native static int curses4j_init_color(short color, short red, short green, short blue);

    native static int curses4j_init_pair(short pair, short fg, short bg);

    native static int curses4j_napms(int delay);

    native static long curses4j_newwin(int nlines, int ncols, int begy, int begx);

    native static int curses4j_noecho();

    native static int curses4j_pair_number(int n);

    native static int curses4j_pdc_acs(int w);

    native static int curses4j_start_color();

    native static int curses4j_typeahead(int fields);

    native static String curses4j_unctrl(int c);

    native int curses4j_box(long peer, char verch, char horch);

    native long curses4j_derwin(long peer, int nlines, int ncols, int begy, int begx);

    native int curses4j_getmaxx(long peer);

    native int curses4j_getmaxy(long peer);

    native int curses4j_getparx(long peer);

    native int curses4j_getpary(long peer);

    native long curses4j_initscr();

    native int curses4j_mvwaddstr(long peer, int y, int x, String str);

    native int curses4j_mvwdelch(long peer, int y, int x);

    native int curses4j_mvwinsch(long peer, int y, int x, char ch);

    native int curses4j_nodelay(long peer, int bf);

    native int curses4j_scrollok(long peer, int bf);

    native long curses4j_subwin(long peer, int nlines, int ncols, int begy, int begx);

    native int curses4j_touchwin(long peer);

    native int curses4j_waddch(long peer, int ch);

    native int curses4j_waddstr(long peer, String str);

    native int curses4j_wattr_on(long peer, int attrs);

    native int curses4j_wattroff(long peer, int attrs);

    native int curses4j_wattron(long peer, int attrs);

    native int curses4j_wattrset(long peer, int attrs);

    native int curses4j_wbkgd(long peer, long ch);

    native int curses4j_wclear(long peer);

    native int curses4j_wgetch(long peer);

    native String curses4j_wgetnstr(long peer, int n);

    native int curses4j_wmove(long peer, int y, int x);

    native int curses4j_wprintw(long peer, String str);

    native int curses4j_wrefresh(long peer);
}

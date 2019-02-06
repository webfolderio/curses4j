package io.webfolder.curses4j;

import static io.webfolder.curses4j.Curses.ERR;
import static io.webfolder.curses4j.Curses.FALSE;
import static io.webfolder.curses4j.Curses.TRUE;
import static io.webfolder.curses4j.CursesWindow.curses4j_newwin;
import static java.lang.String.format;

public class Window {

    public static final Window stdscr = new Window();

    private final CursesWindow peer = new CursesWindow();

    public static String unctrl(int c) {
        return stdscr.peer.curses4j_unctrl(c);
    }

    /**
     * initscr() should be the first curses routine called. It will initialize all
     * curses data structures, and arrange that the first call to refresh() will
     * clear the screen.
     * <p>
     * In case of error, initscr() will write a message to standard error and end
     * the program.
     */
    static void initscr() {
        if (stdscr.peer.peer == 0) {
            stdscr.peer.peer = stdscr.peer.curses4j_initscr();
        } else {
            throw new IllegalStateException();
        }
    }

    static Window newwin(int nlines, int ncols, int begy, int begx) {
        long newwin = curses4j_newwin(nlines, ncols, begy, begx);
        if (newwin <= ERR) {
            return null;
        }
        Window window = new Window();
        window.peer.peer = newwin;
        return window;
    }

    public int addch(char ch) {
        return addch((int) ch);
    }

    public int addch(int ch) {
        return peer.curses4j_waddch(peer.peer, ch);
    }

    public int addstr(String str) {
        return peer.curses4j_waddstr(peer.peer, str);
    }

    /**
     * Turn on attrs in the current or specified window without affecting any
     * others.
     */
    public int attr_on(int attrs) {
        return peer.curses4j_wattr_on(peer.peer, attrs);
    }

    public int attroff(int attrs) {
        return peer.curses4j_wattroff(peer.peer, attrs);
    }

    public int attron(int attrs) {
        return peer.curses4j_wattron(peer.peer, attrs);
    }

    public int attrset(int attrs) {
        return peer.curses4j_wattrset(peer.peer, attrs);
    }

    public int bkgd(int ch) {
        return peer.curses4j_wbkgd(peer.peer, ch);
    }

    public int box(char verch, char horch) {
        return peer.curses4j_box(peer.peer, verch, horch);
    }

    public int clear() {
        return stdscr.peer.curses4j_wclear(peer.peer);
    }

    public Window derwin(int nlines, int ncols, int begy, int begx) {
        long subwin = peer.curses4j_derwin(peer.peer, nlines, ncols, begy, begx);
        if (subwin <= ERR) {
            return null;
        }
        Window window = new Window();
        window.peer.peer = subwin;
        return window;
    }

    public int getch() {
        return peer.curses4j_wgetch(peer.peer);
    }

    public int getmaxx() {
        return stdscr.peer.curses4j_getmaxx(peer.peer);
    }

    public int getmaxy() {
        return stdscr.peer.curses4j_getmaxy(peer.peer);
    }

    public String getnstr(int n) {
        return peer.curses4j_wgetnstr(peer.peer, n);
    }

    public int getparx() {
        return peer.curses4j_getparx(peer.peer);
    }

    public int getpary() {
        return peer.curses4j_getpary(peer.peer);
    }

    public int move(int y, int x) {
        return peer.curses4j_wmove(peer.peer, y, x);
    }

    public int mvaddstr(int y, int x, String str) {
        return peer.curses4j_mvwaddstr(peer.peer, y, x, str);
    }

    public int mvdelch(int y, int x) {
        return peer.curses4j_mvwdelch(peer.peer, y, x);
    }

    public int mvinsch(int y, int x, char ch) {
        return peer.curses4j_mvwinsch(peer.peer, y, x, ch);
    }

    public int nodelay(boolean bf) {
        return peer.curses4j_nodelay(peer.peer, bf ? TRUE : FALSE);
    }

    /**
     * Prints a string.
     */
    public int printw(String str, Object... args) {
        return peer.curses4j_wprintw(peer.peer, format(str, args));
    }

    /**
     * wrefresh() copies the named window to the physical terminal screen, taking
     * into account what is already there in order to optimize cursor movement.
     * <p>
     * These routines must be called to get any output on the terminal, as other
     * routines only manipulate data structures. Unless leaveok() has been enabled,
     * the physical cursor of the terminal is left at the location of the window's
     * cursor.
     * <p>
     * wnoutrefresh() and doupdate() allow multiple updates with more efficiency
     * than wrefresh() alone. wrefresh() works by first calling wnoutrefresh(),
     * which copies the named window to the virtual screen. It then calls
     * doupdate(), which compares the virtual screen to the physical screen and does
     * the actual update. A series of calls to wrefresh() will result in alternating
     * calls to wnoutrefresh() and doupdate(), causing several bursts of output to
     * the screen. By first calling wnoutrefresh() for each window, it is then
     * possible to call doupdate() only once.
     */
    public int refresh() {
        return peer.curses4j_wrefresh(peer.peer);
    }

    public int scrollok(boolean bf) {
        return peer.curses4j_scrollok(peer.peer, bf ? TRUE : FALSE);
    }

    public Window subwin(int nlines, int ncols, int begy, int begx) {
        long subwin = peer.curses4j_subwin(peer.peer, nlines, ncols, begy, begx);
        if (subwin <= ERR) {
            return null;
        }
        Window window = new Window();
        window.peer.peer = subwin;
        return window;
    }

    public int touchwin() {
        return peer.curses4j_touchwin(peer.peer);
    }
}

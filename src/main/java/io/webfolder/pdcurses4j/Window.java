package io.webfolder.pdcurses4j;

public class Window {

    public static final short COLOR_BLACK = 0;
    public static final short COLOR_RED = 1;
    public static final short COLOR_GREEN = 2;
    public static final short COLOR_BLUE = 4;
    public static final short COLOR_WHITE = 7;
    public static final short COLOR_CYAN = (COLOR_BLUE | COLOR_GREEN);
    public static final short COLOR_MAGENTA = (COLOR_RED | COLOR_BLUE);
    public static final short COLOR_YELLOW = (COLOR_RED | COLOR_GREEN);

    public static final long PDC_COLOR_SHIFT = 24;
    public static final long A_COLOR = 0xff000000;

    public static final int FALSE = 0;
    public static final int TRUE = 1;

    public static final int ERR = -1;
    public static final int OK = 0;

    private final PDCWindow peer = new PDCWindow();

    public static final Window stdscr = new Window();

    public static long COLOR_PAIR(long n) {
        return (n << PDC_COLOR_SHIFT) & A_COLOR;
    }

    public static long PAIR_NUMBER(long n) {
        return (n & A_COLOR) >> PDC_COLOR_SHIFT;
    }

    /**
     * initscr() should be the first curses routine called. It will initialize all
     * curses data structures, and arrange that the first call to refresh() will
     * clear the screen.
     * <p>
     * In case of error, initscr() will write a message to standard error and end
     * the program.
     */
    public static void initscr() {
        if (stdscr.peer.peer == 0) {
            stdscr.peer.peer = stdscr.peer.pdcurses4j_initscr();
        } else {
            throw new IllegalStateException();
        }
    }

    /**
     * initializes eight basic colors (black, red, green, yellow, blue, magenta,
     * cyan, and white), and two global variables: COLORS and COLOR_PAIRS
     * (respectively defining the maximum number of colors and color-pairs the
     * terminal is capable of displaying).
     */
    public static int start_color() {
        return stdscr.peer.pdcurses4j_start_color();
    }

    /**
     * init_pair() changes the definition of a color-pair.
     * <p>
     * It takes three arguments: the number of the color-pair to be redefined, and
     * the new values of the foreground and background colors. The pair number must
     * be between 0 and COLOR_PAIRS - 1, inclusive. The foreground and background
     * must be between 0 and COLORS - 1, inclusive. If the color pair was previously
     * initialized, the screen is refreshed, and all occurrences of that color-pair
     * are changed to the new definition.
     */
    public static int init_pair(int pair, short fg, short bg) {
        if (pair > Short.MAX_VALUE) {
            throw new RuntimeException("pair must be smaller than: " + Short.MAX_VALUE);
        } else {
            return stdscr.peer.pdcurses4j_init_pair((short) pair, fg, bg);
        }
    }

    /**
     * Turn on attrs in the current or specified window without affecting any
     * others.
     */
    public int attr_on(long attrs) {
        return peer.pdcurses4j_wattr_on(peer.peer, attrs);
    }

    /**
     * Prints a string.
     */
    public int printw(String str) {
        return peer.pdcurses4j_wprintw(peer.peer, str);
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
        return peer.pdcurses4j_wrefresh(peer.peer);
    }

    public int addch(int ch) {
        return addch((char) ch);
    }

    public int addch(char ch) {
        return peer.pdcurses4j_waddch(peer.peer, ch);
    }

    public int getch() {
        return peer.pdcurses4j_wgetch(peer.peer);
    }

    public static int endwin() {
        return stdscr.peer.pdcurses4j_endwin();
    }

    public int addstr(String str) {
        return peer.pdcurses4j_waddstr(peer.peer, str);
    }

    public int mvaddstr(int y, int x, String str) {
        return peer.pdcurses4j_mvwaddstr(peer.peer, y, x, str);
    }

    public int noecho() {
        return stdscr.peer.pdcurses4j_noecho();
    }

    public int nodelay(boolean bf) {
        return peer.pdcurses4j_nodelay(peer.peer, bf ? TRUE : FALSE);
    }

    public static int napms(int delay) {
        return stdscr.peer.pdcurses4j_napms(delay);
    }

    public int mvinsch(int y, int x, char ch) {
        return peer.pdcurses4j_mvwinsch(peer.peer, y, x, ch);
    }

    public int mvdelch(int y, int x) {
        return peer.pdcurses4j_mvwdelch(peer.peer, y, x);
    }

    public String getnstr(int n) {
        return peer.pdcurses4j_wgetnstr(peer.peer, n);
    }

    public static String unctrl(int c) {
        return stdscr.peer.pdcurses4j_unctrl(c);
    }

    public int getmaxx() {
        return stdscr.peer.pdcurses4j_getmaxx(peer.peer);
    }

    public int getmaxy() {
        return stdscr.peer.pdcurses4j_getmaxy(peer.peer);
    }

    public int clear() {
        return stdscr.peer.pdcurses4j_wclear(peer.peer);
    }

    public static int typeahead(int fields) {
        return stdscr.peer.pdcurses4j_typeahead(fields);
    }

    public static int def_shell_mode() {
        return stdscr.peer.pdcurses4j_def_shell_mode();
    }

    public static Window newwin(int nlines, int ncols, int begy, int begx) {
        long newwin = stdscr.peer.pdcurses4j_newwin(nlines, ncols, begy, begx);
        if (newwin <= ERR) {
            return null;
        }
        Window window = new Window();
        window.peer.peer = newwin;
        return window;
    }

    public int getpary() {
        return peer.pdcurses4j_getpary(peer.peer);
    }

    public int getparx() {
        return peer.pdcurses4j_getparx(peer.peer);
    }

    public int bkgd(long ch) {
        return peer.pdcurses4j_bkgd(peer.peer, ch);
    }

    public Window subwin(int nlines, int ncols, int begy, int begx) {
        long subwin = peer.pdcurses4j_subwin(peer.peer, nlines, ncols, begy, begx);
        if (subwin <= ERR) {
            return null;
        }
        Window window = new Window();
        window.peer.peer = subwin;
        return window;
    }

    public int touchwin() {
        return peer.pdcurses4j_touchwin(peer.peer);
    }

    public Window derwin(int nlines, int ncols, int begy, int begx) {
        long subwin = peer.pdcurses4j_derwin(peer.peer, nlines, ncols, begy, begx);
        if (subwin <= ERR) {
            return null;
        }
        Window window = new Window();
        window.peer.peer = subwin;
        return window;
    }
}

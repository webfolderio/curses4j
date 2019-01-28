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

    private final PDCWindow window;

    public static long COLOR_PAIR(long n) {
        return (n << PDC_COLOR_SHIFT) & A_COLOR;
    }

    public static long PAIR_NUMBER(long n) {
        return (n & A_COLOR) >> PDC_COLOR_SHIFT;
    }

    public Window() {
        this.window = new PDCWindow();
    }

    /**
     * initscr() should be the first curses routine called. It will initialize all
     * curses data structures, and arrange that the first call to refresh() will
     * clear the screen.
     * <p>
     * In case of error, initscr() will write a message to standard error and end
     * the program.
     */
    public void initscr() {
        window.peer = window.pdcurses4j_initscr();
    }

    /**
     * initializes eight basic colors (black, red, green, yellow, blue, magenta,
     * cyan, and white), and two global variables: COLORS and COLOR_PAIRS
     * (respectively defining the maximum number of colors and color-pairs the
     * terminal is capable of displaying).
     */
    public int start_color() {
        return window.pdcurses4j_start_color();
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
    public int init_pair(short pair, short fg, short bg) {
        return window.pdcurses4j_init_pair(pair, fg, bg);
    }

    /**
     * Turn on attrs in the current or specified window without affecting any
     * others.
     */
    public int wattr_on(long attrs) {
        return window.pdcurses4j_wattr_on(window.peer, attrs);
    }

    /**
     * Prints a string.
     */
    public int wprintw(String str) {
        return window.pdcurses4j_wprintw(window.peer, str);
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
    public int wrefresh() {
        return window.pdcurses4j_wrefresh(window.peer);
    }

    public int waddch(int ch) {
        return waddch((char) ch);
    }

    public int waddch(char ch) {
        return window.pdcurses4j_waddch(window.peer, ch);
    }

    public int wgetch() {
        return window.pdcurses4j_wgetch(window.peer);
    }

    public int endwin() {
        return window.pdcurses4j_endwin();
    }

    public int waddstr(String str) {
        return window.pdcurses4j_waddstr(window.peer, str);
    }

    public int mvwaddstr(int y, int x, String str) {
        return window.pdcurses4j_mvwaddstr(window.peer, y, x, str);
    }

    public int noecho() {
        return window.pdcurses4j_noecho();
    }

    public int nodelay(boolean bf) {
        return window.pdcurses4j_nodelay(window.peer, bf ? TRUE : FALSE);
    }

    public int napms(int delay) {
        return window.pdcurses4j_napms(delay);
    }

    public int mvwinsch(int y, int x, char ch) {
        return window.pdcurses4j_mvwinsch(window.peer, y, x, ch);
    }

    public int mvwdelch(int y, int x) {
        return window.pdcurses4j_mvwdelch(window.peer, y, x);
    }

    public String wgetnstr(int n) {
        return window.pdcurses4j_wgetnstr(window.peer, n);
    }
}

package io.webfolder.curses4j;

import static io.webfolder.curses4j.CursesWindow.*;
import static io.webfolder.curses4j.CursesWindow.curses4j_beep;
import static io.webfolder.curses4j.CursesWindow.curses4j_can_change_color;
import static io.webfolder.curses4j.CursesWindow.curses4j_color_pair;
import static io.webfolder.curses4j.CursesWindow.curses4j_color_pairs;
import static io.webfolder.curses4j.CursesWindow.curses4j_colors;
import static io.webfolder.curses4j.CursesWindow.curses4j_def_shell_mode;
import static io.webfolder.curses4j.CursesWindow.curses4j_endwin;
import static io.webfolder.curses4j.CursesWindow.curses4j_flash;
import static io.webfolder.curses4j.CursesWindow.curses4j_has_colors;
import static io.webfolder.curses4j.CursesWindow.curses4j_init_color;
import static io.webfolder.curses4j.CursesWindow.curses4j_init_pair;
import static io.webfolder.curses4j.CursesWindow.curses4j_napms;
import static io.webfolder.curses4j.CursesWindow.curses4j_noecho;
import static io.webfolder.curses4j.CursesWindow.curses4j_pair_number;
import static io.webfolder.curses4j.CursesWindow.curses4j_pdc_acs;
import static io.webfolder.curses4j.CursesWindow.curses4j_start_color;
import static io.webfolder.curses4j.CursesWindow.curses4j_typeahead;
import static io.webfolder.curses4j.CursesWindow.curses4j_unctrl;
import static io.webfolder.curses4j.Window.stdscr;

public class Curses {

    public static final short COLOR_BLACK   = 0;
    public static final short COLOR_RED     = 1;
    public static final short COLOR_GREEN   = 2;
    public static final short COLOR_BLUE    = 4;
    public static final short COLOR_WHITE   = 7;
    public static final short COLOR_CYAN    = COLOR_BLUE | COLOR_GREEN;
    public static final short COLOR_MAGENTA = COLOR_RED  | COLOR_BLUE ;
    public static final short COLOR_YELLOW  = COLOR_RED  | COLOR_GREEN;

    public static final int FALSE        = 0;
    public static final int TRUE         = 1;

    public static final int ERR          = -1;
    public static final int OK           =  0;

    /* Video attribute macros */
    public static final int A_NORMAL     = 0x00000000;
    public static final int A_COLOR      = 0xff000000;
    public static final int A_ALTCHARSET = 0x00010000;
    public static final int A_RIGHT      = 0x00020000;
    public static final int A_LEFT       = 0x00040000;
    public static final int A_ITALIC     = 0x00080000;
    public static final int A_UNDERLINE  = 0x00100000;
    public static final int A_REVERSE    = 0x00200000;
    public static final int A_BLINK      = 0x00400000;
    public static final int A_BOLD       = 0x00800000;

    public static final int A_ATTRIBUTES = 0xffff0000;
    public static final int A_CHARTEXT   = 0x0000ffff;

    public static final int A_LEFTLINE   = A_LEFT;
    public static final int A_RIGHTLINE  = A_RIGHT;
    public static final int A_STANDOUT   = A_REVERSE | A_BOLD; /* X/Open */

    public static final int A_DIM        = A_NORMAL;
    public static final int A_INVIS      = A_NORMAL;
    public static final int A_PROTECT    = A_NORMAL;

    public static final int A_HORIZONTAL = A_NORMAL;
    public static final int A_LOW        = A_NORMAL;
    public static final int A_TOP        = A_NORMAL;
    public static final int A_VERTICAL   = A_NORMAL;

    /* VT100-compatible symbols -- box chars */
    public static final int ACS_ULCORNER = PDC_ACS('l');
    public static final int ACS_LLCORNER = PDC_ACS('m');
    public static final int ACS_URCORNER = PDC_ACS('k');
    public static final int ACS_LRCORNER = PDC_ACS('j');
    public static final int ACS_RTEE     = PDC_ACS('u');
    public static final int ACS_LTEE     = PDC_ACS('t');
    public static final int ACS_BTEE     = PDC_ACS('v');
    public static final int ACS_TTEE     = PDC_ACS('w');
    public static final int ACS_HLINE    = PDC_ACS('q');
    public static final int ACS_VLINE    = PDC_ACS('x');
    public static final int ACS_PLUS     = PDC_ACS('n');

    /* VT100-compatible symbols -- other */
    public static final int ACS_S1       = PDC_ACS('o');
    public static final int ACS_S9       = PDC_ACS('s');
    public static final int ACS_DIAMOND  = PDC_ACS('`');
    public static final int ACS_CKBOARD  = PDC_ACS('a');
    public static final int ACS_DEGREE   = PDC_ACS('f');
    public static final int ACS_PLMINUS  = PDC_ACS('g');
    public static final int ACS_BULLET   = PDC_ACS('~');

    /* That goes double for these -- undocumented SysV symbols. Don't use them. */
    public static final int ACS_S3       = PDC_ACS('p');
    public static final int ACS_S7       = PDC_ACS('r');
    public static final int ACS_LEQUAL   = PDC_ACS('y');
    public static final int ACS_GEQUAL   = PDC_ACS('z');
    public static final int ACS_PI       = PDC_ACS('{');
    public static final int ACS_NEQUAL   = PDC_ACS('|');
    public static final int ACS_STERLING = PDC_ACS('}');

    @Deprecated
    public static final int CHR_MSK = A_CHARTEXT;
    @Deprecated
    public static final int ATR_MSK = A_ATTRIBUTES;
    @Deprecated
    public static final int ATR_NRM = A_NORMAL;

    public static int addch(int ch) {
        return stdscr.addch(ch);
    }

    public static int addstr(String str) {
        return stdscr.addstr(str);
    }

    public static int attroff(int attrs) {
        return stdscr.attroff(attrs);
    }

    public static int attron(int attrs) {
        return stdscr.attr_on(attrs);
    }

    public static int attrset(int attrs) {
        return stdscr.attrset(attrs);
    }

    public static int beep() {
        return curses4j_beep();
    }

    public static int bkgd(int ch) {
        return stdscr.bkgd(ch);
    }

    public static int box(char verch, char horch) {
        return stdscr.box(verch, horch);
    }

    public static boolean can_change_color() {
        return curses4j_can_change_color() == TRUE;
    }

    public static int clear() {
        return stdscr.clear();
    }

    public static int COLOR_PAIR(int n) {
        return curses4j_color_pair(n);
    }

    public static int COLOR_PAIRS() {
        return curses4j_color_pairs();
    }

    public static int COLORS() {
        return curses4j_colors();
    }

    public static int def_shell_mode() {
        return curses4j_def_shell_mode();
    }

    public static int endwin() {
        return curses4j_endwin();
    }

    public static int flash() {
        return curses4j_flash();
    }

    public static int getch() {
        return stdscr.getch();
    }

    public static String getnstr(int n) {
        return stdscr.getnstr(n);
    }

    public static int getparx() {
        return stdscr.getpary();
    }

    public static int getpary() {
        return stdscr.getparx();
    }

    public static String unctrl(int c) {
        return curses4j_unctrl(c);
    }

    public static boolean has_colors() {
        return curses4j_has_colors() == TRUE;
    }

    public static int init_color(short color, short red, short green, short blue) {
        return curses4j_init_color(color, red, green, blue);
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
            return curses4j_init_pair((short) pair, fg, bg);
        }
    }

    public static void initscr() {
        Window.initscr();
    }

    public static int move(int y, int x) {
        return stdscr.move(x, y);
    }

    public static int napms(int delay) {
        return curses4j_napms(delay);
    }

    public static Window newwin(int nlines, int ncols, int begy, int begx) {
        return Window.newwin(nlines, ncols, begy, begx);
    }

    public static int noecho() {
        return curses4j_noecho();
    }

    public static int PAIR_NUMBER(int n) {
        return curses4j_pair_number(n);
    }

    public static int PDC_ACS(int w) {
        return curses4j_pdc_acs(w);
    }

    public static int printw(String str, Object... args) {
        return stdscr.printw(str, args);
    }

    public static int refresh() {
        return stdscr.refresh();
    }

    public static int scrollok(boolean bf) {
        return stdscr.scrollok(bf);
    }

    public static int getmaxy() {
        return stdscr.getmaxy();
    }

    public static int getmaxx() {
        return stdscr.getmaxx();
    }

    public static int mvaddstr(int y, int x, String str) {
        return stdscr.mvaddstr(y, x, str);
    }

    public static int mvaddch(int y, int x, char ch) {
        return stdscr.mvaddch(y, x, ch);
    }

    public static int mvaddch(int y, int x, int ch) {
        return stdscr.mvaddch(y, x, ch);
    }

    public static int getcury() {
        return stdscr.getcury();
    }

    public static int getcurx() {
        return stdscr.getcurx();
    }

    /**
     * initializes eight basic colors (black, red, green, yellow, blue, magenta,
     * cyan, and white), and two global variables: COLORS and COLOR_PAIRS
     * (respectively defining the maximum number of colors and color-pairs the
     * terminal is capable of displaying).
     */
    public static int start_color() {
        return curses4j_start_color();
    }

    public static Window subwin(int nlines, int ncols, int begy, int begx) {
        return stdscr.subwin(nlines, ncols, begy, begx);
    }

    public static int touchwin() {
        return stdscr.touchwin();
    }

    public static int typeahead(int fields) {
        return curses4j_typeahead(fields);
    }

    public static int LINES() {
        return curses4j_lines();
    }

    public static int COLS() {
        return curses4j_cols();
    }

    public static void create_console() {
        curses4j_create_console();
    }
}

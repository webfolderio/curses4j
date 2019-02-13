package io.webfolder.curses4j;

import static io.webfolder.curses4j.CursesWindow.*;
import static io.webfolder.curses4j.CursesWindow.curses4j_beep;
import static io.webfolder.curses4j.CursesWindow.curses4j_can_change_color;
import static io.webfolder.curses4j.CursesWindow.curses4j_color_pair;
import static io.webfolder.curses4j.CursesWindow.curses4j_color_pairs;
import static io.webfolder.curses4j.CursesWindow.curses4j_colors;
import static io.webfolder.curses4j.CursesWindow.curses4j_cols;
import static io.webfolder.curses4j.CursesWindow.curses4j_create_console;
import static io.webfolder.curses4j.CursesWindow.curses4j_def_shell_mode;
import static io.webfolder.curses4j.CursesWindow.curses4j_echo;
import static io.webfolder.curses4j.CursesWindow.curses4j_endwin;
import static io.webfolder.curses4j.CursesWindow.curses4j_flash;
import static io.webfolder.curses4j.CursesWindow.curses4j_has_colors;
import static io.webfolder.curses4j.CursesWindow.curses4j_init_color;
import static io.webfolder.curses4j.CursesWindow.curses4j_init_pair;
import static io.webfolder.curses4j.CursesWindow.curses4j_lines;
import static io.webfolder.curses4j.CursesWindow.curses4j_napms;
import static io.webfolder.curses4j.CursesWindow.curses4j_noecho;
import static io.webfolder.curses4j.CursesWindow.curses4j_pair_number;
import static io.webfolder.curses4j.CursesWindow.curses4j_pdc_acs;
import static io.webfolder.curses4j.CursesWindow.curses4j_start_color;
import static io.webfolder.curses4j.CursesWindow.curses4j_typeahead;
import static io.webfolder.curses4j.CursesWindow.curses4j_unctrl;
import static io.webfolder.curses4j.CursesWindow.curses4j_unget_wch;
import static io.webfolder.curses4j.Window.stdscr;
import static java.io.File.pathSeparator;
import static java.lang.System.console;

import java.io.Console;

/**
 * curses api doc.:
 * 
 * @see <a href="https://github.com/wmcbrine/PDCurses/blob/master/man/MANUAL.md">PDCurses Manual</a>
 * 
 * @see <a href="https://pubs.opengroup.org/onlinepubs/007908799/cursesix.html">X/Open Curses Reference Pages</a>
 */
public class Curses {

    private static final boolean windows = ";".equals(pathSeparator);

    /*----------------------------------------------------------------------
    *
    *  Function and Keypad Key Definitions
    *  Many are just for compatibility
    *
    */
   public static final int KEY_CODE_YES  = 0x100;  /* If get_wch() gives a key code */

   public static final int KEY_BREAK     = 0x101;  /* Not on PC KBD */
   public static final int KEY_DOWN      = 0x102;  /* Down arrow key */
   public static final int KEY_UP        = 0x103;  /* Up arrow key */
   public static final int KEY_LEFT      = 0x104;  /* Left arrow key */
   public static final int KEY_RIGHT     = 0x105;  /* Right arrow key */
   public static final int KEY_HOME      = 0x106;  /* home key */
   public static final int KEY_BACKSPACE = 0x107;  /* not on pc */
   public static final int KEY_F0        = 0x108;  /* function keys; 64 reserved */

   public static final int KEY_DL        = 0x148;  /* delete line */
   public static final int KEY_IL        = 0x149;  /* insert line */
   public static final int KEY_DC        = 0x14a;  /* delete character */
   public static final int KEY_IC        = 0x14b;  /* insert char or enter ins mode */
   public static final int KEY_EIC       = 0x14c;  /* exit insert char mode */
   public static final int KEY_CLEAR     = 0x14d;  /* clear screen */
   public static final int KEY_EOS       = 0x14e;  /* clear to end of screen */
   public static final int KEY_EOL       = 0x14f;  /* clear to end of line */
   public static final int KEY_SF        = 0x150;  /* scroll 1 line forward */
   public static final int KEY_SR        = 0x151;  /* scroll 1 line back (reverse) */
   public static final int KEY_NPAGE     = 0x152;  /* next page */
   public static final int KEY_PPAGE     = 0x153;  /* previous page */
   public static final int KEY_STAB      = 0x154;  /* set tab */
   public static final int KEY_CTAB      = 0x155;  /* clear tab */
   public static final int KEY_CATAB     = 0x156;  /* clear all tabs */
   public static final int KEY_ENTER     = 0x157;  /* enter or send (unreliable) */
   public static final int KEY_SRESET    = 0x158;  /* soft/reset (partial/unreliable) */
   public static final int KEY_RESET     = 0x159;  /* reset/hard reset (unreliable) */
   public static final int KEY_PRINT     = 0x15a;  /* print/copy */
   public static final int KEY_LL        = 0x15b;  /* home down/bottom (lower left) */
   public static final int KEY_ABORT     = 0x15c;  /* abort/terminate key (any) */
   public static final int KEY_SHELP     = 0x15d;  /* short help */
   public static final int KEY_LHELP     = 0x15e;  /* long help */
   public static final int KEY_BTAB      = 0x15f;  /* Back tab key */
   public static final int KEY_BEG       = 0x160;  /* beg(inning) key */
   public static final int KEY_CANCEL    = 0x161;  /* cancel key */
   public static final int KEY_CLOSE     = 0x162;  /* close key */
   public static final int KEY_COMMAND   = 0x163;  /* cmd (command) key */
   public static final int KEY_COPY      = 0x164;  /* copy key */
   public static final int KEY_CREATE    = 0x165;  /* create key */
   public static final int KEY_END       = 0x166;  /* end key */
   public static final int KEY_EXIT      = 0x167;  /* exit key */
   public static final int KEY_FIND      = 0x168;  /* find key */
   public static final int KEY_HELP      = 0x169;  /* help key */
   public static final int KEY_MARK      = 0x16a;  /* mark key */
   public static final int KEY_MESSAGE   = 0x16b;  /* message key */
   public static final int KEY_MOVE      = 0x16c;  /* move key */
   public static final int KEY_NEXT      = 0x16d;  /* next object key */
   public static final int KEY_OPEN      = 0x16e;  /* open key */
   public static final int KEY_OPTIONS   = 0x16f;  /* options key */
   public static final int KEY_PREVIOUS  = 0x170;  /* previous object key */
   public static final int KEY_REDO      = 0x171;  /* redo key */
   public static final int KEY_REFERENCE = 0x172;  /* ref(erence) key */
   public static final int KEY_REFRESH   = 0x173;  /* refresh key */
   public static final int KEY_REPLACE   = 0x174;  /* replace key */
   public static final int KEY_RESTART   = 0x175;  /* restart key */
   public static final int KEY_RESUME    = 0x176;  /* resume key */
   public static final int KEY_SAVE      = 0x177;  /* save key */
   public static final int KEY_SBEG      = 0x178;  /* shifted beginning key */
   public static final int KEY_SCANCEL   = 0x179;  /* shifted cancel key */
   public static final int KEY_SCOMMAND  = 0x17a;  /* shifted command key */
   public static final int KEY_SCOPY     = 0x17b;  /* shifted copy key */
   public static final int KEY_SCREATE   = 0x17c;  /* shifted create key */
   public static final int KEY_SDC       = 0x17d;  /* shifted delete char key */
   public static final int KEY_SDL       = 0x17e;  /* shifted delete line key */
   public static final int KEY_SELECT    = 0x17f;  /* select key */
   public static final int KEY_SEND      = 0x180;  /* shifted end key */
   public static final int KEY_SEOL      = 0x181;  /* shifted clear line key */
   public static final int KEY_SEXIT     = 0x182;  /* shifted exit key */
   public static final int KEY_SFIND     = 0x183;  /* shifted find key */
   public static final int KEY_SHOME     = 0x184;  /* shifted home key */
   public static final int KEY_SIC       = 0x185;  /* shifted input key */

   public static final int KEY_SLEFT     = 0x187;  /* shifted left arrow key */
   public static final int KEY_SMESSAGE  = 0x188;  /* shifted message key */
   public static final int KEY_SMOVE     = 0x189;  /* shifted move key */
   public static final int KEY_SNEXT     = 0x18a;  /* shifted next key */
   public static final int KEY_SOPTIONS  = 0x18b;  /* shifted options key */
   public static final int KEY_SPREVIOUS = 0x18c;  /* shifted prev key */
   public static final int KEY_SPRINT    = 0x18d;  /* shifted print key */
   public static final int KEY_SREDO     = 0x18e;  /* shifted redo key */
   public static final int KEY_SREPLACE  = 0x18f;  /* shifted replace key */
   public static final int KEY_SRIGHT    = 0x190;  /* shifted right arrow */
   public static final int KEY_SRSUME    = 0x191;  /* shifted resume key */
   public static final int KEY_SSAVE     = 0x192;  /* shifted save key */
   public static final int KEY_SSUSPEND  = 0x193;  /* shifted suspend key */
   public static final int KEY_SUNDO     = 0x194;  /* shifted undo key */
   public static final int KEY_SUSPEND   = 0x195;  /* suspend key */
   public static final int KEY_UNDO      = 0x196;  /* undo key */

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

  ;  /* Video attribute macros */
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

    public static int addch(char ch) {
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
        return stdscr.move(y, x);
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

    public static int insch(char ch) {
        return stdscr.insch((int) ch);
    }

    public static int insch(int ch) {
        return stdscr.insch(ch);
    }

    public static int insstr(String str) {
        return stdscr.insstr(str);
    }

    public static boolean create_console() {
    	if ( ! windows ) {
    		return false;
    	}
    	Console console = console();
    	if (console == null) {
    		return curses4j_create_console() == TRUE ? true : false;
    	}
    	return false;
    }

    public static int insertln() {
        return stdscr.insertln();
    }

    public static int deleteln() {
        return stdscr.deleteln();        
    }

    public static int delch() {
        return stdscr.delch();
    }

    public static int insdelln(int n) {
        return stdscr.insdelln(n);
    }

    public static int clrtoeol() {
        return stdscr.clrtoeol();
    }

    public static int clrtobot() {
        return stdscr.clrtobot();
    }

    public static int nodelay(boolean bf) {
        return stdscr.nodelay(bf);
    }

    public static int ungetch(int ch) {
        return curses4j_unget_wch(ch);
    }

    public static int echo() {
        return curses4j_echo();
    }

    public static int keypad(boolean bf) {
        return stdscr.keypad(bf);
    }

    public static int flushinp() {
        return curses4j_flushinp();
    }
}

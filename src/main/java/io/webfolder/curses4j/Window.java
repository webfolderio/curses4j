package io.webfolder.curses4j;

import static io.webfolder.curses4j.Curses.ERR;
import static io.webfolder.curses4j.Curses.FALSE;
import static io.webfolder.curses4j.Curses.TRUE;
import static io.webfolder.curses4j.CursesWindow.curses4j_newwin;
import static java.lang.String.format;

public class Window {

    public static final Window stdscr = new Window();

    final CursesWindow peer = new CursesWindow();

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

    public int printw(String str, Object... args) {
        return peer.curses4j_wprintw(peer.peer, format(str, args));
    }

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

    public int mvaddch(int y, int x, char ch) {
        return peer.curses4j_mvwaddch(peer.peer, y, x, (int) ch);
    }

    public int mvaddch(int y, int x, int ch) {
        return peer.curses4j_mvwaddch(peer.peer, y, x, ch);
    }

    public int getcury() {
        return peer.curses4j_getcury(peer.peer);
    }

    public int getcurx() {
        return peer.curses4j_getcurx(peer.peer);
    }

    public int insertln() {
        return peer.curses4j_winsertln(peer.peer);
    }

    public int insch(int ch) {
        return peer.curses4j_winsch(peer.peer, ch);
    }

    public int insch(char ch) {
        return peer.curses4j_winsch(peer.peer, (int) ch);
    }

    public int insstr(String str) {
        return peer.curses4j_winsstr(peer.peer, str);
    }

    public int deleteln() {
        return peer.curses4j_wdeleteln(peer.peer);
    }

    public int delch() {
        return peer.curses4j_wdelch(peer.peer);
    }

    public int insdelln(int n) {
        return peer.curses4j_winsdelln(peer.peer, n);
    }

    public int clrtoeol() {
        return peer.curses4j_wclrtoeol(peer.peer);
    }

    public int clrtobot() {
        return peer.curses4j_wclrtobot(peer.peer);
    }

    public int keypad(boolean bf) {
        return peer.curses4j_keypad(peer.peer, bf ? TRUE : FALSE);
    }

    public int delwin() {
        return peer.curses4j_delwin(peer.peer);
    }

    public int border(int ls, int rs, int ts, int bs, int tl, int tr, int bl, int br) {
        return peer.curses4j_wborder(peer.peer, ls, rs, ts, bs, tl, tr, bl, br);
    }

    public int box(int verch, int horch) {
        return peer.curses4j_box(peer.peer, verch, horch);
    }

    public int mvwin(int y, int x) {
        return peer.curses4j_mvwin(peer.peer, y, x);
    }

    public int mvprint(int y, int x, String str, Object... args) {
        return peer.curses4j_mvwprintw(peer.peer, y, x, format(str, args));
    }

    public int scroll() {
        return peer.curses4j_scroll(peer.peer);
    }

    public int scrl(int n) {
        return peer.curses4j_wscrl(peer.peer, n);
    }

    public int setscrreg(int top, int bot) {
        return peer.curses4j_wsetscrreg(peer.peer, top, bot);
    }

    public int prefresh(int py, int px, int sy1, int sx1, int sy2, int sx2) {
        return peer.curses4j_prefresh(peer.peer, py, px, sy1, sx1, sy2, sx2);
    }

    public Window subpad(int nlines, int ncols, int begy, int begx) {
        long subpad = peer.curses4j_subpad(peer.peer, nlines, ncols, begy, begx);
        Window window = new Window();
        window.peer.peer = subpad;
        return window;
    }
}

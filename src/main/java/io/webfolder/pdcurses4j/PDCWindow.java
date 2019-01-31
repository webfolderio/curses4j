package io.webfolder.pdcurses4j;

class PDCWindow {

    long peer;

    static {
        System.load("C:\\projects\\pdcurses4j\\native\\wincon\\pdcurses.dll");
    }

    native long pdcurses4j_initscr();

    native int pdcurses4j_start_color();

    native int pdcurses4j_init_pair(short pair, short fg, short bg);

    native int pdcurses4j_wattr_on(long peer, long attrs);

    native int pdcurses4j_wprintw(long peer, String str);

    native int pdcurses4j_wrefresh(long peer);

    native int pdcurses4j_endwin();

    native int pdcurses4j_waddch(long peer, char ch);

    native int pdcurses4j_wgetch(long peer);

    native int pdcurses4j_waddstr(long peer, String str);

    native int pdcurses4j_mvwaddstr(long peer, int y, int x, String str);

    native int pdcurses4j_noecho();

    native int pdcurses4j_nodelay(long peer, int bf);

    native int pdcurses4j_napms(int delay);

    native int pdcurses4j_mvwinsch(long peer, int y, int x, char ch);

    native int pdcurses4j_mvwdelch(long peer, int y, int x);

    native String pdcurses4j_wgetnstr(long peer, int n);

    native String pdcurses4j_unctrl(int c);

    native int pdcurses4j_getmaxx(long peer);

    native int pdcurses4j_getmaxy(long peer);

    native int pdcurses4j_wclear(long peer);

    native int pdcurses4j_typeahead(int fields);

    native int pdcurses4j_def_shell_mode();

    native long pdcurses4j_newwin(int nlines, int ncols, int begy, int begx);

    native int pdcurses4j_getpary(long peer);

    native int pdcurses4j_getparx(long peer);

    native int pdcurses4j_bkgd(long peer, long ch);

    native long pdcurses4j_subwin(long peer, int nlines, int ncols, int begy, int begx);

    native int pdcurses4j_touchwin(long peer);

    native long pdcurses4j_derwin(long peer, int nlines, int ncols, int begy, int begx);

    native int pdcurses4j_scrollok(long peer, int bf);

    native int pdcurses4j_box(long peer, char verch, char horch);
}

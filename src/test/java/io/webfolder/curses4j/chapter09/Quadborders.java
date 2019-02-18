package io.webfolder.curses4j.chapter09;

import static io.webfolder.curses4j.Curses.COLOR_BLACK;
import static io.webfolder.curses4j.Curses.COLOR_BLUE;
import static io.webfolder.curses4j.Curses.COLOR_CYAN;
import static io.webfolder.curses4j.Curses.COLOR_GREEN;
import static io.webfolder.curses4j.Curses.COLOR_PAIR;
import static io.webfolder.curses4j.Curses.COLOR_RED;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.getmaxx;
import static io.webfolder.curses4j.Curses.getmaxy;
import static io.webfolder.curses4j.Curses.init_pair;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.newwin;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.start_color;

import io.webfolder.curses4j.Window;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/09-11_quadborders.php
 */
public class Quadborders {

    public static void main(String[] args) {
        Window a, b, c, d;
        int maxx, maxy, halfx, halfy;

        /* initialize stuff */
        initscr();
        refresh();
        start_color();
        init_pair(1, COLOR_BLACK, COLOR_BLUE);
        init_pair(2, COLOR_BLACK, COLOR_RED);
        init_pair(3, COLOR_BLACK, COLOR_GREEN);
        init_pair(4, COLOR_BLACK, COLOR_CYAN);

        /* calculate window sizes and locations */
        maxx = getmaxx();
        maxy = getmaxy();

        halfx = maxx >> 1;
        halfy = maxy >> 1;

        /* create four quarter windows */
        a = newwin(halfy, halfx, 0, 0);
        b = newwin(halfy, halfx, 0, halfx);
        c = newwin(halfy, halfx, halfy, 0);
        d = newwin(halfy, halfx, halfy, halfx);
        if (a == null || b == null || c == null || d == null) {
            endwin();
            System.err.println("Some kind of error creating the windows");
            System.exit(1);
        }

        /* Write to each window */
        /*
         * Don't forget to remove the newlines! and offset the text
         */
        a.bkgd(COLOR_PAIR(1));
        a.box(0, 0);
        a.mvaddstr(1, 1, "This is window A");
        b.bkgd(COLOR_PAIR(2));
        b.box(0, 0);
        b.mvaddstr(1, 1, "This is window B");
        c.bkgd(COLOR_PAIR(3));
        c.box(0, 0);
        c.mvaddstr(1, 1, "This is window C");
        d.bkgd(COLOR_PAIR(4));
        d.box(0, 0);
        d.mvaddstr(1, 1, "This is window D");
        /* update the windows */
        a.refresh();
        b.refresh();
        c.refresh();
        d.refresh();
        /* pause */
        getch();

        endwin();
    }
}

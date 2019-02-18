package io.webfolder.curses4j.chapter11;

import static io.webfolder.curses4j.Curses.COLOR_BLUE;
import static io.webfolder.curses4j.Curses.COLOR_PAIR;
import static io.webfolder.curses4j.Curses.COLOR_RED;
import static io.webfolder.curses4j.Curses.COLOR_WHITE;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.init_pair;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.newwin;
import static io.webfolder.curses4j.Curses.overwrite;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.start_color;

import io.webfolder.curses4j.Window;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/11-02_overwrite2.php
 */
public class Overwrite2 {

    public static void main(String[] args) {
        Window red, blue;

        initscr();
        refresh();

        /* colors */
        start_color();
        init_pair(1, COLOR_WHITE, COLOR_RED);
        init_pair(2, COLOR_WHITE, COLOR_BLUE);

        /* create windows */
        red = newwin(10, 20, 2, 22);
        blue = newwin(10, 20, 5, 32);
        if (red == null || blue == null) {
            endwin();
            System.err.println("Unable to create windows");
            System.exit(1);
        }

        /* color and fill windows */
        red.bkgd(COLOR_PAIR(1) | 'r');
        blue.bkgd(COLOR_PAIR(2) | 'b');
        red.refresh();
        blue.refresh();
        getch();

        /* overwrite windows */
        overwrite(red, blue);
        red.bkgd(COLOR_PAIR(1) | ' ');
        red.refresh();
        blue.refresh();
        getch();

        endwin();
    }
}

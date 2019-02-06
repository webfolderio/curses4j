package io.webfolder.curses4j.chapter03;

import static io.webfolder.curses4j.Curses.COLORS;
import static io.webfolder.curses4j.Curses.COLOR_PAIRS;
import static io.webfolder.curses4j.Curses.OK;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.has_colors;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.printw;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.start_color;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/03-03_colortest.php
 */
public class Colortest {

    public static void main(String[] args) {
        initscr();

        /* test for color ability of the terminal */
        if (!has_colors()) {
            endwin(); /* exit Ncurses */
            System.err.println("Terminal cannot do colors");
            System.exit(1);
        }

        /* initialize Ncurses colors */
        if (start_color() != OK) {
            endwin();
            System.err.println("Unable to start colors.");
            System.exit(1);
        }

        /* colors are okay; continue */
        printw("Colors initialized.\n");
        printw("%d colors available.\n", COLORS());
        printw("%d color pairs.", COLOR_PAIRS());
        refresh();
        getch();

        endwin();
    }
}

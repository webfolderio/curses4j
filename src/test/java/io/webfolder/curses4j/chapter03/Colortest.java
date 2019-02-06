package io.webfolder.curses4j.chapter03;

import static io.webfolder.curses4j.Window.COLORS;
import static io.webfolder.curses4j.Window.COLOR_PAIRS;
import static io.webfolder.curses4j.Window.OK;
import static io.webfolder.curses4j.Window.endwin;
import static io.webfolder.curses4j.Window.has_colors;
import static io.webfolder.curses4j.Window.initscr;
import static io.webfolder.curses4j.Window.start_color;
import static io.webfolder.curses4j.Window.stdscr;

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
        stdscr.printw("Colors initialized.\n");
        stdscr.printw("%d colors available.\n", COLORS());
        stdscr.printw("%d color pairs.", COLOR_PAIRS());
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

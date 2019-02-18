package io.webfolder.curses4j.chapter09;

import static io.webfolder.curses4j.Curses.COLS;
import static io.webfolder.curses4j.Curses.LINES;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.newwin;
import static io.webfolder.curses4j.Curses.refresh;

import io.webfolder.curses4j.Window;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/09-07_twowin.php
 */
public class Twowin {

    public static void main(String[] args) {
        Window one, two;

        initscr();

        /* update the standard screen regardless */
        refresh();
        /* create two half-size windows */
        one = newwin(LINES(), COLS() / 2, 0, 0);
        two = newwin(LINES(), COLS() / 2, 0, COLS() / 2);
        if (one == null || two == null) {
            endwin();
            System.err.println("Unable to create windows");
            System.exit(1);
        }

        /* set backgrounds and text */
        one.bkgd('|');
        one.addstr("Window One\n");
        two.bkgd('-');
        two.addstr("Window Two\n");

        /* update screen */
        one.refresh();
        getch();
        two.refresh();
        getch();

        /* remove window 1 */
        one.delwin();
        two.addstr("Window one deleted\n");
        two.refresh();
        getch();

        endwin();
    }
}

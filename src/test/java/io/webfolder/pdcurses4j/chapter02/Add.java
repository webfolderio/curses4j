package io.webfolder.pdcurses4j.chapter02;

import static io.webfolder.pdcurses4j.Window.endwin;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.stdscr;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/02-03_add2.php
 */
public class Add {

    public static void main(String[] args) {
        String t1 = "Shall I compare thee";
        String t2 = " to a summer's day?";

        initscr();
        stdscr.addstr(t1); /* add the first string */
        stdscr.addstr(t2); /* add the second string */
        stdscr.refresh(); /* display the result */
        stdscr.getch(); /* wait */

        endwin();
    }
}
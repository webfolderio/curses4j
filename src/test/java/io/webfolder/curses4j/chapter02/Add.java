package io.webfolder.curses4j.chapter02;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/02-03_add2.php
 */
public class Add {

    public static void main(String[] args) {
        String t1 = "Shall I compare thee";
        String t2 = " to a summer's day?";

        initscr();
        addstr(t1); /* add the first string */
        addstr(t2); /* add the second string */
        refresh(); /* display the result */
        getch(); /* wait */

        endwin();
    }
}

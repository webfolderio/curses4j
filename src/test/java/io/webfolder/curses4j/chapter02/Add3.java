package io.webfolder.curses4j.chapter02;

import static io.webfolder.curses4j.Window.endwin;
import static io.webfolder.curses4j.Window.initscr;
import static io.webfolder.curses4j.Window.stdscr;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/02-04_add3.php
 */
public class Add3 {

    public static void main(String[] args) {
        String t1 = "Shall I compare thee";
        String t2 = " to a summer's day?";

        initscr();
        stdscr.addstr(t1); /* add the first string */
        stdscr.addstr(t2); /* add the second string */
        stdscr.move(2, 0); /* row 3, column 1 */
        stdscr.addstr("Though art more lovely...");
        stdscr.refresh(); /* display the result */
        stdscr.getch(); /* wait */

        endwin();
    }
}

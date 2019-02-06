package io.webfolder.curses4j.chapter02;

import static io.webfolder.curses4j.Curses.addch;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.napms;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/02-02_add1.php
 */
public class Add1 {

    public static void main(String[] args) {
        String text = "Greetings from Ncurses!";

        initscr(); /* initialize NCurses */

        /* loop through the string */
        for (int i = 0; i < text.length(); i++) {
            addch(text.charAt(i)); /* one char to output */
            refresh(); /* update the screen */
            napms(100); /* delay .1 sec */
        }
        getch(); /* wait here */

        endwin(); /* clean up NCurses */
    }
}

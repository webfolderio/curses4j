package io.webfolder.pdcurses4j.chapter02;

import static io.webfolder.pdcurses4j.Window.endwin;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.napms;
import static io.webfolder.pdcurses4j.Window.stdscr;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/02-02_add1.php
 */
public class Add1 {

    public static void main(String[] args) {
        String text = "Greetings from Ncurses!";

        initscr(); /* initialize NCurses */

        /* loop through the string */
        for (int i = 0; i < text.length(); i++) {
            stdscr.addch(text.charAt(i)); /* one char to output */
            stdscr.refresh(); /* update the screen */
            napms(100); /* delay .1 sec */
        }
        stdscr.getch(); /* wait here */

        endwin(); /* clean up NCurses */
    }
}

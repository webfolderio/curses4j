package io.webfolder.curses4j.chapter08;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.flushinp;
import static io.webfolder.curses4j.Curses.getnstr;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.napms;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/08-09_flush.php
 */
public class Flush {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        String buffer;

        initscr();

        addstr("Type. I'll wait...\n");
        refresh();
        napms(5000);            /* 5 seconds */

        addstr("Flushing buffer.\n");
        flushinp();
        addstr("Here is what you typed:\n");
        buffer = getnstr(80);

        endwin();
    }
}

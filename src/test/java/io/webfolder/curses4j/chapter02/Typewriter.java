package io.webfolder.curses4j.chapter02;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * https://c-for-dummies.com/ncurses/source_code/02-06_typewriter.php
 */
public class Typewriter {

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        int ch = 0;

        initscr();
        addstr("Type a few lines of text\n");
        addstr("Press ~ to quit\n");
        refresh();

        while ((ch = getch()) != '~')
            ;

        endwin();
    }
}

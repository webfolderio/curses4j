package io.webfolder.curses4j.chapter05;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.getcurx;
import static io.webfolder.curses4j.Curses.getcury;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.printw;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/05-05_whereami.php
 */
public class Whereami {

    public static void main(String[] args) {
        initscr();

        addstr("Type some text; '~' to end:\n");
        refresh();

        @SuppressWarnings("unused")
        int ch;
        while ((ch = getch()) != '~')
            ;

        int row = getcurx();
        int col = getcury();

        printw("\n\nThe cursor was at position %d, %d ", row, col);
        printw("when you stopped typing.");
        refresh();
        getch();

        endwin();
    }
}

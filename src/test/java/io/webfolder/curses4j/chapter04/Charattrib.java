package io.webfolder.curses4j.chapter04;

import static io.webfolder.curses4j.Curses.A_BOLD;
import static io.webfolder.curses4j.Curses.A_REVERSE;
import static io.webfolder.curses4j.Curses.addch;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/04-01_charattrib.php
 */
public class Charattrib {

    public static void main(String[] args) {
        initscr();

        addch('c');
        addch(A_BOLD | 'a');
        addch(A_REVERSE | 't');
        refresh();
        getch();

        endwin();
    }
}

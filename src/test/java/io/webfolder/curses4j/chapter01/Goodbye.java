package io.webfolder.curses4j.chapter01;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/01-02_goodbye-final.php
 */
public class Goodbye {

    public static void main(String[] args) {
        initscr();
        addstr("Goodbye, cruel world!");
        refresh();
        getch();
        endwin();
    }
}

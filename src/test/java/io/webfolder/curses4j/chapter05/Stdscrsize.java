package io.webfolder.curses4j.chapter05;

import static io.webfolder.curses4j.Curses.COLS;
import static io.webfolder.curses4j.Curses.LINES;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.printw;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/05-02_stdscrsize.php
 */
public class Stdscrsize {

    public static void main(String[] args) {
        initscr();

        printw("Window is %d rows, %d columns.\n", LINES(), COLS());
        refresh();
        getch();

        endwin();
    }
}

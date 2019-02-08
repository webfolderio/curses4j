package io.webfolder.curses4j.chapter05;

import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.getmaxx;
import static io.webfolder.curses4j.Curses.getmaxy;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.printw;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/05-01_screensize.php
 */
public class Screensize {

    public static void main(String[] args) {
        initscr();

        int x = getmaxx();
        int y = getmaxy();
        printw("Window is %d rows, %d columns.\n", y, x);
        refresh();
        getch();

        endwin();
    }
}

package io.webfolder.curses4j.chapter12;

import static io.webfolder.curses4j.Curses.LINES;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.mvprintw;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.scrl;
import static io.webfolder.curses4j.Curses.scrollok;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/12-05_scrup3.php
 */
public class Scrup3 {

    public static void main(String[] args) {
        int y;

        initscr();

        scrollok(true);
        for (y = 0; y <= LINES(); y++)
            mvprintw(y, 0, "Line %d", y);
        refresh();
        getch();

        scrl(3);
        refresh();
        getch();

        endwin();
    }
}

package io.webfolder.curses4j.chapter03;

import static io.webfolder.curses4j.Curses.COLOR_BLUE;
import static io.webfolder.curses4j.Curses.COLOR_PAIR;
import static io.webfolder.curses4j.Curses.COLOR_WHITE;
import static io.webfolder.curses4j.Curses.bkgd;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.init_pair;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.start_color;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/03-07_bgcolor1.php
 */
public class Bgcolor1 {

    public static void main(String[] args) {
        initscr();

        start_color();
        init_pair(1, COLOR_WHITE, COLOR_BLUE);
        bkgd(COLOR_PAIR(1));
        refresh();
        getch();

        endwin();
    }
}

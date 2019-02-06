package io.webfolder.curses4j.chapter03;

import static io.webfolder.curses4j.Window.COLOR_BLUE;
import static io.webfolder.curses4j.Window.COLOR_PAIR;
import static io.webfolder.curses4j.Window.COLOR_WHITE;
import static io.webfolder.curses4j.Window.endwin;
import static io.webfolder.curses4j.Window.init_pair;
import static io.webfolder.curses4j.Window.initscr;
import static io.webfolder.curses4j.Window.start_color;
import static io.webfolder.curses4j.Window.stdscr;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/03-07_bgcolor1.php
 */
public class Bgcolor1 {

    public static void main(String[] args) {
        initscr();

        start_color();
        init_pair(1, COLOR_WHITE, COLOR_BLUE);
        stdscr.bkgd(COLOR_PAIR(1));
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

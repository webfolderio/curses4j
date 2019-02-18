package io.webfolder.curses4j.chapter09;

import static io.webfolder.curses4j.Curses.box;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/09-10_box.php
 */
public class Box {

    public static void main(String[] args) {
        initscr();

        box(0, 0);
        refresh();
        getch();

        endwin();
    }
}

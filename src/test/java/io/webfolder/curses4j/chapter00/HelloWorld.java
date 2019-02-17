package io.webfolder.curses4j.chapter00;

import static io.webfolder.curses4j.Curses.box;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/00-01_box.php
 */
public class HelloWorld {

    public static void main(String[] args) {
        initscr();

        box('*', '*');
        refresh();
        getch();

        endwin();
    }
}

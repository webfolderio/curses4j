package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.endwin;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.stdscr;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/00-01_box.php
 */
public class HelloWorld {

    public static void main(String[] args) {
        initscr();

        stdscr.box('*', '*');
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

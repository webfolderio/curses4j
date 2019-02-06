package io.webfolder.curses4j.chapter01;

import static io.webfolder.curses4j.Window.endwin;
import static io.webfolder.curses4j.Window.initscr;
import static io.webfolder.curses4j.Window.stdscr;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/01-02_goodbye-final.php
 */
public class Goodbye {

    public static void main(String[] args) {
        initscr();
        stdscr.addstr("Goodbye, cruel world!");
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

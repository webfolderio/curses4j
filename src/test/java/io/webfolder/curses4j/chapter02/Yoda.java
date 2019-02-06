package io.webfolder.curses4j.chapter02;

import static io.webfolder.curses4j.Window.endwin;
import static io.webfolder.curses4j.Window.initscr;
import static io.webfolder.curses4j.Window.stdscr;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/02-05_yoda.php
 */
public class Yoda {

    public static void main(String[] args) {
        int yoda = 874;
        int ss = 65;

        initscr();
        stdscr.printw("Yoda is %d years old\n", yoda);
        stdscr.printw("He has collected %d years", yoda - ss);
        stdscr.printw(" of Social Security.");
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

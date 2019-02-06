package io.webfolder.curses4j.chapter02;

import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.printw;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/02-05_yoda.php
 */
public class Yoda {

    public static void main(String[] args) {
        int yoda = 874;
        int ss = 65;

        initscr();
        printw("Yoda is %d years old\n", yoda);
        printw("He has collected %d years", yoda - ss);
        printw(" of Social Security.");
        refresh();
        getch();

        endwin();
    }
}

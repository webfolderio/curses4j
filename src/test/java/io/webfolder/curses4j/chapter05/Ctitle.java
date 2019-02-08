package io.webfolder.curses4j.chapter05;

import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.getmaxx;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.mvaddstr;
import static io.webfolder.curses4j.Curses.refresh;

public class Ctitle {

    /**
     * @see https://c-for-dummies.com/ncurses/source_code/05-04_ctitle.php
     */
    public static void main(String[] args) {
        initscr();

        center(1, "Penguin Soccer Finals");
        center(5, "Cattle Dung Samples from Temecula");
        center(7, "Catatonic Theater");
        center(9, "Why Do Ions Hate Each Other?");
        getch();

        endwin();
    }

    static void center(int row, String title) {
        /* get screen width */
        int width = getmaxx();
        /* get title length */
        int len = title.length();
        /* calculate indent */
        int indent = (width - len) / 2;
        /* show the string */
        mvaddstr(row, indent, title);
        refresh();
    }
}

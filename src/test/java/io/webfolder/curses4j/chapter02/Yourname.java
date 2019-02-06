package io.webfolder.curses4j.chapter02;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.getnstr;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.printw;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/02-07_yourname.php
 */
public class Yourname {

    public static void main(String[] args) {
        String first;
        String last;

        initscr();
        addstr("What is your first name? ");
        refresh();
        first = getnstr(23);

        addstr("What is your last name? ");
        refresh();
        last = getnstr(31);

        printw("Pleased to meet you, %s %s!", first, last);
        refresh();
        getch();

        endwin();
    }
}

package io.webfolder.pdcurses4j.chapter02;

import static io.webfolder.pdcurses4j.Window.endwin;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.stdscr;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/02-07_yourname.php
 */
public class Yourname {

    public static void main(String[] args) {
        String first;
        String last;

        initscr();
        stdscr.addstr("What is your first name? ");
        stdscr.refresh();
        first = stdscr.getnstr(23);

        stdscr.addstr("What is your last name? ");
        stdscr.refresh();
        last = stdscr.getnstr(31);

        stdscr.printw("Pleased to meet you, %s %s!", first, last);
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

package io.webfolder.curses4j.chapter08;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.getnstr;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.printw;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/08-07_greetings.php
 */
public class Greetings {

    public static void main(String[] args) {
        String first;
        String last;

        initscr();

        addstr("First name: ");
        first = getnstr(32);
        addstr("Last name: ");
        last = getnstr(31);
        printw("Pleased to meet you, %s %s\n", first, last);
        refresh();
        getch();

        endwin();
    }
}

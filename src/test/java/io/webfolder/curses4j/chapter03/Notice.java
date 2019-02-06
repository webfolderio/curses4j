package io.webfolder.curses4j.chapter03;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.beep;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.flash;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/03-09_notice.php
 */
public class Notice {

    public static void main(String[] args) {
        initscr();

        addstr("Attention!\n");
        beep();
        refresh();
        getch();

        addstr("I said, ATTENTION!\n");
        flash();
        refresh();
        getch();

        endwin();
    }
}

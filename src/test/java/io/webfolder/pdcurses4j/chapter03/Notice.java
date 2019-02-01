package io.webfolder.pdcurses4j.chapter03;

import static io.webfolder.pdcurses4j.Window.*;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/03-09_notice.php
 */
public class Notice {

    public static void main(String[] args) {
        initscr();

        stdscr.addstr("Attention!\n");
        beep();
        stdscr.refresh();
        stdscr.getch();

        stdscr.addstr("I said, ATTENTION!\n");
        flash();
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

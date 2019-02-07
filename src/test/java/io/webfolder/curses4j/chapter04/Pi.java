package io.webfolder.curses4j.chapter04;

import static io.webfolder.curses4j.Curses.ACS_PI;
import static io.webfolder.curses4j.Curses.A_ALTCHARSET;
import static io.webfolder.curses4j.Curses.addch;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/04-04_pi.php
 */
public class Pi {

    public static void main(String[] args) {
        initscr();
        addch(A_ALTCHARSET | ACS_PI);
        addstr(" = 3.14159");
        refresh();
        getch();
        endwin();
    }
}

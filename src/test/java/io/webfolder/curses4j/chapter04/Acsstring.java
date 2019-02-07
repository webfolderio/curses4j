package io.webfolder.curses4j.chapter04;

import static io.webfolder.curses4j.Curses.A_ALTCHARSET;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.attrset;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/04-06_acsstring.php
 */
public class Acsstring {

    public static void main(String[] args) {
        initscr();

        attrset(A_ALTCHARSET);
        addstr("Hello there!");
        refresh();
        getch();
            
        endwin();
    }
}

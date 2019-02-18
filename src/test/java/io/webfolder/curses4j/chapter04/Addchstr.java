package io.webfolder.curses4j.chapter04;

import static io.webfolder.curses4j.Curses.A_BOLD;
import static io.webfolder.curses4j.Curses.A_REVERSE;
import static io.webfolder.curses4j.Curses.A_UNDERLINE;
import static io.webfolder.curses4j.Curses.addch;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/04-09_addchstr.php
 */
public class Addchstr {

    public static void main(String[] args) {
        int string[] = { 'H' | A_BOLD, 'e', 'l' | A_REVERSE, 'l' | A_REVERSE, 'o', '!' | A_UNDERLINE, 0 };

        initscr();

        for (int i = 0; i < string.length; i++) {
            addch(string[i]);
        }

        refresh();
        getch();

        endwin();
    }
}

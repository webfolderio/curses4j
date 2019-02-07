package io.webfolder.curses4j.chapter04;

import static io.webfolder.curses4j.Curses.addch;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/04-12_ustring.php
 */
public class Ustring {

    public static void main(String[] args) {
        int hello[] = { 0x041f, 0x0440, 0x0438, 0x0432, 0x0435, 0x0442, 0x0021 };

        initscr();

        for (int i = 0; i < hello.length; i++) {
            addch(hello[i]);
        }

        refresh();
        getch();

        endwin();
    }
}

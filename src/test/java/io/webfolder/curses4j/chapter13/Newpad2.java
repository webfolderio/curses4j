package io.webfolder.curses4j.chapter13;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.newpad;
import static io.webfolder.curses4j.Curses.refresh;

import io.webfolder.curses4j.Window;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/13-02_newpad2.php
 */
public class Newpad2 {

    public static void main(String[] args) {
        Window p;
        int x;

        initscr();

        /* create a new pad */
        p = newpad(50, 100);
        if (p == null) {
            endwin();
            System.err.println("Unable to create pad");
            System.exit(1);
        }

        /* fill the pad */
        for (x = 0; x < 500; x++)
            p.printw("%4d", x);

        addstr("Press Enter to update");
        refresh();
        getch();

        p.prefresh(0, 0, 5, 5, 16, 45);
        getch();

        endwin();
    }
}

package io.webfolder.curses4j.chapter13;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.newpad;
import static io.webfolder.curses4j.Curses.refresh;

import io.webfolder.curses4j.Window;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/13-03_sonofpad.php
 */
public class Sonofpad {

    public static void main(String[] args) {
        Window pop, son;
        int x;

        initscr();

        /* create a new pad */
        pop = newpad(50, 50);
        if (pop == null) {
            endwin();
            System.err.println("Unable to create pad");
            System.exit(1);
        }

        /* fill the pad */
        for (x = 0; x < 50; x++)
            pop.addstr("Hello ");

        /* create the subpad */
        son = pop.subpad(10, 10, 0, 0);
        if (son == null) {
            endwin();
            System.err.println("Unable to create subpad");
            System.exit(1);
        }

        addstr("Press Enter to update");
        refresh();
        getch();

        son.prefresh(0, 0, 5, 5, 15, 15);
        getch();

        endwin();
    }
}

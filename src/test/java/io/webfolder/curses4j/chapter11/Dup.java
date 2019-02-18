package io.webfolder.curses4j.chapter11;

import static io.webfolder.curses4j.Curses.dupwin;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.newwin;
import static io.webfolder.curses4j.Curses.refresh;

import io.webfolder.curses4j.Window;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/11-06_dup.php
 */
public class Dup {

    public static void main(String[] args) {
        Window fred, barney;

        initscr();
        refresh();

        /* Build window & wait */
        fred = newwin(0, 0, 0, 0);
        fred.addstr("This is Fred.\n");
        fred.refresh();
        getch();

        /* Create and show barney */
        barney = dupwin(fred);
        barney.addstr("This is Barney.\n");
        barney.refresh();
        getch();

        /* Go back to fred */
        fred.addstr("Nice to see you!\n");
        fred.refresh();
        getch();

        /* One more time to barney */
        barney.addstr("You too!\n");
        barney.touchwin();
        barney.refresh();
        getch();

        endwin();
    }
}

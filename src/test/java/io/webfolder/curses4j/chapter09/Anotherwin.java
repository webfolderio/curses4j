package io.webfolder.curses4j.chapter09;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.newwin;
import static io.webfolder.curses4j.Curses.refresh;

import io.webfolder.curses4j.Window;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/09-01_anotherwin.php
 */
public class Anotherwin {

    public static void main(String[] args) {
        Window another;

        initscr();

        addstr("This is the standard screen\n");
        refresh();
        getch();

        /* create another window */
        another = newwin(0, 0, 0, 0);
        if (another == null) {
            addstr("Unable to create window");
            refresh();
            getch();
        } else {
            another.addstr("This is another window");
            another.refresh();
            another.getch();
        }

        endwin();
    }
}

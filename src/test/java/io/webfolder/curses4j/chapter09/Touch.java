package io.webfolder.curses4j.chapter09;

import static io.webfolder.curses4j.Curses.COLOR_BLUE;
import static io.webfolder.curses4j.Curses.COLOR_PAIR;
import static io.webfolder.curses4j.Curses.COLOR_RED;
import static io.webfolder.curses4j.Curses.COLOR_WHITE;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.bkgd;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.init_pair;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.newwin;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.start_color;
import static io.webfolder.curses4j.Curses.touchwin;

import io.webfolder.curses4j.Window;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/09-04_touch.php
 */
public class Touch {

    public static void main(String[] args) {
        Window second;

        initscr();
        start_color();

        /* configure colors */
        init_pair(1, COLOR_WHITE, COLOR_BLUE);
        init_pair(2, COLOR_WHITE, COLOR_RED);

        /* create the second window */
        second = newwin(0, 0, 0, 0);
        if (second == null) {
            endwin();
            System.err.println("Unable to create window");
            System.exit(1);
        }
        second.bkgd(COLOR_PAIR(2));
        second.addstr("This is the second window\n");

        /* standard screen */
        bkgd(COLOR_PAIR(1));
        addstr("This is the standard screen\n");
        addstr("Press Enter");
        refresh();
        getch();
        /* show second window */
        second.refresh();
        getch();
        /* show standard screen again */
        touchwin();
        refresh();
        getch();

        endwin();
    }
}

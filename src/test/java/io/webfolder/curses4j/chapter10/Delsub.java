package io.webfolder.curses4j.chapter10;

import static io.webfolder.curses4j.Curses.COLOR_BLACK;
import static io.webfolder.curses4j.Curses.COLOR_BLUE;
import static io.webfolder.curses4j.Curses.COLOR_PAIR;
import static io.webfolder.curses4j.Curses.COLS;
import static io.webfolder.curses4j.Curses.LINES;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.init_pair;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.mvaddstr;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.start_color;
import static io.webfolder.curses4j.Curses.subwin;

import io.webfolder.curses4j.Window;

public class Delsub {

    public static void main(String[] args) {
        Window sub;
        int x;

        initscr();
        start_color();
        init_pair(1, COLOR_BLACK, COLOR_BLUE);

        /* create subwindow */
        sub = subwin(LINES() - 10, COLS() - 10, 4, 5);
        if (sub == null) {
            endwin();
            System.err.println("Unable to create subwindow");
            System.exit(1);
        }

        /* fill windows */
        for (x = 0; x < 120; x++)
            addstr("standard screen ");
        sub.bkgd(COLOR_PAIR(1));
        for (x = 0; x < 200; x++)
            sub.addstr(" sub ");
        refresh();
        sub.refresh();
        getch();

        /* delete subwindow */
        sub.delwin();
        mvaddstr(0, 0, "Subwindow deleted ");
        refresh();
        getch();

        endwin();
    }
}

package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.COLOR_BLUE;
import static io.webfolder.pdcurses4j.Window.COLOR_PAIR;
import static io.webfolder.pdcurses4j.Window.COLOR_RED;
import static io.webfolder.pdcurses4j.Window.COLOR_WHITE;
import static io.webfolder.pdcurses4j.Window.COLOR_YELLOW;
import static io.webfolder.pdcurses4j.Window.endwin;
import static io.webfolder.pdcurses4j.Window.init_pair;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.start_color;
import static io.webfolder.pdcurses4j.Window.stdscr;

public class kid1 {

    public static void main(String[] args) {
        initscr();

        start_color();
        init_pair((short) 1, COLOR_WHITE, COLOR_BLUE);
        init_pair((short) 2, COLOR_RED, COLOR_YELLOW);

        /* create subwindow */
        Window sonny = stdscr.subwin(5, 20, 10, 30);
        if (sonny == null) {
            endwin();
        }

        /* color windows and splash some text */
        stdscr.bkgd(COLOR_PAIR(1));
        stdscr.addstr("Hello, son.");
        sonny.bkgd(COLOR_PAIR(2));
        sonny.addstr("Hello, Dad.");

        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

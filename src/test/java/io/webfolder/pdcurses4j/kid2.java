package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.COLOR_BLUE;
import static io.webfolder.pdcurses4j.Window.COLOR_CYAN;
import static io.webfolder.pdcurses4j.Window.COLOR_PAIR;
import static io.webfolder.pdcurses4j.Window.COLOR_RED;
import static io.webfolder.pdcurses4j.Window.COLOR_WHITE;
import static io.webfolder.pdcurses4j.Window.COLOR_YELLOW;
import static io.webfolder.pdcurses4j.Window.endwin;
import static io.webfolder.pdcurses4j.Window.init_pair;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.start_color;
import static io.webfolder.pdcurses4j.Window.stdscr;

public class kid2 {

    public static void main(String[] args) {
        initscr();
        start_color(); /* remember to check for errors! */
        init_pair(1, COLOR_WHITE, COLOR_BLUE);
        init_pair(2, COLOR_RED, COLOR_YELLOW);
        init_pair(3, COLOR_CYAN, COLOR_WHITE);

        /* create subwindow and remember to check for errors! */
        Window sonny = stdscr.subwin(5, 20, 10, 30);
        Window babygirl = stdscr.derwin(5, 20, 1, 50);

        /* color windows and splash some text */
        stdscr.bkgd(COLOR_PAIR(1));
        stdscr.addstr("Hello, son, hello baby girl.");
        sonny.bkgd(COLOR_PAIR(2));
        sonny.addstr("Hello, Dad.");
        babygirl.bkgd(COLOR_PAIR(3));
        babygirl.addstr("Hello, Papa.");

        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

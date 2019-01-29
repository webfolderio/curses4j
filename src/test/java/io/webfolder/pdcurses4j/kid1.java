package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.*;

public class kid1 {

    public static void main(String[] args) {

        Window stdscr = new Window();
        stdscr.initscr();

        Window.start_color();
        Window.init_pair((short) 1, COLOR_WHITE, COLOR_BLUE);
        Window.init_pair((short) 2, COLOR_RED, COLOR_YELLOW);

        /* create subwindow */
        Window sonny = stdscr.subwin(5, 20, 10, 30);
        if (sonny == null) {
            Window.endwin();
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

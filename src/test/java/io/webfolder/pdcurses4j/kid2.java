package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.*;

public class kid2 {

    public static void main(String[] args) {

        Window stdscr = new Window();

        stdscr.initscr();
        Window.start_color(); /* remember to check for errors! */
        Window.init_pair((short) 1, COLOR_WHITE, COLOR_BLUE);
        Window.init_pair((short) 2, COLOR_RED, COLOR_YELLOW);
        Window.init_pair((short) 3, COLOR_CYAN, COLOR_WHITE);

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

        Window.endwin();
    }
}

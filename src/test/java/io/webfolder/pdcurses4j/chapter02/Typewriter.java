package io.webfolder.pdcurses4j.chapter02;

import static io.webfolder.pdcurses4j.Window.endwin;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.stdscr;

public class Typewriter {

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        int ch = 0;

        initscr();
        stdscr.addstr("Type a few lines of text\n");
        stdscr.addstr("Press ~ to quit\n");
        stdscr.refresh();

        while ((ch = stdscr.getch()) != '~')
            ;

        endwin();
    }
}

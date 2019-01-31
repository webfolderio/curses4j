package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.endwin;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.stdscr;

public class HelloWorld {

    public static void main(String[] args) {
        initscr();

        stdscr.box('*', '*');
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

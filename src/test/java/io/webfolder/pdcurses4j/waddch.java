package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.endwin;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.stdscr;

public class waddch {

    public static void main(String[] args) throws InterruptedException {
        initscr();
        stdscr.addch('H');
        stdscr.addch('i');
        stdscr.addch('!');
        stdscr.refresh();
        stdscr.getch();
        endwin();
    }
}

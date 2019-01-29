package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.endwin;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.stdscr;
import static java.lang.String.format;

public class unctrl {

    public static final int MAX = 0x7f;

    public static void main(String[] args) {
        initscr();

        for(int ch = 0; ch <= MAX; ch++) {
            stdscr.printw(format("%s\t", Window.unctrl(ch)));
        }
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

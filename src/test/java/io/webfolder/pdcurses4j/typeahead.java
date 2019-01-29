package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.endwin;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.stdscr;
import static io.webfolder.pdcurses4j.Window.typeahead;

public class typeahead {

    public static void main(String[] args) {
        initscr();
        typeahead(-1); /* Disable typeahead */

        stdscr.addstr("All this text will be put to the screen without a\n");
        stdscr.addstr("keyboard interruption.");
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.endwin;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.stdscr;
import static java.lang.String.format;

public class getstr {

    public static void main(String[] args) {
        initscr();
        stdscr.addstr("Enter the first 3 letters of your first name? ");
        stdscr.refresh();
        String first = stdscr.getnstr(3);

        stdscr.addstr("Enter the first 3 letters of your last name? ");
        stdscr.refresh();
        String last = stdscr.getnstr(3);

        stdscr.printw(format("Your secret agent name is %s%s!", first, last));
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

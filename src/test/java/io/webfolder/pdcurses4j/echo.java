package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.endwin;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.stdscr;

public class echo {

    public static void main(String[] args) {
        int ch;

        initscr();

        stdscr.addstr("Normally echo is on. Type your name and press Enter:\n");
        stdscr.refresh();
        while (stdscr.getch() != '\n') {
            // no op
        }

        stdscr.mvaddstr(2, 0, "Now echo is off. Type your name and press Enter:\n");
        stdscr.refresh();
        stdscr.noecho();
        while (stdscr.getch() != '\n') {
            // no op
        }

        stdscr.mvaddstr(4, 0, "Echo is still off, but input is being displayed\n");
        stdscr.addstr("and manipulated manually. Type your name and press Enter:\n");
        do {
            ch = stdscr.getch();
            stdscr.addch(Character.toUpperCase(ch));
            stdscr.refresh();
        } while (ch != '\n');

        stdscr.addstr("Press Enter to quit:");
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

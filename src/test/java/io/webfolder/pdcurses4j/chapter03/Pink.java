package io.webfolder.pdcurses4j.chapter03;

import static io.webfolder.pdcurses4j.Window.COLOR_BLACK;
import static io.webfolder.pdcurses4j.Window.COLOR_PAIR;
import static io.webfolder.pdcurses4j.Window.can_change_color;
import static io.webfolder.pdcurses4j.Window.endwin;
import static io.webfolder.pdcurses4j.Window.init_color;
import static io.webfolder.pdcurses4j.Window.init_pair;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.start_color;
import static io.webfolder.pdcurses4j.Window.stdscr;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/03-06_pink.php
 */
public class Pink {

    private static final short PINK = 1;

    public static void main(String[] args) {
        initscr();

        start_color();
        if (!can_change_color()) {
            stdscr.addstr("This probably won't work...\n");
        }

        init_color(PINK, (short) 1000, (short) 750, (short) 750); /* pink */
        init_pair(1, PINK, COLOR_BLACK);
        stdscr.attrset(COLOR_PAIR(1));
        stdscr.printw("This is the new color %d.\n", PINK);
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

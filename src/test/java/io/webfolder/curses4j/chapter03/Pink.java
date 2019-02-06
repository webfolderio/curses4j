package io.webfolder.curses4j.chapter03;

import static io.webfolder.curses4j.Curses.COLOR_BLACK;
import static io.webfolder.curses4j.Curses.COLOR_PAIR;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.attrset;
import static io.webfolder.curses4j.Curses.can_change_color;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.init_color;
import static io.webfolder.curses4j.Curses.init_pair;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.printw;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.start_color;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/03-06_pink.php
 */
public class Pink {

    private static final short PINK = 1;

    public static void main(String[] args) {
        initscr();

        start_color();
        if (!can_change_color()) {
            addstr("This probably won't work...\n");
        }

        init_color(PINK, (short) 1000, (short) 750, (short) 750); /* pink */
        init_pair(1, PINK, COLOR_BLACK);
        attrset(COLOR_PAIR(1));
        printw("This is the new color %d.\n", PINK);
        refresh();
        getch();

        endwin();
    }
}

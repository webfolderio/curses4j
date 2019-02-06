package io.webfolder.curses4j.chapter03;

import static io.webfolder.curses4j.Curses.A_BOLD;
import static io.webfolder.curses4j.Curses.A_NORMAL;
import static io.webfolder.curses4j.Curses.COLOR_PAIR;
import static io.webfolder.curses4j.Curses.COLOR_RED;
import static io.webfolder.curses4j.Curses.COLOR_YELLOW;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.attrset;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.init_pair;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.start_color;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/03-04_yellowred.php
 */
public class Yellowred {

    public static void main(String[] args) {
        initscr();
        start_color();
        init_pair(1, COLOR_YELLOW, COLOR_RED);
        addstr("Normal text\n");
        attrset(COLOR_PAIR(1) | A_BOLD);
        addstr("Colored text. Wee!\n");
        attrset(A_NORMAL);
        addstr("Back to normal.");
        refresh();
        getch();

        endwin();
    }
}

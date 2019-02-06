package io.webfolder.curses4j.chapter03;

import static io.webfolder.curses4j.Window.A_BOLD;
import static io.webfolder.curses4j.Window.A_NORMAL;
import static io.webfolder.curses4j.Window.COLOR_PAIR;
import static io.webfolder.curses4j.Window.COLOR_RED;
import static io.webfolder.curses4j.Window.COLOR_YELLOW;
import static io.webfolder.curses4j.Window.endwin;
import static io.webfolder.curses4j.Window.init_pair;
import static io.webfolder.curses4j.Window.initscr;
import static io.webfolder.curses4j.Window.start_color;
import static io.webfolder.curses4j.Window.stdscr;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/03-04_yellowred.php
 */
public class Yellowred {

    public static void main(String[] args) {
        initscr();
        start_color();
        init_pair(1, COLOR_YELLOW, COLOR_RED);
        stdscr.addstr("Normal text\n");
        stdscr.attrset(COLOR_PAIR(1) | A_BOLD);
        stdscr.addstr("Colored text. Wee!\n");
        stdscr.attrset(A_NORMAL);
        stdscr.addstr("Back to normal.");
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

package io.webfolder.curses4j.chapter03;

import static io.webfolder.curses4j.Curses.A_BOLD;
import static io.webfolder.curses4j.Curses.COLOR_BLACK;
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
 * @see https://c-for-dummies.com/ncurses/source_code/03-05_colorful.php
 */
public class Colorful {

    public static void main(String[] args) {
        initscr();
        start_color();
        init_pair(1, COLOR_BLACK, COLOR_RED);
        init_pair(2, COLOR_YELLOW, COLOR_BLACK);
        attrset(COLOR_PAIR(1)); /* black on red */
        addstr("I am Mr. Black!\n");
        attrset(COLOR_PAIR(2)); /* yellow on black */
        addstr("I am Mr. Yellow!\n");
        attrset(COLOR_PAIR(1) | A_BOLD); /* +bold */
        addstr("I'm feeling bold!\n");
        attrset(COLOR_PAIR(2) | A_BOLD); /* +bold */
        addstr("Me too!");
        refresh();
        getch();

        endwin();
    }
}

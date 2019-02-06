package io.webfolder.curses4j.chapter03;

import static io.webfolder.curses4j.Window.A_BOLD;
import static io.webfolder.curses4j.Window.COLOR_BLACK;
import static io.webfolder.curses4j.Window.COLOR_PAIR;
import static io.webfolder.curses4j.Window.COLOR_RED;
import static io.webfolder.curses4j.Window.COLOR_YELLOW;
import static io.webfolder.curses4j.Window.endwin;
import static io.webfolder.curses4j.Window.init_pair;
import static io.webfolder.curses4j.Window.initscr;
import static io.webfolder.curses4j.Window.start_color;
import static io.webfolder.curses4j.Window.stdscr;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/03-05_colorful.php
 */
public class Colorful {

    public static void main(String[] args) {
        initscr();
        start_color();
        init_pair(1, COLOR_BLACK, COLOR_RED);
        init_pair(2, COLOR_YELLOW, COLOR_BLACK);
        stdscr.attrset(COLOR_PAIR(1)); /* black on red */
        stdscr.addstr("I am Mr. Black!\n");
        stdscr.attrset(COLOR_PAIR(2)); /* yellow on black */
        stdscr.addstr("I am Mr. Yellow!\n");
        stdscr.attrset(COLOR_PAIR(1) | A_BOLD); /* +bold */
        stdscr.addstr("I'm feeling bold!\n");
        stdscr.attrset(COLOR_PAIR(2) | A_BOLD);
        ; /* +bold */
        stdscr.addstr("Me too!");
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

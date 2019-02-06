package io.webfolder.curses4j.chapter03;

import static io.webfolder.curses4j.Window.COLOR_BLUE;
import static io.webfolder.curses4j.Window.COLOR_GREEN;
import static io.webfolder.curses4j.Window.COLOR_PAIR;
import static io.webfolder.curses4j.Window.COLOR_RED;
import static io.webfolder.curses4j.Window.COLOR_WHITE;
import static io.webfolder.curses4j.Window.endwin;
import static io.webfolder.curses4j.Window.init_pair;
import static io.webfolder.curses4j.Window.initscr;
import static io.webfolder.curses4j.Window.start_color;
import static io.webfolder.curses4j.Window.stdscr;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/03-08_bgcolor2.php
 */
public class Bgcolor {

    public static void main(String[] args) {
        initscr();

        start_color();
        init_pair(1, COLOR_WHITE, COLOR_BLUE);
        init_pair(2, COLOR_GREEN, COLOR_WHITE);
        init_pair(3, COLOR_RED, COLOR_GREEN);
        stdscr.bkgd(COLOR_PAIR(1));

        stdscr.addstr("I think that I shall never see\n");
        stdscr.addstr("a color screen as pretty as thee.\n");
        stdscr.addstr("For seasons may change\n");
        stdscr.addstr("and storms may thunder;\n");
        stdscr.addstr("But color text shall always wonder.");
        stdscr.refresh();
        stdscr.getch();

        stdscr.bkgd(COLOR_PAIR(2));
        stdscr.refresh();
        stdscr.getch();

        stdscr.bkgd(COLOR_PAIR(3));
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

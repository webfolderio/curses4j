package io.webfolder.curses4j.chapter03;

import static io.webfolder.curses4j.Curses.COLOR_BLUE;
import static io.webfolder.curses4j.Curses.COLOR_GREEN;
import static io.webfolder.curses4j.Curses.COLOR_PAIR;
import static io.webfolder.curses4j.Curses.COLOR_RED;
import static io.webfolder.curses4j.Curses.COLOR_WHITE;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.bkgd;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.init_pair;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.start_color;

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
        bkgd(COLOR_PAIR(1));

        addstr("I think that I shall never see\n");
        addstr("a color screen as pretty as thee.\n");
        addstr("For seasons may change\n");
        addstr("and storms may thunder;\n");
        addstr("But color text shall always wonder.");
        refresh();
        getch();

        bkgd(COLOR_PAIR(2));
        refresh();
        getch();

        bkgd(COLOR_PAIR(3));
        refresh();
        getch();

        endwin();
    }
}

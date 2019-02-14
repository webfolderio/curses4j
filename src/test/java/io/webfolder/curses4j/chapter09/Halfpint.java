package io.webfolder.curses4j.chapter09;

import static io.webfolder.curses4j.Curses.COLOR_BLUE;
import static io.webfolder.curses4j.Curses.COLOR_PAIR;
import static io.webfolder.curses4j.Curses.COLOR_RED;
import static io.webfolder.curses4j.Curses.COLOR_WHITE;
import static io.webfolder.curses4j.Curses.COLS;
import static io.webfolder.curses4j.Curses.LINES;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.bkgd;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.init_pair;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.newwin;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.start_color;
import static io.webfolder.curses4j.Curses.touchwin;

import io.webfolder.curses4j.Window;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/09-05_halfpint.php
 */
public class Halfpint {

    public static void main(String[] args) {
        Window tiny;

        initscr();
        start_color();

        /* configure colors */
        init_pair(1,COLOR_WHITE,COLOR_BLUE);
        init_pair(2,COLOR_WHITE,COLOR_RED);

        /* create the tiny window */
        tiny = newwin(
                LINES()/2,
                COLS()/2,
                LINES()/4,
                COLS()/4);
        if(tiny == null)
        {
            endwin();
            System.err.println("Unable to create window");
            System.exit(1);
        }
        tiny.bkgd(COLOR_PAIR(2));
        tiny.addstr("This is a tiny window\n");

        /* standard screen */
        bkgd(COLOR_PAIR(1));
        addstr("This is the standard screen\n");
        addstr("Press Enter");
        refresh();
        getch();
        /* show second window */
        tiny.refresh();
        getch();
        /* show standard screen again */
        touchwin();
        refresh();
        getch();

        endwin();
    }
}

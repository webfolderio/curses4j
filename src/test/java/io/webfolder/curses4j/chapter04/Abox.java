package io.webfolder.curses4j.chapter04;

import static io.webfolder.curses4j.Curses.ACS_HLINE;
import static io.webfolder.curses4j.Curses.ACS_LLCORNER;
import static io.webfolder.curses4j.Curses.ACS_LRCORNER;
import static io.webfolder.curses4j.Curses.ACS_ULCORNER;
import static io.webfolder.curses4j.Curses.ACS_URCORNER;
import static io.webfolder.curses4j.Curses.ACS_VLINE;
import static io.webfolder.curses4j.Curses.addch;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/04-07_abox.php
 */
public class Abox {

    public static void main(String[] args) {
        initscr();

        addch(ACS_ULCORNER);
        addch(ACS_HLINE);
        addch(ACS_URCORNER);
        addch('\n');
        addch(ACS_VLINE);
        addch(' ');
        addch(ACS_VLINE);
        addch('\n');
        addch(ACS_LLCORNER);
        addch(ACS_HLINE);
        addch(ACS_LRCORNER);
        addch('\n');
        refresh();
        getch();

        endwin();
    }
}

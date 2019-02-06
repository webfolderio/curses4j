package io.webfolder.pdcurses4j.chapter04;

import static io.webfolder.pdcurses4j.Window.ACS_HLINE;
import static io.webfolder.pdcurses4j.Window.ACS_LLCORNER;
import static io.webfolder.pdcurses4j.Window.ACS_LRCORNER;
import static io.webfolder.pdcurses4j.Window.ACS_ULCORNER;
import static io.webfolder.pdcurses4j.Window.ACS_URCORNER;
import static io.webfolder.pdcurses4j.Window.ACS_VLINE;
import static io.webfolder.pdcurses4j.Window.endwin;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.stdscr;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/04-07_abox.php
 */
public class Abox {

    public static void main(String[] args) {
        initscr();

        stdscr.addch(ACS_ULCORNER);
        stdscr.addch(ACS_HLINE);
        stdscr.addch(ACS_URCORNER);
        stdscr.addch('\n');
        stdscr.addch(ACS_VLINE);
        stdscr.addch(' ');
        stdscr.addch(ACS_VLINE);
        stdscr.addch('\n');
        stdscr.addch(ACS_LLCORNER);
        stdscr.addch(ACS_HLINE);
        stdscr.addch(ACS_LRCORNER);
        stdscr.addch('\n');
        stdscr.refresh();
        stdscr.getch();

        endwin();   
    }
}

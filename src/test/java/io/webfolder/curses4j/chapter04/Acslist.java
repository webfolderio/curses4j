package io.webfolder.curses4j.chapter04;

import static io.webfolder.curses4j.Curses.A_ALTCHARSET;
import static io.webfolder.curses4j.Curses.addch;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.printw;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/04-05_acslist.php
 */
public class Acslist {

    public static void main(String[] args) {
        int a;

        initscr();
        
        for(a=0;a<127;a++)
        {
            printw("\t%2X:",a);
            addch(A_ALTCHARSET | a);
        }
        refresh();
        getch();

        endwin();
    }
}

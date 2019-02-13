package io.webfolder.curses4j.chapter08;

import static io.webfolder.curses4j.Curses.ERR;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.clrtoeol;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.getcury;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.move;
import static io.webfolder.curses4j.Curses.nodelay;
import static io.webfolder.curses4j.Curses.refresh;
import static java.lang.String.valueOf;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/08-02_keywait1.php
 */
public class Keywait1 {

    public static void main(String[] args) {
        int value = 0;

        initscr();

        addstr("Press any key to begin:\n");
        refresh();
        getch();

        /* turn off getch() wait */
        nodelay(true);
        addstr("Press any key to stop the loop!\n");
        while(getch() == ERR)
        {
            addstr(valueOf(value++));
            refresh();
            move(getcury(), 0);
            clrtoeol();
        }   
   
        endwin();
    }
}

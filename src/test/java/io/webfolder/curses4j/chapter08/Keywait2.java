package io.webfolder.curses4j.chapter08;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.clrtoeol;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.getcury;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.move;
import static io.webfolder.curses4j.Curses.nodelay;
import static io.webfolder.curses4j.Curses.printw;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/08-03_keywait2.php
 */
public class Keywait2 {

    public static void main(String[] args) {
        int value = 0;

        initscr();

        addstr("Press any key to begin:\n");
        refresh();
        getch();

        /* turn off getch() wait */
        nodelay(true);
        addstr("Press the Spacebar to stop the loop!\n");
        while(getch() != ' ')
        {
            printw("%d",value++);
            refresh();
            move(getcury(), 0);
            clrtoeol();
        }   

        endwin();
    }
}

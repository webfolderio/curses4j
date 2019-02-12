package io.webfolder.curses4j.chapter07;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.clear;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.getmaxx;
import static io.webfolder.curses4j.Curses.getmaxy;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/07-01_cls.php
 */
public class Cls {

    public static void main(String[] args) {
        int c,y,x,cmax;

        initscr();

        y = getmaxy();
        x = getmaxx();

        cmax = (x * y) / 5;
        for(c=0;c<cmax;c++)
            addstr("blah ");
        refresh();
        getch();

        clear(); /* clear the screen */
        refresh(); /* don't forget this! */
        getch();
        
        endwin();
    }
}

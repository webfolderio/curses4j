package io.webfolder.curses4j.chapter07;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.clrtoeol;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.getmaxx;
import static io.webfolder.curses4j.Curses.getmaxy;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.move;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/07-02_clearline.php
 */
public class Clearline {

    public static void main(String[] args) {
        int c,y,x,cmax;

        initscr();

        x = getmaxx();
        y = getmaxy();

        cmax = (x * y) / 5;
        for(c=0;c<cmax;c++)
            addstr("blah ");
        refresh();
        getch();

        move(5,20); /* Setup the cursor */
        clrtoeol(); /* Clear to end of line */
        refresh();
        getch();

        endwin();
    }
}

package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.endwin;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.stdscr;

public class clear {

    public static void main(String[] args) {
        int c, y, x, cmax;

        initscr();

        x = stdscr.getmaxx();
        y = stdscr.getmaxy();


        cmax = (x * y) / 5;
        for (c = 0; c < cmax; c++) {
            stdscr.addstr("blah ");
        }
        stdscr.refresh();
        stdscr.getch();
        stdscr.clear(); /* clear the screen */
        stdscr.refresh(); /* don't forget this! */
        stdscr.getch();

        endwin();
    }
}

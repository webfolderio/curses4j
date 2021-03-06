package io.webfolder.curses4j.chapter12;

import static io.webfolder.curses4j.Curses.LINES;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.mvprintw;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.scroll;
import static io.webfolder.curses4j.Curses.scrollok;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/12-04_scroll.php
 */
public class Scroll {

    public static void main(String[] args) {
        int y;

        initscr();

        /* enable scrolling */
        scrollok(true);

        /* place junk on the screen */
        for (y = 0; y < LINES(); y++)
            mvprintw(y, 0, "%2d", y);
        refresh();
        getch();

        /* scroll up one line */
        scroll();
        refresh();
        getch();

        endwin();
    }
}

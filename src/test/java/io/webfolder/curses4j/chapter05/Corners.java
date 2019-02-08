package io.webfolder.curses4j.chapter05;

import static io.webfolder.curses4j.Curses.*;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/05-03_corners.php
 */
public class Corners {

    public static void main(String[] args) {
        initscr();

        int cols = getmaxx();
        int lines = getmaxy();

        lines--;
        cols--;

        mvaddch(0, 0, '*'); /* UL corner */
        refresh();
        napms(500); /* pause 1/2 sec */

        mvaddch(0, cols, '*'); /* UR corner */
        refresh();
        napms(500);

        mvaddch(lines, 0, '*'); /* LL corner */
        refresh();
        napms(500);

        mvaddch(lines, cols, '*'); /* LR corner */
        refresh();
        getch();

        endwin();
    }
}

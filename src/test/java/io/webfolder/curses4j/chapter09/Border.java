package io.webfolder.curses4j.chapter09;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.border;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.move;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/09-08_border.php
 */
public class Border {

    public static void main(String[] args) {
        initscr();

        border(0,0,0,0,0,0,0,0);
        move(1,1);
        addstr("Now that's a swell border!\n");
        refresh();
        getch();

        endwin();
    }
}

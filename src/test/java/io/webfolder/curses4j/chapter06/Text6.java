package io.webfolder.curses4j.chapter06;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.deleteln;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.move;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/06-08_text6.php
 */
public class Text6 {

    public static void main(String[] args) {
        initscr();

        /* add five lines */
        addstr("This is the first line\n");
        addstr("Line two here\n");
        addstr("The third line\n");
        addstr("Fourth line here\n");
        addstr("And the fifth line\n");
        refresh();
        getch();

        /* remove a line*/
        move(2,0);
        deleteln();
        refresh();      
        getch();

        endwin();
    }
}

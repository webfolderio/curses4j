package io.webfolder.curses4j.chapter06;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.delch;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.move;
import static io.webfolder.curses4j.Curses.napms;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/06-09_text7.php
 */
public class Text7 {

    public static void main(String[] args) {
        initscr();

        addstr("This is the first line\n");
        addstr("Line two here\n");
        addstr("The third line\n");
        addstr("Fourth line here\n");
        addstr("And the fifth line\n");
        refresh();
        getch();

        move(3, 7);
        for(int x = 0; x < 5; x++) {   
            delch();
            refresh();
            napms(250);     
        }
        getch();

        endwin();
    }
}

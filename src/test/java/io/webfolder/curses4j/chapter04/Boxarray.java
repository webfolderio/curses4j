package io.webfolder.curses4j.chapter04;

import static io.webfolder.curses4j.Curses.A_ALTCHARSET;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.attrset;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/04-10_boxarray.php
 */
public class Boxarray {

    public static void main(String[] args) {
        String box = "lqk\nx x\nmqj\n";

        initscr();
            
        attrset(A_ALTCHARSET);
        addstr(box);
        refresh();
        getch();
        
        endwin();
    }
}

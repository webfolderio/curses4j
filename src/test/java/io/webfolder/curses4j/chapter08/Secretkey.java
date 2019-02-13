package io.webfolder.curses4j.chapter08;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.clear;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.move;
import static io.webfolder.curses4j.Curses.noecho;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/08-04_secretkey.php
 */
public class Secretkey {

    public static void main(String[] args) {
        int key1,key2;

        initscr();

        addstr("Type a key: ");
        refresh();
        key1 = getch();
        clear();
        addstr("Type the same key: ");
        noecho();
        key2 = getch();
        move(1,0);
        if( key1 == key2 )
            addstr("The keys match");
        else
            addstr("The keys don't match");
        refresh();
        getch();

        endwin();
    }
}

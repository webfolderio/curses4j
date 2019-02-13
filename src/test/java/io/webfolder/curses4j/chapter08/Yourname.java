package io.webfolder.curses4j.chapter08;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.clear;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.getnstr;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.move;
import static io.webfolder.curses4j.Curses.printw;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/08-01_yourname.php
 */
public class Yourname {

    public static void main(String[] args) {
        int ch;
        String name;
        initscr();
        
        do
        {
            clear();
            addstr("Enter your name: ");
            name = getnstr(31);
            move(1,0);
            printw("Your name is %s. ",name);
            printw("Is this correct? ");
            ch = getch();
        } while( ch != 'y');
        move(2,0);
        printw("Pleased to meet you, %s\n",name);
        getch();

        endwin();
    }
}

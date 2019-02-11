package io.webfolder.curses4j.chapter06;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.delch;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.insch;
import static io.webfolder.curses4j.Curses.move;
import static io.webfolder.curses4j.Curses.napms;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/06-10_cat.php
 */
public class Cat {

    public static void main(String[] args) {
        String ob = "taf";
        int x;

        initscr();

        /* display initial string */
        addstr("Where did that silly cat go?");
        refresh();
        getch();
        
        /* edit out the word 'silly' */
        move(0,15);
        for(x=0;x<5;x++)
        {   
            delch();
            refresh();
            napms(250);     
        }
        /* and immediately insert the word 'fat' */
        for (int i = 0; i < ob.length(); i++)
        {
            insch(ob.charAt(i));
            refresh();
            napms(250);
        }
        getch();

        endwin();
    }
}

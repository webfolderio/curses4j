package io.webfolder.curses4j.chapter06;

import static io.webfolder.curses4j.Curses.*;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/06-11_insdel.php
 */
public class Insdel {

    public static void main(String[] args) {
        int row,col; 

        initscr();

        for(row=0;row<LINES();row++)
            for(col=0;col<COLS();col++)
                addch('.');
        refresh();
        getch();

        move(5,0);
        insdelln(3);
        refresh();
        getch();

        insdelln(-5);
        refresh();   
        getch();

        endwin();
    }
}

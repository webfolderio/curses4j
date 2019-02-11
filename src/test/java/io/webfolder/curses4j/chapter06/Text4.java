package io.webfolder.curses4j.chapter06;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.insertln;
import static io.webfolder.curses4j.Curses.move;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/06-04_text4.php
 */
public class Text4 {

    public static void main(String[] args) {
        String text1 = "This is the first line\n";
        String text2 = "Line two here\n";
        String text3 = "The third line\n";
        String text4 = "Fourth line here\n";
        String text5 = "And the fifth line\n";
        
        initscr();

        addstr(text1);
        addstr(text3);
        addstr(text5);
        refresh();      
        getch();

        move(1,0); /* Second line/row */
        insertln(); /* add a blank line */
        move(3,0); /* Fourth row */
        insertln();
        refresh();
        getch();

        move(1,0); /* Second row */
        addstr(text2);
        move(3,0); /* Fourth row */
        addstr(text4);
        refresh();
        getch();

        endwin();
    }
}

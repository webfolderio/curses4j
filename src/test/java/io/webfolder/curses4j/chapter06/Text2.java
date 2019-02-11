package io.webfolder.curses4j.chapter06;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.insertln;
import static io.webfolder.curses4j.Curses.move;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/06-02_text2.php
 */
public class Text2 {

    public static void main(String[] args) {
        String text1 = "This is the first line\n";
        String text3 = "The third line\n";
        String text5 = "And the fifth line\n";

        initscr();

        addstr(text1);
        addstr(text3);
        addstr(text5);
        insertln(); /* add a blank line */
        insertln(); /* add a blank line */
        insertln(); /* add a blank line */
        insertln(); /* add a blank line */

        refresh();
        getch();

        move(1, 0); /* Second line/row */
        insertln(); /* add a blank line */
        refresh();
        getch();

        endwin();
    }
}

package io.webfolder.curses4j.chapter03;

import static io.webfolder.curses4j.Curses.A_BLINK;
import static io.webfolder.curses4j.Curses.A_BOLD;
import static io.webfolder.curses4j.Curses.A_NORMAL;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.attroff;
import static io.webfolder.curses4j.Curses.attron;
import static io.webfolder.curses4j.Curses.attrset;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/03-01_twinkle.php
 */
public class Twinkle {

    public static void main(String[] args) {
        initscr();

        attron(A_BOLD);
        addstr("Twinkle, twinkle little star\n");
        attron(A_BLINK);
        addstr("How I wonder what you are.\n");
        attroff(A_BOLD);
        addstr("Up above the world so high,\n");
        addstr("Like a diamond in the sky.\n");
        attrset(A_NORMAL);
        addstr("Twinkle, twinkle little star\n");
        addstr("How I wonder what you are.\n");
        refresh();
        getch();

        endwin();
    }
}

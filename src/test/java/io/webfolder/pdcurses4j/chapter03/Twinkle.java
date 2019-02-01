package io.webfolder.pdcurses4j.chapter03;

import static io.webfolder.pdcurses4j.Window.A_BLINK;
import static io.webfolder.pdcurses4j.Window.A_BOLD;
import static io.webfolder.pdcurses4j.Window.A_NORMAL;
import static io.webfolder.pdcurses4j.Window.endwin;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.stdscr;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/03-01_twinkle.php
 */
public class Twinkle {

    public static void main(String[] args) {
        initscr();

        stdscr.attron(A_BOLD);
        stdscr.addstr("Twinkle, twinkle little star\n");
        stdscr.attron(A_BLINK);
        stdscr.addstr("How I wonder what you are.\n");
        stdscr.attroff(A_BOLD);
        stdscr.addstr("Up above the world so high,\n");
        stdscr.addstr("Like a diamond in the sky.\n");
        stdscr.attrset(A_NORMAL);
        stdscr.addstr("Twinkle, twinkle little star\n");
        stdscr.addstr("How I wonder what you are.\n");
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

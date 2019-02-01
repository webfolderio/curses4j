package io.webfolder.pdcurses4j.chapter02;

import static io.webfolder.pdcurses4j.Window.endwin;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.stdscr;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/02-08_sushi.php
 */
public class Sushi {

    public static void main(String[] args) {
        int pieces;
        float uni = 4.5f;

        initscr();

        stdscr.addstr("SUSHI BAR");
        stdscr.move(2, 0);
        stdscr.printw("We have Uni today for $%.2f.\n", uni);
        stdscr.addstr("How many pieces would you like? ");
        stdscr.refresh();

        pieces = parseInt(stdscr.getnstr(valueOf(MAX_VALUE).length()));
        stdscr.printw("You want %d pieces?\n", pieces);
        stdscr.printw("That will be $%.2f!", uni * (float) pieces);
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

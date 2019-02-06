package io.webfolder.curses4j.chapter02;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.getnstr;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.move;
import static io.webfolder.curses4j.Curses.printw;
import static io.webfolder.curses4j.Curses.refresh;
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

        addstr("SUSHI BAR");
        move(2, 0);
        printw("We have Uni today for $%.2f.\n", uni);
        addstr("How many pieces would you like? ");
        refresh();

        pieces = parseInt(getnstr(valueOf(MAX_VALUE).length()));
        printw("You want %d pieces?\n", pieces);
        printw("That will be $%.2f!", uni * (float) pieces);
        refresh();
        getch();

        endwin();
    }
}

package io.webfolder.curses4j.chapter04;

import static io.webfolder.curses4j.Curses.A_ALTCHARSET;
import static io.webfolder.curses4j.Curses.A_BLINK;
import static io.webfolder.curses4j.Curses.A_BOLD;
import static io.webfolder.curses4j.Curses.A_DIM;
import static io.webfolder.curses4j.Curses.A_HORIZONTAL;
import static io.webfolder.curses4j.Curses.A_INVIS;
import static io.webfolder.curses4j.Curses.A_LEFT;
import static io.webfolder.curses4j.Curses.A_LOW;
import static io.webfolder.curses4j.Curses.A_PROTECT;
import static io.webfolder.curses4j.Curses.A_REVERSE;
import static io.webfolder.curses4j.Curses.A_RIGHT;
import static io.webfolder.curses4j.Curses.A_STANDOUT;
import static io.webfolder.curses4j.Curses.A_TOP;
import static io.webfolder.curses4j.Curses.A_UNDERLINE;
import static io.webfolder.curses4j.Curses.A_VERTICAL;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.attrset;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/04-03_attrtest.php
 */
public class Attrtest {

    public static void main(String[] args) {
        initscr();

        attrset(A_STANDOUT);
        addstr("This is A_STANDOUT\n");
        attrset(A_UNDERLINE);
        addstr("This is A_UNDERLINE\n");
        attrset(A_REVERSE);
        addstr("This is A_REVERSE\n");
        attrset(A_BLINK);
        addstr("This is A_BLINK\n");
        attrset(A_DIM);
        addstr("This is A_DIM\n");
        attrset(A_BOLD);
        addstr("This is A_BOLD\n");
        attrset(A_ALTCHARSET);
        addstr("This is A_ALTCHARSET\n");
        attrset(A_INVIS);
        addstr("This is A_INVIS\n");
        attrset(A_PROTECT);
        addstr("This is A_PROTECT\n");
        attrset(A_HORIZONTAL);
        addstr("This is A_HORIZONTAL\n");
        attrset(A_LEFT);
        addstr("This is A_LEFT\n");
        attrset(A_LOW);
        addstr("This is A_LOW\n");
        attrset(A_RIGHT);
        addstr("This is A_RIGHT\n");
        attrset(A_TOP);
        addstr("This is A_TOP\n");
        attrset(A_VERTICAL);
        addstr("This is A_VERTICAL\n");

        refresh();
        getch();

        endwin();
    }
}

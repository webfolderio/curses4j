package io.webfolder.curses4j.chapter08;

import static io.webfolder.curses4j.Curses.KEY_DOWN;
import static io.webfolder.curses4j.Curses.KEY_LEFT;
import static io.webfolder.curses4j.Curses.KEY_RIGHT;
import static io.webfolder.curses4j.Curses.KEY_UP;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.keypad;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/08-06_arrowkeys.php
 */
public class Arrowkeys {

    public static void main(String[] args) {
        int ch;

        initscr();

        keypad(true);
        do {
            ch = getch();
            switch (ch) {
            case KEY_DOWN:
                addstr("Down\n");
                break;
            case KEY_UP:
                addstr("Up\n");
                break;
            case KEY_LEFT:
                addstr("Left\n");
                break;
            case KEY_RIGHT:
                addstr("Right\n");
            default:
                break;
            }
            refresh();
        } while (ch != '\n');

        endwin();
    }
}

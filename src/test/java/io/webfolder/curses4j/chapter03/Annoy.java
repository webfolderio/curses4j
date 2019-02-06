package io.webfolder.curses4j.chapter03;

import static io.webfolder.curses4j.Window.A_BOLD;
import static io.webfolder.curses4j.Window.A_UNDERLINE;
import static io.webfolder.curses4j.Window.endwin;
import static io.webfolder.curses4j.Window.initscr;
import static io.webfolder.curses4j.Window.stdscr;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/03-02_annoy.php
 */
public class Annoy {

    public static void main(String[] args) {
        String text[] = { "Do", "you", "find", "this", "silly?" };
        int a, b;

        initscr();

        for (a = 0; a < text.length; a++) {
            for (b = 0; b < text.length; b++) {
                if (b == a)
                    stdscr.attrset(A_BOLD | A_UNDERLINE);
                stdscr.printw("%s", text[b]);
                if (b == a)
                    stdscr.attroff(A_BOLD | A_UNDERLINE);
                stdscr.addch(' ');
            }
            stdscr.addstr("\b\n");
        }
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

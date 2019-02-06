package io.webfolder.curses4j.chapter03;

import static io.webfolder.curses4j.Curses.A_BOLD;
import static io.webfolder.curses4j.Curses.A_UNDERLINE;
import static io.webfolder.curses4j.Curses.addch;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.attroff;
import static io.webfolder.curses4j.Curses.attrset;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.printw;
import static io.webfolder.curses4j.Curses.refresh;

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
                    attrset(A_BOLD | A_UNDERLINE);
                printw("%s", text[b]);
                if (b == a)
                    attroff(A_BOLD | A_UNDERLINE);
                addch(' ');
            }
            addstr("\b\n");
        }
        refresh();
        getch();

        endwin();
    }
}

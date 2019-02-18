package io.webfolder.curses4j.chapter08;

import static io.webfolder.curses4j.Curses.ERR;
import static io.webfolder.curses4j.Curses.FALSE;
import static io.webfolder.curses4j.Curses.TRUE;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.echo;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.napms;
import static io.webfolder.curses4j.Curses.nodelay;
import static io.webfolder.curses4j.Curses.noecho;
import static io.webfolder.curses4j.Curses.printw;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.unget_wch;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/08-05_kbhit.php
 */
public class Kbhit {

    /* check the keyboard queue */
    private static boolean kbhit() {
        int ch, r;

        /* turn off blocking and echo */
        nodelay(true);
        noecho();

        /* check for input */
        ch = getch();
        if (ch == ERR) /* no input */
            r = FALSE;
        else /* input */
        {
            r = TRUE;
            /* return key to queue */
            unget_wch(ch);
        }

        /* restore block and echo */
        echo();
        nodelay(false);
        return (r == TRUE) ? true : false;
    }

    public static void main(String[] args) {
        int x;

        initscr();

        addstr("Tap a key while I count...\n");
        for (x = 1; x < 21; x++) {
            printw("%2d ", x);
            refresh();
            napms(500);
            if (kbhit())
                break;
        }
        addstr("\nDone!\n");
        printw("You pressed the '%c' key\n", getch());
        refresh();
        getch();

        endwin();
    }
}

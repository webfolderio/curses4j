package io.webfolder.curses4j.chapter08;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.echo;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.getnstr;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.noecho;
import static io.webfolder.curses4j.Curses.printw;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/08-08_urpwd.php
 */
public class Urpwd {

    public static void main(String[] args) {
        String name;
        String password;

        initscr();

        addstr("Name: ");
        name = getnstr(32);
        /* disable text output */
        noecho();
        addstr("Password: ");
        password = getnstr(31);
        /* enable text output */
        echo();
        printw("%s's password is '%s'\n",
                name,
                password);
        refresh();
        getch();

        endwin();
    }
}

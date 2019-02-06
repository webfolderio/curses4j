package io.webfolder.curses4j.chapter04;

import static io.webfolder.curses4j.Window.A_BOLD;
import static io.webfolder.curses4j.Window.A_REVERSE;
import static io.webfolder.curses4j.Window.endwin;
import static io.webfolder.curses4j.Window.initscr;
import static io.webfolder.curses4j.Window.stdscr;

public class Charattrib {

    public static void main(String[] args) {
        initscr();

        stdscr.addch('c');
        stdscr.addch(A_BOLD | 'a');
        stdscr.addch(A_REVERSE | 't');
        stdscr.refresh();
        stdscr.getch();

        endwin();
    }
}

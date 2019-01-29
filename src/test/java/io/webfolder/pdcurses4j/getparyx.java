package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.COLOR_BLUE;
import static io.webfolder.pdcurses4j.Window.COLOR_PAIR;
import static io.webfolder.pdcurses4j.Window.COLOR_RED;
import static io.webfolder.pdcurses4j.Window.COLOR_WHITE;
import static io.webfolder.pdcurses4j.Window.COLOR_YELLOW;
import static java.lang.String.format;

public class getparyx {

    public static void main(String[] args) {
        int row, col;

        Window stdscr = new Window();
        stdscr.initscr();

        Window.start_color();

        Window.init_pair((short) 1, COLOR_WHITE, COLOR_BLUE);
        Window.init_pair((short) 2, COLOR_YELLOW, COLOR_RED);

        Window subby = Window.newwin(10, 30, 10, 40);
        subby.bkgd(COLOR_PAIR(1));
        row = subby.getpary();
        col = subby.getparx();

        subby.printw(format("This subwin's org: %d, %d.", row, col));
        subby.refresh();
        subby.getch();

        Window sonny = subby.subwin(7, 30, 13, 40);
        sonny.bkgd(COLOR_PAIR(2));
        row = sonny.getpary();
        col = sonny.getparx();
        sonny.printw(format("This subwin's org: %d, %d.", row, col));
        sonny.refresh();

        
        stdscr.getch();

        Window.endwin();
    }
}

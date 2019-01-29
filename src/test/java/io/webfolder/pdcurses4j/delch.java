package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.stdscr;
import static io.webfolder.pdcurses4j.Window.ERR;
import static io.webfolder.pdcurses4j.Window.initscr;
import static io.webfolder.pdcurses4j.Window.napms;

public class delch {

    public static final int Y = 5;
    public static final int X1 = 10;
    public static final int X2 = 60;
    public static final int DELAY = 250;

    public static void main(String[] args) {
        String text  = "Elvis found alive *** Stock market tops 20,000 *** ";
               text += "Rocky XII big box office hit *** Congressman indicted *** ";

        initscr();
        stdscr.noecho();
        stdscr.nodelay(true);

        for (int i = 0; i < text.length() && stdscr.getch() == ERR; i++) {
            char t = text.charAt(i);
            stdscr.mvinsch(Y, X2, t);
            stdscr.mvdelch(Y, X1);
            stdscr.refresh();
            napms(DELAY);
        }
    }
}

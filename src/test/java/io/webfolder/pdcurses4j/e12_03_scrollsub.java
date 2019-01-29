package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.*;

public class e12_03_scrollsub {

    public static void main(String[] args) {
        String text = "Scroll away! ";

        initscr();

        Window sub = stdscr.subwin(10, 30, 6, 24);
        sub.scrollok(true);
        for (int x = 0; x < 35; x++) {
            sub.addstr(text);
            napms(50);
            sub.refresh();
        }
        stdscr.getch();

        endwin();
    }
}

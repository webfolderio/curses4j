package io.webfolder.curses4j.chapter06;

import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.insch;
import static io.webfolder.curses4j.Curses.move;
import static io.webfolder.curses4j.Curses.napms;
import static io.webfolder.curses4j.Curses.refresh;

public class Marquee1 {

    public static void main(String[] args) {
        String text = "Armstrong walks on moon!";
        int len;

        initscr();

        StringBuilder builder = new StringBuilder();
        text = builder.append(text).reverse().toString();

        len = text.length();
        int i = 0;
        while (len > 0) {
            move(5, 5); /* insert same spot */
            insch(text.charAt(i)); /* work backwards */
            refresh();
            napms(100); /* .1 sec. delay */
            len--;
            i += 1;
        }
        getch();

        endwin();
    }
}

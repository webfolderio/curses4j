package io.webfolder.curses4j.chapter06;

import static io.webfolder.curses4j.Curses.addch;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.insch;
import static io.webfolder.curses4j.Curses.move;
import static io.webfolder.curses4j.Curses.napms;
import static io.webfolder.curses4j.Curses.refresh;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/06-06_marquee2.php
 */
public class Marquee2 {

    public static void main(String[] args) {
        String text = "Armstrong walks on moon!";
        char a;
        int len;

        initscr();

        StringBuilder builder = new StringBuilder();
        text = builder.append(text).reverse().toString();

        /* display a line of text */
        move(5, 0);
        for(a='A'; a<'Z'+1; a++)
        {
            addch(a);
            addstr("  ");   /* two spaces */
        }   

        len = text.length();
        int i = 0;
        while(len > 0)
        {
            move(5, 5);      /* insert same spot */
            insch(text.charAt(i));  /* work backwards */
            refresh();
            napms(100);         /* .1 sec. delay */
            len--;
            i += 1;
        }
        getch();

        endwin();
    }
}

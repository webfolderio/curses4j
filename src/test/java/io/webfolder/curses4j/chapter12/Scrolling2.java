package io.webfolder.curses4j.chapter12;

import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.napms;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.scrollok;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/12-02_scrolling2.php
 */
public class Scrolling2 {

	public static void main(String[] args) {
	    String text = "This is some wrapping. ";
	    int x;

	    initscr();

	    scrollok(true);
	    for(x=0;x<200;x++)
	    {
	        addstr(text);
	        napms(100);
	        refresh();
	    }   
	    getch();

	    endwin();
	}
}

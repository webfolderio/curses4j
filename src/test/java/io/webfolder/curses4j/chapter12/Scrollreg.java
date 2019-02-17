package io.webfolder.curses4j.chapter12;

import static io.webfolder.curses4j.Curses.LINES;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.bkgd;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.napms;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.scrollok;
import static io.webfolder.curses4j.Curses.setscrreg;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/12-06_scrollreg.php
 */
public class Scrollreg {

	public static void main(String[] args) {
	    String text = "Scroll me! ";
	    int x;

	    initscr();

	    bkgd('.');
	    scrollok(true);
	    setscrreg(3,LINES()-3);

	    for(x=0;x<200;x++)
	    {
	        addstr(text);
	        napms(25);
	        refresh();
	    }
	    getch();

	    endwin();
	}
}

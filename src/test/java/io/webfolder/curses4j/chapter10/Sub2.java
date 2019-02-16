package io.webfolder.curses4j.chapter10;

import static io.webfolder.curses4j.Curses.COLS;
import static io.webfolder.curses4j.Curses.LINES;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.subwin;

import io.webfolder.curses4j.Window;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/10-02_sub2.php
 */
public class Sub2 {

	public static void main(String[] args) {
	    Window quartersub;
	    int slines,scols,sposy,sposx;

	    initscr();
	    
	    /* subwindow location math */
	    slines = LINES()/2;
	    scols = COLS()/2;
	    sposy = (LINES()-slines)/2;
	    sposx = (COLS()-scols)/2;
   
	    /* create subwindow */
	    quartersub=subwin(slines,scols,sposy,sposx);
	    if( quartersub==null)
	    {
	        endwin();
	        System.err.println("Unable to create subwindow");
	        System.exit(1);
	    }

	    /* add text */
	    addstr("This is the standard screen");
	    quartersub.addstr("This is the subwindow");
	    refresh();
	    getch();

	    endwin();
	}
}

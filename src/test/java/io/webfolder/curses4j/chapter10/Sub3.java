package io.webfolder.curses4j.chapter10;

import static io.webfolder.curses4j.Curses.COLS;
import static io.webfolder.curses4j.Curses.LINES;
import static io.webfolder.curses4j.Curses.addstr;
import static io.webfolder.curses4j.Curses.box;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.derwin;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;

import io.webfolder.curses4j.Window;

/**
 * https://c-for-dummies.com/ncurses/source_code/10-03_sub3.php
 */
public class Sub3 {

	public static void main(String[] args) {
	    Window sub;
	    initscr();

	    /* create subwindow on stdscr */
	    sub = derwin(LINES()-2,COLS()-2,1,1);
	    if( sub==null)
	    {
	        endwin();
	        System.err.println("Unable to create subwindow");
	        System.exit(1);
	    }

	    /* draw a box around stdscr */
	    box(0,0);
	    /* put text to the stdscr */
	    addstr("I'm writing text\n");
	    addstr("to the standard screen.");
	    refresh();
	    getch();

	    sub.clear();
	    sub.refresh();
	    getch();

	    endwin();
	}
}

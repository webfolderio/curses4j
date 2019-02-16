package io.webfolder.curses4j.chapter10;

import static io.webfolder.curses4j.Curses.COLS;
import static io.webfolder.curses4j.Curses.LINES;
import static io.webfolder.curses4j.Curses.box;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.subwin;

import io.webfolder.curses4j.Window;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/10-01_sub1.php
 */
public class Sub {

	public static void main(String[] args) {
	    Window sub;

	    initscr();

	    /* create subwindow on stdscr */
	    sub = subwin(LINES()-2,COLS()-2,1,1);
	    if( sub==null)
	    {
	        endwin();
	        System.err.println("Unable to create subwindow");
	        System.exit(1);
	    }

	    /* draw a box around stdscr */
	    box(0,0);
	    /* put text to the subwindow */
	    sub.addstr("I'm in a subwindow.\n");
	    refresh();
	    getch();

	    endwin();
	}
}

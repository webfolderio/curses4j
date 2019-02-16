package io.webfolder.curses4j.chapter11;

import static io.webfolder.curses4j.Curses.COLOR_GREEN;
import static io.webfolder.curses4j.Curses.COLOR_PAIR;
import static io.webfolder.curses4j.Curses.COLOR_WHITE;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.init_pair;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.newwin;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.start_color;

import io.webfolder.curses4j.Window;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/11-07_movewin.php
 */
public class Movewin {

	public static void main(String[] args) {
	    Window alpha;

	    initscr();
	    refresh();

	    /* configure color */
	    start_color();
	    init_pair(1,COLOR_WHITE,COLOR_GREEN);

	    /* create window */
	    alpha = newwin(7,20,3,10);
	    if( alpha==null )
	    {
	        endwin();
	        System.err.println("Unable to create window");
	        System.exit(1);
	    }

	    /* put text on alpha */
	    alpha.bkgd(COLOR_PAIR(1));
	    alpha.mvaddstr(1,2,"Window Alpha");
	    alpha.refresh();
	    getch();

	    /* move window alpha */
	    alpha.mvwin(10,43);
	    alpha.mvaddstr(2,2,"Moved!");
	    alpha.refresh();
	    getch();

	    endwin();
	}
}

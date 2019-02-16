package io.webfolder.curses4j.chapter10;

import static io.webfolder.curses4j.Curses.*;
import io.webfolder.curses4j.Window;

public class Overlay {

	public static void main(String[] args) {
	    Window red,blue;
	    int x;

	    initscr();
	    refresh();

	    /* colors */
	    start_color();
	    init_pair(1,COLOR_WHITE,COLOR_RED);
	    init_pair(2,COLOR_WHITE,COLOR_BLUE);

	    /* create windows */
	    red = newwin(10,24,2,22);
	    blue = newwin(10,24,5,32);
	    if( red==null || blue==null)
	    {
	        endwin();
	        System.err.println("Unable to create windows");
	        System.exit(1);
	    }

	    /* color and fill windows */
	    red.bkgd(COLOR_PAIR(1));
	    blue.bkgd(COLOR_PAIR(2));
	    for(x=0;x<30;x++)
	    {
	        red.addstr("o e l y ");
	        blue.addstr(" r a   v");
	    }
	    red.refresh();
	    blue.refresh();
	    getch();

	    /* overlay windows */
	    overlay(red,blue);
	    blue.refresh();
	    getch();

	    endwin();
	}
}

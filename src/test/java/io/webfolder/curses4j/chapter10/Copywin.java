package io.webfolder.curses4j.chapter10;

import static io.webfolder.curses4j.Curses.*;
import io.webfolder.curses4j.Window;

public class Copywin {

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
	    red = newwin(10,24,5,10);
	    blue = newwin(10,24,5,40);
	    if( red==null || blue==null)
	    {
	        endwin();
	        System.err.println("Unable to create windows");
	        System.exit(1);
	    }

	    /* color and fill windows */
	    red.bkgd(COLOR_PAIR(1));
	    blue.bkgd(COLOR_PAIR(2));
	    for(x=0;x<34;x++)
	    {
	    	red.addstr("red    ");
	    	blue.addstr("   blue");
	    }
	    red.refresh();
	    blue.refresh();
	    getch();

	    /* copy window */
	    copywin(red,blue,0,0,1,4,5,10,TRUE);
	    blue.refresh();
	    getch();

	    endwin();
	}
}

package io.webfolder.curses4j.chapter12;

import static io.webfolder.curses4j.Curses.*;

import io.webfolder.curses4j.Window;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/12-03_scrollsub.php
 */
public class Scrollsub {

	public static void main(String[] args) {
	    Window sub;
	    String text = "Scroll away! ";
	    int x;

	    initscr();

	    sub = subwin(10,30,6,24);
	    sub.scrollok(true);
	    for(x=0;x<35;x++)
	    {
	        sub.addstr(text);
	        napms(50);
	        sub.refresh();
	    }
	    getch();

	    endwin();
	}
}

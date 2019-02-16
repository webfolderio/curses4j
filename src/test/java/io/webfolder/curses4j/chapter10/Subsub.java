package io.webfolder.curses4j.chapter10;

import static io.webfolder.curses4j.Curses.COLOR_BLACK;
import static io.webfolder.curses4j.Curses.COLOR_BLUE;
import static io.webfolder.curses4j.Curses.COLOR_GREEN;
import static io.webfolder.curses4j.Curses.COLOR_PAIR;
import static io.webfolder.curses4j.Curses.COLOR_RED;
import static io.webfolder.curses4j.Curses.COLOR_WHITE;
import static io.webfolder.curses4j.Curses.COLOR_YELLOW;
import static io.webfolder.curses4j.Curses.COLS;
import static io.webfolder.curses4j.Curses.LINES;
import static io.webfolder.curses4j.Curses.endwin;
import static io.webfolder.curses4j.Curses.getch;
import static io.webfolder.curses4j.Curses.init_pair;
import static io.webfolder.curses4j.Curses.initscr;
import static io.webfolder.curses4j.Curses.newwin;
import static io.webfolder.curses4j.Curses.refresh;
import static io.webfolder.curses4j.Curses.start_color;

import io.webfolder.curses4j.Window;

/**
 * @see https://c-for-dummies.com/ncurses/source_code/10-04_subsub.php
 */
public class Subsub {

	public static void main(String[] args) {
	    Window grandpa,father,son;
	    int gl,gc;

	    initscr();
	    refresh();  /* update stdscr */

	    /* set colors */
	    start_color();
	    init_pair(1,COLOR_WHITE,COLOR_BLUE);
	    init_pair(2,COLOR_RED,COLOR_YELLOW);
	    init_pair(3,COLOR_BLACK,COLOR_GREEN);

	    /* create windows */
	    grandpa = newwin(LINES()-4,COLS()-10,2,5);
	    gl = grandpa.getmaxy();
	    gc = grandpa.getmaxx();
	    father = grandpa.derwin(gl/2,gc,gl/2,0);
	    son = father.derwin(gl/2,3,0,(gc-4)/2);

	    /* color windows and splash some text */
	    grandpa.bkgd(COLOR_PAIR(1));
	    grandpa.addstr("I am Grandpa\n");
		father.bkgd(COLOR_PAIR(2));
	    father.addstr("I am Father\n");
	    father.clrtobot();
	    son.bkgd(COLOR_PAIR(3));
	    son.addstr("I am the boy\n");
	    grandpa.refresh();
	    getch();

	    endwin();
	}
}

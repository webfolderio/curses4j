package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.COLOR_BLACK;
import static io.webfolder.pdcurses4j.Window.COLOR_GREEN;
import static io.webfolder.pdcurses4j.Window.COLOR_PAIR;
import static io.webfolder.pdcurses4j.Window.COLOR_RED;
import static java.lang.System.in;

public class TextColor {

	public void run() {
		Window window = new Window();
		window.start_color();
		window.init_pair(1, COLOR_BLACK, COLOR_RED);
		window.init_pair(2, COLOR_BLACK, COLOR_GREEN);
		window.wattr_on(COLOR_PAIR(1));
		window.wprintw("This should be printed in black with a red background!\n");
		window.wattr_on(COLOR_PAIR(2));
		window.wprintw("And this in a green background!\n");
		window.wrefresh();
	}

	public static void main(String[] args) throws Exception {
		TextColor sample = new TextColor();
		sample.run();
		in.read();
	}
}

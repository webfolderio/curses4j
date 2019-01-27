package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.COLOR_BLUE;
import static io.webfolder.pdcurses4j.Window.COLOR_PAIR;
import static io.webfolder.pdcurses4j.Window.COLOR_WHITE;
import static java.lang.System.in;

import java.io.IOException;

public class Background {

	public void run() throws IOException {
		Window window = new Window();
		window.start_color();
		window.init_pair(1, COLOR_WHITE, COLOR_BLUE);
		window.wbkgdset(' ' | COLOR_PAIR(1));
		window.wprintw("hello, world!\n"); // english
		window.wprintw("Привет, мир!\n"); // russian
		window.wprintw("Chào thế giới!\n"); // vietnamese
		window.wprintw("merhaba, dünya!\n"); // turkish
		window.wrefresh();
	}

	public static void main(String[] args) throws Exception {
		Background sample = new Background();
		sample.run();
		in.read();
	}
}

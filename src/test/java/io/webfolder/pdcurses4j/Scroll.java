package io.webfolder.pdcurses4j;

import static java.lang.System.in;

import java.io.IOException;

public class Scroll {

	public void run() throws IOException {
		Window window = new Window();
		window.setTitle("Scroll");
		window.scrollok(true);
		for (int i = 0; i < 50; i++) {
			window.wprintw("line " + i + "\n");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			window.wrefresh();
		}
	}

	public static void main(String[] args) throws Exception {
		Scroll sample = new Scroll();
		sample.run();
		in.read();
	}
}

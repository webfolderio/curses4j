package io.webfolder.pdcurses4j;
import static java.lang.String.format;

public class unctrl {

    public static final int MAX = 0x7f;

    public static void main(String[] args) {
        int ch;

        Window window = new Window();
        window.initscr();

        for(ch = 0; ch <= MAX; ch++) {
            window.printw(format("%s\t", window.unctrl(ch)));
        }
        window.refresh();
        window.getch();

        window.endwin();
    }
}

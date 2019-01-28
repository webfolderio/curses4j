package io.webfolder.pdcurses4j;

public class echo {

    public static void main(String[] args) {
        int ch;

        Window window = new Window();
        window.initscr();

        window.waddstr("Normally echo is on. Type your name and press Enter:\n");
        window.wrefresh();
        while (window.wgetch() != '\n') {
            // no op
        }

        window.mvwaddstr(2, 0, "Now echo is off. Type your name and press Enter:\n");
        window.wrefresh();
        window.noecho();
        while (window.wgetch() != '\n') {
            // no op
        }

        window.mvwaddstr(4, 0, "Echo is still off, but input is being displayed\n");
        window.waddstr("and manipulated manually. Type your name and press Enter:\n");
        do {
            ch = window.wgetch();
            window.waddch(Character.toUpperCase(ch));
            window.wrefresh();
        } while (ch != '\n');

        window.waddstr("Press Enter to quit:");
        window.wrefresh();
        window.wgetch();

        window.endwin();
    }
}

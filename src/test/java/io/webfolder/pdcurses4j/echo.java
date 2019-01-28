package io.webfolder.pdcurses4j;

public class echo {

    public static void main(String[] args) {
        int ch;

        Window window = new Window();
        window.initscr();

        window.addstr("Normally echo is on. Type your name and press Enter:\n");
        window.refresh();
        while (window.getch() != '\n') {
            // no op
        }

        window.mvaddstr(2, 0, "Now echo is off. Type your name and press Enter:\n");
        window.refresh();
        window.noecho();
        while (window.getch() != '\n') {
            // no op
        }

        window.mvaddstr(4, 0, "Echo is still off, but input is being displayed\n");
        window.addstr("and manipulated manually. Type your name and press Enter:\n");
        do {
            ch = window.getch();
            window.addch(Character.toUpperCase(ch));
            window.refresh();
        } while (ch != '\n');

        window.addstr("Press Enter to quit:");
        window.refresh();
        window.getch();

        window.endwin();
    }
}

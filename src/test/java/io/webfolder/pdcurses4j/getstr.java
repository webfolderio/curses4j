package io.webfolder.pdcurses4j;

import static java.lang.String.format;

public class getstr {

    public static void main(String[] args) {
        Window window = new Window();

        window.initscr();
        window.addstr("Enter the first 3 letters of your first name? ");
        window.refresh();
        String first = window.getnstr(3);

        window.addstr("Enter the first 3 letters of your last name? ");
        window.refresh();
        String last = window.getnstr(3);

        window.printw(format("Your secret agent name is %s%s!", first, last));
        window.refresh();
        window.getch();

        window.endwin();
    }
}

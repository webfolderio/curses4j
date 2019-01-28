package io.webfolder.pdcurses4j;

import static java.lang.String.format;

public class getstr {

    public static void main(String[] args) {
        Window window = new Window();

        window.initscr();
        window.waddstr("Enter the first 3 letters of your first name? ");
        window.wrefresh();
        String first = window.wgetnstr(3);

        window.waddstr("Enter the first 3 letters of your last name? ");
        window.wrefresh();
        String last = window.wgetnstr(3);

        window.wprintw(format("Your secret agent name is %s%s!", first, last));
        window.wrefresh();
        window.wgetch();

        window.endwin();
    }
}

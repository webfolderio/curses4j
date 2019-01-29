package io.webfolder.pdcurses4j;

public class typeahead {

    public static void main(String[] args) {
        Window window = new Window();
        window.initscr();
        Window.typeahead(-1); /* Disable typeahead */

        window.addstr("All this text will be put to the screen without a\n");
        window.addstr("keyboard interruption.");
        window.refresh();
        window.getch();

        Window.endwin();
    }
}

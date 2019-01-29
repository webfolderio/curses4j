package io.webfolder.pdcurses4j;

public class waddch {

    public static void main(String[] args) throws InterruptedException {
        Window window = new Window();
        window.initscr();
        window.addch('H');
        window.addch('i');
        window.addch('!');
        window.refresh();
        window.getch();
        Window.endwin();
    }
}

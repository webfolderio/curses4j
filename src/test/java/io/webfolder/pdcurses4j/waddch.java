package io.webfolder.pdcurses4j;

public class waddch {

    public static void main(String[] args) throws InterruptedException {
        Window window = new Window();
        window.initscr();
        window.waddch('H');
        window.waddch('i');
        window.waddch('!');
        window.wrefresh();
        window.wgetch();
        window.endwin();
    }
}

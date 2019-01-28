package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.COLOR_BLACK;
import static io.webfolder.pdcurses4j.Window.COLOR_GREEN;
import static io.webfolder.pdcurses4j.Window.COLOR_PAIR;
import static io.webfolder.pdcurses4j.Window.COLOR_RED;

public class TextColor {

    public static void main(String[] args) throws Exception {
        Window win = new Window();
        win.initscr();
        win.start_color();
        win.init_pair((short) 1, COLOR_BLACK, COLOR_RED);
        win.init_pair((short) 2, COLOR_BLACK, COLOR_GREEN);
        win.wattr_on(COLOR_PAIR(1));
        win.wprintw("This should be printed in black with a red background!\n");
        win.wattr_on(COLOR_PAIR(2));
        win.wprintw("And this in a green background!\n");
        win.wrefresh();
        win.wgetch();
        win.endwin();
    }
}

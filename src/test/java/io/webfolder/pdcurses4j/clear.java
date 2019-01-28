package io.webfolder.pdcurses4j;

public class clear {

    public static void main(String[] args) {
        int c, y, x, cmax;

        Window window = new Window();

        window.initscr();
        x = window.getmaxx();
        y = window.getmaxy();


        cmax = (x * y) / 5;
        for (c = 0; c < cmax; c++) {
            window.addstr("blah ");
        }
        window.refresh();
        window.getch();
        window.clear(); /* clear the screen */
        window.refresh(); /* don't forget this! */
        window.getch();

        window.endwin();
    }
}

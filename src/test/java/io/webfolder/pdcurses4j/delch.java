package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.ERR;

public class delch {

    public static final int Y = 5;
    public static final int X1 = 10;
    public static final int X2 = 60;
    public static final int DELAY = 250;

    public static void main(String[] args) {
        String text  = "Elvis found alive *** Stock market tops 20,000 *** ";
               text += "Rocky XII big box office hit *** Congressman indicted *** ";

        Window window = new Window();

        window.initscr();
        window.noecho();
        window.nodelay(true);

        for (int i = 0; i < text.length() && window.getch() == ERR; i++) {
            char t = text.charAt(i);
            window.mvinsch(Y, X2, t);
            window.mvdelch(Y, X1);
            window.refresh();
            Window.napms(DELAY);
        }
    }
}

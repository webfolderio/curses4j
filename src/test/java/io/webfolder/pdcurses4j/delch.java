package io.webfolder.pdcurses4j;

import static io.webfolder.pdcurses4j.Window.ERR;

public class delch {

    public static final int Y = 5;
    public static final int X1 = 10;
    public static final int X2 = 60;
    public static final int DELAY = 250;

    public static void main(String[] args) {
        String text = "Elvis found alive *** Stock market tops 20,000 *** Rocky XII big box office hit *** Congressman indicted *** ";

        Window window = new Window();

        window.initscr();
        window.noecho();
        window.nodelay(true);

        for (int i = 0; i < text.length() && window.wgetch() == ERR; i++) {
            char t = text.charAt(i);
            window.mvwinsch(Y, X2, t);
            window.mvwdelch(Y, X1);
            window.wrefresh();
            window.napms(DELAY);
        }
    }
}

package gshivammsg.elements;

import gshivammsg.Resources;

import java.awt.*;

public class Player extends Element {

    public static final int WIDTH = 72;
    public static final int HEIGHT = 90;

    private int imageIndex = 0;
    private boolean inAir = false;

    public Player(int x, int y) {
        super(x, y, WIDTH, HEIGHT, null);
        this.image = getNextImage();
    }

    @Override
    public void update() {
        super.update();
        this.image = getNextImage();
    }

    private Image getNextImage() {
        if(inAir) {
            return Resources.getPlayerJumpImage();
        }
        imageIndex++;
        imageIndex %= 8;
        return Resources.getPlayerImages()[imageIndex];
    }

    public void jump() {
        Resources.getJumpAudio().play();

        this.inAir = true;
        this.yAcc = 1;
        this.yVel = -18;
    }

    public void land() {
        this.inAir = false;
        this.yAcc = 0;
        this.yVel = 0;
    }
}

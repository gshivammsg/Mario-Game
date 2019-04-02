package gshivammsg.elements;

import gshivammsg.Resources;

public class Block extends Element {

    public Block(int x, int y, int xVel) {
        super(x, y, 20, 50, Resources.getBlockImage());

        this.xVel = xVel;
    }
}

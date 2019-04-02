package gshivammsg.elements;

import java.awt.*;

abstract public class Element {
    public int x;
    public int y;
    public int width;
    public int height;
    public Image image;

    public int xVel = 0;
    public int yVel = 0;
    public int xAcc = 0;
    public int yAcc = 0;
    public boolean visible = true;

    public Element(int x, int y, int width, int height, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public void update() {
        x += xVel;
        y += yVel;
        yVel += yAcc;
        xVel += xAcc;
    }

    public boolean isCollidingWith(Element other) {
        boolean xOverlap = (x > other.x && x < other.x + other.width)
                || (other.x > x && other.x < x + width);

        boolean yOverlap = (y > other.y && y < other.y + other.height)
                || (other.y > y && other.y < y + height);

        return visible && other.visible && xOverlap && yOverlap;
    }
}

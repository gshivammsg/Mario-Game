package gshivammsg.screens;

import gshivammsg.elements.Element;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

abstract public class Screen {

    protected List<Element> elements = new ArrayList<>();

    public void update() {
        for (Element e : this.elements) {
            e.update();
        }
    }

    public void draw(Graphics g) {
        for (Element e : this.elements) {
            if (e.visible) {
                g.drawImage(e.image, e.x, e.y, null);
            }
        }
    }

    public void onKeyPress(int keyCode) {

    }

    public void onMousePress(int xCord, int yCord) {

    }
}

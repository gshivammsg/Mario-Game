package gshivammsg.screens;

import gshivammsg.Game;
import gshivammsg.GamePanel;
import gshivammsg.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameOverScreen extends Screen {

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.setColor(Color.red);
        g.setFont(Resources.getTitleFont());
        g.drawString("Game Over", 100, 100);
        g.drawString("Press enter to restart", 100, 140);

        super.draw(g);
    }

    @Override
    public void onKeyPress(int keyCode) {
        if(keyCode == KeyEvent.VK_ENTER) {
            GamePanel.currentScreen = new WelcomeScreen();
        }
    }
}

package gshivammsg;

import gshivammsg.screens.Screen;
import gshivammsg.screens.WelcomeScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel implements KeyListener, MouseListener, Runnable {

    public static Screen currentScreen;

    public GamePanel() {
        super();
        this.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        this.setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
    }

    @Override
    public void addNotify() {
        super.addNotify();

        this.requestFocus();
        Resources.load();

        GamePanel.currentScreen = new WelcomeScreen();

        Thread t = new Thread(this);

        t.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Do nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        currentScreen.onKeyPress(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Do nothing
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mousePressed(MouseEvent e) {
        currentScreen.onMousePress(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Do nothing
    }

    @Override
    public void run() {

        Image bigImage = new BufferedImage(Game.WIDTH, Game.HEIGHT, BufferedImage.TYPE_INT_RGB);

        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {

            }

            Graphics panelGraphics = this.getGraphics();
            Graphics imageGraphics = bigImage.getGraphics();


            currentScreen.update();

            currentScreen.draw(imageGraphics);

            imageGraphics.dispose();

            panelGraphics.drawImage(bigImage, 0, 0, null);
            panelGraphics.dispose();
        }
    }
}
package Main;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class TitleScreen implements KeyboardHandler {
    private final Picture bg;
    private Picture start;
    private Picture title;
    private boolean spacePressed;
    private final Keyboard keyboard;
    private boolean animationRunning;

    public TitleScreen() {
        keyboard = new Keyboard(this);
        bg = new Picture(16, 16, "\\TitleScreen\\startBG.png");
        start = new Picture(162 + 16, 542 + 16, "TitleScreen\\press.png");
        bg.draw();
        title = new Picture(32+16,162+16,"TitleScreen\\title.png");
        title.draw();
        createKeyboardEvents();
        startAnimation();
    }

    private void createKeyboardEvents() {
        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventSpace);
    }

    private void startAnimation() {
        animationRunning = true;
        Thread animationThread = new Thread(() -> {
            while (animationRunning) {
                start.draw();
                try {
                    Thread.sleep(500); // Adjust the delay between appearance and disappearance
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                start.delete();
                try {
                    Thread.sleep(500); // Adjust the delay between disappearance and next appearance
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        animationThread.start();
    }

    public void stopAnimation() {
        animationRunning = false;
    }

    public void start() {
        while (!spacePressed) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stopAnimation();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            spacePressed = true;
            System.out.println("Space bar pressed");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        // No action needed for key release event in this case
    }
}
package Main;

import Entity.Player;
import Objects.OBJ_lighSaber;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.simplegraphics.graphics.Canvas.pause;

public class KeyHandler implements KeyboardHandler {

    private Keyboard keyboard;
    private Player player;
    private GamePanel gamePanel;

    int right;
    int left;
    int up;
    int down;

    public KeyHandler(Player player, GamePanel gamePanel) {
        keyboard = new Keyboard(this);
        this.gamePanel=gamePanel;
        this.player = player;

        createKeyboardEvents();
    }

    public void createKeyboardEvents() {

        //KEYBOARD EVENTS - MOVEMENT RIGHT
        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventRight);

        //KEYBOARD EVENTS - MOVEMENT LEFT
        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventLeft);

        //KEYBOARD EVENTS - MOVEMENT UP
        KeyboardEvent keyboardEventUp = new KeyboardEvent();
        keyboardEventUp.setKey(KeyboardEvent.KEY_UP);
        keyboardEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventUp);

        //KEYBOARD EVENTS - MOVEMENT down
        KeyboardEvent keyboardEventDown = new KeyboardEvent();
        keyboardEventDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventDown);

        //KEYBOARD EVENTS - ESCAPE
        KeyboardEvent keyboardEventEscape = new KeyboardEvent();
        keyboardEventEscape.setKey(KeyboardEvent.KEY_ESC);
        keyboardEventEscape.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventEscape);

        //KEYBOARD EVENTS - SPACE
        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventSpace);

        //KEYBOARD EVENTS - A
        KeyboardEvent keyboardEventAttack= new KeyboardEvent();
        keyboardEventAttack.setKey(KeyboardEvent.KEY_A);
        keyboardEventAttack.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventAttack);

        //KEYBOARD EVENTS - P
        KeyboardEvent keyboardEventPray= new KeyboardEvent();
        keyboardEventPray.setKey(KeyboardEvent.KEY_P);
        keyboardEventPray.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventPray);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                player.moveRight();

                if(right<=5){
                    player.playerPicture.load("\\Player\\moveRight1.png");
                    right++;}
                else {
                    player.playerPicture.load("\\Player\\moveRight2.png");
                    if(right>5){
                        right++;
                        if(right==10){
                            right=0;
                        };
                    };
                }
                break;
            case KeyboardEvent.KEY_ESC:
                Canvas.pause();
                break;
        }
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                player.moveLeft();
                if(left<=5){
                    player.playerPicture.load("\\Player\\moveLeft1.png");
                    left++;}
                else {
                    player.playerPicture.load("\\Player\\moveLeft2.png");
                    if(left>5){
                        left++;
                        if(left==10){
                            left=0;
                        };
                    };
                }
        }
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                player.moveUp();
                if(up<=5){
                    player.playerPicture.load("\\Player\\moveUp1.png");
                    up++;}
                else {
                    player.playerPicture.load("\\Player\\moveUp2.png");
                    if(up>5){
                        up++;
                        if(up==10){
                            up=0;
                        };
                    };
                }
        }
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_DOWN:
                player.moveDown();
                if(down<=5){
                    player.playerPicture.load("\\Player\\moveDown1.png");
                    down++;}
                else {
                    player.playerPicture.load("\\Player\\moveDown2.png");
                    if(down>5){
                        down++;
                        if(down==10){
                            down=0;
                        };
                    };
                }
        }

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_A:
                if (player.hasLightSaber==true) {
                    player.attacking();
                }
        }

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE :
                player.displayCoordenates();
        }

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_P:

                if (player.solidArea.intersects(gamePanel.superObject[8].solidArea)) {

                    gamePanel.superObject[6]=new OBJ_lighSaber();
                    gamePanel.superObject[6].objWorldX=1*GamePanel.tileSize;
                    gamePanel.superObject[6].objWorldY=8*GamePanel.tileSize;
                    gamePanel.superObject[6].objPicture=new Picture(gamePanel.superObject[6].objWorldX,gamePanel.superObject[6].objWorldY,"\\Objects\\lightSaber.png");
                    gamePanel.superObject[6].objPicture.grow((GamePanel.tileSize-GamePanel.originalTileSize)/2,(GamePanel.tileSize-GamePanel.originalTileSize)/2);
                    gamePanel.superObject[6].objPicture.draw();

                }

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

}

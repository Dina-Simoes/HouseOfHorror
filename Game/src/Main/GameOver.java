package Main;

import Entity.Player;
import Tile.TileManager;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.IOException;

public class GameOver implements KeyboardHandler {
    Keyboard keyboard;
    GamePanel gamePanel;
    Player player;
    Picture over;
    Picture win;


    GameOver(GamePanel gamePanel, Player player) {
        this.gamePanel = gamePanel;
        this.player = player;
        keyboard = new Keyboard(this);
        createKeyboardEvents();

    }

    public void clearField() {

        player.playerPicture.delete();
        for (int i = 0; i < gamePanel.monster.length; i++) {
            if (gamePanel.monster[i] != null) {
                gamePanel.monster[i].picture.delete();
                MonsterSetter.monster1.stop();
                MonsterSetter.monster2.stop();
                MonsterSetter.monster0.stop();
            }

        }

    }

    public void state(String winOrLose) {


        if (winOrLose == "win") {
            win = new Picture(96 + 16, 334 + 16, "\\TitleScreen\\win1.png");
            clearField();
            win.draw();
        }
        if (winOrLose == "lose") {
            over = new Picture(128, GamePanel.screenHeight / 2, "\\TitleScreen/\\GameOver.png");
            clearField();
            over.draw();
        }
    }


        private void createKeyboardEvents () {
            KeyboardEvent keyboardEventSpace = new KeyboardEvent();
            keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
            keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(keyboardEventSpace);
        }

        @Override
        public void keyPressed (KeyboardEvent keyboardEvent){
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
                System.exit(0);

                ;
                // over.delete();
                //win.delete();
                //player.reset();
                //gamePanel.reset();
                //player.gamePanel.isRestartRequested=true;


            }

        }

        @Override
        public void keyReleased (KeyboardEvent keyboardEvent){
        }
    }

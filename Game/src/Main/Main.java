package Main;

import Entity.Player;
import Tile.TileManager;
import org.academiadecodigo.simplegraphics.graphics.Canvas;

import java.io.IOException;


public class Main {


    public static void main(String[] args) throws IOException {

        TitleScreen t = new TitleScreen();
        t.start();

        GamePanel gamePanel=new GamePanel();
        MonsterSetter monsterSetter= new MonsterSetter(gamePanel);

        TileManager tileManager= new TileManager(gamePanel);

        gamePanel.setupGame();

        UI ui=new UI(gamePanel);
        //BackGround backGround = new BackGround(gamePanel);

        Player player=new Player(tileManager,gamePanel,ui);

        ThreadCollision threadCollision=new ThreadCollision(gamePanel,tileManager,player);

        monsterSetter.monster0.start();
        monsterSetter.monster1.start();
        monsterSetter.monster2.start();
        threadCollision.threadCollision.start();



        new KeyHandler(player, gamePanel);



    }

}


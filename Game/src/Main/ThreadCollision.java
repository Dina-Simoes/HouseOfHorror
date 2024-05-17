package Main;

import Entity.CollisionChecker;
import Entity.Player;
import Objects.OBJ_Pizza;
import Objects.OBJ_duck;
import Objects.OBJ_heart;
import Objects.OBJ_iceCream;
import Tile.TileManager;
import monster.MON_red;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.lang.reflect.Method;

public class ThreadCollision {

    GamePanel gamePanel;
    TileManager tileManager;
    Player player;
    CollisionChecker collisionChecker;
    MonsterSetter monsterSetter;


    public ThreadCollision(GamePanel gamePanel, TileManager tileManager, Player player) {
        this.gamePanel = gamePanel;
        this.monsterSetter=monsterSetter;
        this.tileManager = tileManager;
        this.player = player;
        this.collisionChecker = collisionChecker;
    }

    public Thread threadCollision = new Thread(new Runnable() {
        @Override
        public void run() {

            double drawInterval = 1000000000 / 3;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;
            long timer = 0;
            int drawCount = 0;

            while (threadCollision != null) {

                currentTime = System.nanoTime();
                delta += (currentTime - lastTime) / drawInterval;
                timer += (currentTime - lastTime);
                lastTime = currentTime;

                if (delta >= 1) {
                    delta--;
                    drawCount++;
                }

                if (timer >= 1000000000) {
                    System.out.println("FPS:" + drawCount);
                    drawCount = 0;
                    timer = 0;
                }

                while (true) {
                    playerCheckMonster(player, gamePanel.monster);
                    player.CurrentLife();

                    if(player.life==0){
                        new GameOver(gamePanel,player).state("lose");
                    }

                    if(OBJ_iceCream.iceCreamCounter==2 && OBJ_duck.duckCounter==2 && OBJ_Pizza.pizzaCounter==2){
                        new GameOver(gamePanel,player).state("win");
                    }

                }

            }


        }
    });

    public void playerCheckMonster(Player player, MON_red[] monster) {

        for (int i = 0; i < gamePanel.monster.length; i++) {

            if (gamePanel.monster[i] != null) {

                //get entity solid area position
                player.solidArea.x = player.worldX + player.solidArea.x;
                player.solidArea.y = player.worldY + player.solidArea.y;

                //get the object solid position
                gamePanel.monster[i].solidArea.x = gamePanel.monster[i].worldX + gamePanel.monster[i].solidArea.x;
                gamePanel.monster[i].solidArea.y = gamePanel.monster[i].worldY + gamePanel.monster[i].solidArea.y;

                if (player.solidArea.intersects(gamePanel.monster[i].solidArea) == true) {

                    if (player.life > 0) {
                        if (player.invincible == false) {
                            player.life--;
                            player.invincible = true;
                        }
                    }
                }
                player.solidArea.x = player.solidAreaDefaultX;
                player.solidArea.y = player.solidAreaDefaultY;
                gamePanel.monster[i].solidArea.x = gamePanel.monster[i].solidAreaDefaultX;
                gamePanel.monster[i].solidArea.y = gamePanel.monster[i].solidAreaDefaultY;

            }


        }
        if (player.invincible == true) {
            player.invincibleCounter++;
            if (player.invincibleCounter > 90) {
                player.invincible = false;
                player.invincibleCounter = 0;
            }
        }
    }


    }







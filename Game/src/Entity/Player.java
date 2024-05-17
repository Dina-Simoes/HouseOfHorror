package Entity;

import Main.GamePanel;
import Main.ThreadCollision;
import Main.UI;
import Objects.OBJ_Pizza;
import Objects.OBJ_duck;
import Objects.OBJ_heart;
import Objects.OBJ_iceCream;
import Tile.TileManager;
import monster.MON_red;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Player extends Entity {

    public static Picture playerPicture;

    // Players default values
    public int worldX = 100;
    public int worldY = 700;
    public int playerSpeed = 4;
    public int speed = playerSpeed;
    public Rectangle solidArea;
    public Rectangle attackArea=new Rectangle(0,0,0,0);
    public boolean invincible = false;
    public int invincibleCounter = 0;
    ThreadCollision threadCollision;

    boolean down=false;
    boolean up=false;
    boolean left=false;
    boolean right=false;

    TileManager tileManager;
    GamePanel gamePanel;
    UI ui;
    public boolean hasLightSaber=false;

    public Player(TileManager tileManager, GamePanel gamePanel, UI ui) {
        this.gamePanel = gamePanel;
        this.tileManager = tileManager;

        this.playerPicture = new Picture(worldX, worldY, "\\Player\\moveDown1.png");   //inicial image when spawn
        playerPicture.grow((GamePanel.tileSize - GamePanel.originalTileSize) / 2, (GamePanel.tileSize - GamePanel.originalTileSize) / 2);  //grow player image to scale
        this.ui = ui;

        solidArea = new Rectangle();
        solidArea.x = 8;   //for tile collision checker
        solidArea.y = 16;    //for tile collision checker
        solidArea.width = 15;  //for tile collision checker
        solidArea.height = 15;   //for tile collision checker
        solidAreaDefaultX = solidArea.x;   //for object collision checker
        solidAreaDefaultY = solidArea.y;   //for object collision checker

        playerPicture.draw();  //draw player image;

        //Player Status
        maxLife = 6;
        life = maxLife;
    }

    public void CurrentLife() {
        switch (life) {
            case 0:
                ui.heartPicture.load("\\Objects\\empty_heart.png");
                ui.heartPicture2.load("\\Objects\\empty_heart.png");
                ui.heartPicture3.load("\\Objects\\empty_heart.png");
                break;
            case 1:
                ui.heartPicture.load("\\Objects\\empty_heart.png");
                ui.heartPicture2.load("\\Objects\\empty_heart.png");
                ui.heartPicture3.load("\\Objects\\half_heart.png");
                break;
            case 2:
                ui.heartPicture.load("\\Objects\\empty_heart.png");
                ui.heartPicture2.load("\\Objects\\empty_heart.png");
                ui.heartPicture3.load("\\Objects\\heart.png");
                break;
            case 3:
                ui.heartPicture.load("\\Objects\\empty_heart.png");
                ui.heartPicture2.load("\\Objects\\half_heart.png");
                ui.heartPicture3.load("\\Objects\\heart.png");
                break;
            case 4:
                ui.heartPicture.load("\\Objects\\empty_heart.png");
                ui.heartPicture2.load("\\Objects\\heart.png");
                ui.heartPicture3.load("\\Objects\\heart.png");
                break;
            case 5:
                ui.heartPicture.load("\\Objects\\half_heart.png");
                ui.heartPicture2.load("\\Objects\\heart.png");
                ui.heartPicture3.load("\\Objects\\heart.png");
                break;
            case 6:
                ui.heartPicture.load("\\Objects\\heart.png");
                ui.heartPicture2.load("\\Objects\\heart.png");
                ui.heartPicture3.load("\\Objects\\heart.png");
                break;
        }
    }

    public void displayCoordenates() {
        System.out.println("playerX: " + worldX);
        System.out.println("playerY: " + worldY);
    }

    public void moveRight() {
        direction = "right";
        CollisionChecker collisionChecker = new CollisionChecker(tileManager, gamePanel);
        collisionChecker.playerCheckTile(this);
        int objectIndex = collisionChecker.playerCheckObject(this, true);
        pickUpObject(objectIndex);

        if (collisionOn == true) {
            collisionOn = false;
        } else if (collisionOn == false) {
            if (worldX < GamePanel.screenWidth - 32) {
                playerPicture.translate(playerSpeed, 0);
                worldX = worldX + playerSpeed;
            }
        }
    }

    public void moveLeft() {
        direction = "left";
        CollisionChecker collisionChecker = new CollisionChecker(tileManager, gamePanel);
        collisionChecker.playerCheckTile(this);
        int objectIndex = collisionChecker.playerCheckObject(this, true);
        pickUpObject(objectIndex);

        if (collisionOn == false) {
            if (worldX > 0) {
                playerPicture.translate(-playerSpeed, 0);
                worldX = worldX - playerSpeed;
            }
        } else if (collisionOn == true) {
            collisionOn = false;
        }
    }

    public void moveUp() {
        direction = "up";
        CollisionChecker collisionChecker = new CollisionChecker(tileManager, gamePanel);
        collisionChecker.playerCheckTile(this);
        int objectIndex = collisionChecker.playerCheckObject(this, true);
        pickUpObject(objectIndex);

        if (collisionOn == false) {
            if (worldY > 0) {
                playerPicture.translate(0, -playerSpeed);
                worldY = worldY - playerSpeed;
            }
        } else if (collisionOn == true) {
            collisionOn = false;
        }
    }

    public void moveDown() {
        direction = "down";

        CollisionChecker collisionChecker = new CollisionChecker(tileManager, gamePanel);
        collisionChecker.playerCheckTile(this);
        int objectIndex = collisionChecker.playerCheckObject(this, true);
        pickUpObject(objectIndex);

        if (collisionOn == false) {
            if (worldY < GamePanel.screenHeight - 32) {
                playerPicture.translate(0, playerSpeed);
                worldY = worldY + playerSpeed;
            }
        } else if (collisionOn == true) {
            collisionOn = false;
        }
    }

    public void pickUpObject(int index) {

        if (index != 999) {

            switch (gamePanel.superObject[index].name) {
                case "Pizza":
                    gamePanel.superObject[index].objPicture.delete();
                    gamePanel.superObject[index] = null;
                    OBJ_Pizza.pizzaCounter = OBJ_Pizza.pizzaCounter + 1;
                    ui.pizzaCounter.setText("x" + String.valueOf(OBJ_Pizza.pizzaCounter));
                    break;
                case "Duck":
                    gamePanel.superObject[index].objPicture.delete();
                    gamePanel.superObject[index] = null;
                    OBJ_duck.duckCounter = OBJ_duck.duckCounter + 1;
                    ui.duckCounter.setText("x" + String.valueOf(OBJ_duck.duckCounter));
                    break;
                case "Icecream":
                    gamePanel.superObject[index].objPicture.delete();
                    gamePanel.superObject[index] = null;
                    OBJ_iceCream.iceCreamCounter = OBJ_iceCream.iceCreamCounter + 1;
                    ui.iceCreamCounter.setText("x" + String.valueOf(OBJ_iceCream.iceCreamCounter));
                    break;
                case "Lightsaber":
                    gamePanel.superObject[index].objPicture.delete();
                    gamePanel.superObject[index] = null;
                    hasLightSaber=true;
                    break;
                case "skate":
                    gamePanel.superObject[index].objPicture.delete();
                    gamePanel.superObject[index] = null;
                    playerSpeed = 2 * playerSpeed;
                    break;
            }

        }
    }

    public void playerCheckAttack(Player player, MON_red[] monster) {

        for (int i = 0; i < gamePanel.monster.length; i++) {

            if (gamePanel.monster[i] != null) {


                //get the object solid position
                gamePanel.monster[i].solidArea.x = gamePanel.monster[i].worldX + gamePanel.monster[i].solidArea.x;
                gamePanel.monster[i].solidArea.y = gamePanel.monster[i].worldY + gamePanel.monster[i].solidArea.y;


                switch (player.direction) {
                    case "up":

                        player.attackArea.x=player.worldX;
                        player.attackArea.y=player.worldY-35;

                        System.out.println(player.attackArea.intersects(gamePanel.monster[i].solidArea));

                        if (player.attackArea.intersects(gamePanel.monster[i].solidArea)) {

                            if (gamePanel.monster[i].life > 5) {
                                gamePanel.monster[i].life = gamePanel.monster[i].life - 5;
                            } else {
                                gamePanel.monster[i].life = 0;
                                gamePanel.monster[i].picture.delete();
                                gamePanel.monster[i]=null;
                            }
                            break;
                        }

                    case "down":

                        player.attackArea.x=player.worldX;
                        player.attackArea.y=player.worldY+GamePanel.tileSize;

                        if (player.attackArea.intersects(gamePanel.monster[i].solidArea)) {

                            if (gamePanel.monster[i].life > 5) {
                                gamePanel.monster[i].life = gamePanel.monster[i].life - 5;
                            } else {
                                gamePanel.monster[i].life = 0;
                                gamePanel.monster[i].picture.delete();
                                gamePanel.monster[i]=null;
                            }
                            break;
                        }

                    case "right":
                        player.attackArea.x=player.worldX+GamePanel.tileSize;
                        player.attackArea.y=player.worldY;


                        if (player.attackArea.intersects(gamePanel.monster[i].solidArea)) {

                            if (gamePanel.monster[i].life > 5) {
                                gamePanel.monster[i].life = gamePanel.monster[i].life - 5;
                            } else {
                                gamePanel.monster[i].life = 0;
                                gamePanel.monster[i].picture.delete();
                                gamePanel.monster[i]=null;
                            }
                            break;
                        }

                    case "left":

                        player.attackArea.x=player.worldX-35;
                        player.attackArea.y=player.worldY;


                        if (player.attackArea.intersects(gamePanel.monster[i].solidArea)) {

                            if (gamePanel.monster[i].life > 5) {
                                gamePanel.monster[i].life = gamePanel.monster[i].life - 5;
                            } else {
                                gamePanel.monster[i].life = 0;
                                gamePanel.monster[i].picture.delete();
                                gamePanel.monster[i]=null;
                            }
                            break;
                        }
                        if(gamePanel.monster[i]!=null) {
                            gamePanel.monster[i].solidArea.x = gamePanel.monster[i].solidAreaDefaultX;
                            gamePanel.monster[i].solidArea.y = gamePanel.monster[i].solidAreaDefaultY;
                        }
                }
            }
        }
    }

    public void attacking() {


        if(direction == "down"){
            attackArea= new Rectangle(worldX,worldY+ GamePanel.tileSize,35,35);

            if(down==true) {
                playerPicture.load("\\Player\\moveDown1.png");
                down = false;
            } else if (down==false) {
                playerPicture.load("\\Player\\downAttack1.png");
                down = true;
            }

            playerCheckAttack(this, gamePanel.monster);
        }

        if(direction == "up"){
            attackArea= new Rectangle(worldX,worldY-35,35,35);

            if(up==true) {
                playerPicture.load("\\Player\\moveUp1.png");
                up = false;
            } else if (up==false) {
                playerPicture.load("\\Player\\upAttack1.png");
                up = true;
            }

            playerCheckAttack(this, gamePanel.monster);

        }

        if(direction == "right"){
            attackArea= new Rectangle(worldX+GamePanel.tileSize,worldY,35,35);

            if(right==true) {
                playerPicture.load("\\Player\\moveRight1.png");
                right = false;
            } else if (right==false) {
                playerPicture.load("\\Player\\rightAttack1.png");
                right = true;
            }

            playerCheckAttack(this, gamePanel.monster);
        }

        if(direction == "left"){
            attackArea= new Rectangle(worldX-35,worldY,35,35);

            if(left==true) {
                playerPicture.load("\\Player\\moveLeft1.png");
                left = false;
            } else if (left==false) {
                playerPicture.load("\\Player\\leftAttack1.png");
                left = true;
            }

            playerCheckAttack(this, gamePanel.monster);
        }

    }


}


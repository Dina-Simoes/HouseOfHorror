package io.codeforall.entity;

import io.codeforall.main.GamePanel;
import io.codeforall.main.KeyHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{

    GamePanel gamePanel;
    KeyHandler keyHandler;

    //CONSTRUCTOR
    public Player(GamePanel gamePanel, KeyHandler keyHandler){

        this.gamePanel=gamePanel;
        this.keyHandler=keyHandler;

        setDefaultValues();
        getPlayerImage();
    }

    //player default values
    public void setDefaultValues(){
        x=100;
        y=100;
        speed=4;
        direction="down";
    }

    //import player images
    public void getPlayerImage(){
        try{
            up1= ImageIO.read(getClass().getResourceAsStream("/player/moveUp1.png"));
            up2=ImageIO.read(getClass().getResourceAsStream("/player/moveUp2.png"));
            down1=ImageIO.read(getClass().getResourceAsStream("/player/moveDown1.png"));
            down2=ImageIO.read(getClass().getResourceAsStream("/player/moveDown2.png"));
            left1=ImageIO.read(getClass().getResourceAsStream("/player/moveLeft1.png"));
            left2=ImageIO.read(getClass().getResourceAsStream("/player/moveLeft2.png"));
            right1=ImageIO.read(getClass().getResourceAsStream("/player/moveRight1.png"));
            right2=ImageIO.read(getClass().getResourceAsStream("/player/moveRight2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){

        //update spriteCounter only when we press a key
        if (keyHandler.upPressed==true || keyHandler.downPressed==true || keyHandler.leftPressed==true || keyHandler.rightPressed==true) {
            if (keyHandler.upPressed == true) {
                direction = "up";
                y -= speed;
            } else if (keyHandler.downPressed == true) {
                direction = "down";
                y += speed;
            } else if (keyHandler.leftPressed == true) {
                direction = "left";
                x -= speed;
            } else if (keyHandler.rightPressed == true) {
                direction = "right";
                x += speed;
            }

            //update player images every 12 frames
            //update sprite 1 to 2, and 2 yo 1
            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

    }




    public void draw(Graphics2D g2){

        BufferedImage image=null;

        Picture picture = new Picture();

        switch (direction){
            case "up":
                if (spriteNum==1) {
                    image = up1;
                }
                if (spriteNum==2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum==1) {
                    image = down1;
                }
                if (spriteNum==2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum==1) {
                    image = left1;
                }
                if (spriteNum==2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum==1) {
                    image = right1;
                }
                if (spriteNum==2) {
                    image = right2;
                }
                break;



        }

        // DRAW IMAGE AT X AND Y POINT, ATE TILESIZE SIZES
        g2.drawImage(image,x,y,gamePanel.tileSize, gamePanel.tileSize,null);

    }
}

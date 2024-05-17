package monster;

import Entity.Entity;
import Main.GamePanel;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;
import java.util.Random;
import java.util.TimerTask;

public class MON_red extends Entity {

GamePanel gamePanel;

int fPointX;
int fPointY;
int lPointX;
int lPointY;
public int currentX;
public int currentY;
public Rectangle solidArea=new Rectangle(9,18,30,30);

public String movement;
private int actionLockCounter=0;
public Picture picture;
        //up1,up2,down1,down2,left1,left2,right1,right2;

public MON_red(GamePanel gamePanel){
    this.gamePanel=gamePanel;
    name="Red Hood Demon";
    speed=1;
    maxLife=10;
    life=maxLife;
    solidAreaDefaultX=solidArea.x;
    solidAreaDefaultY=solidArea.y;

}

public void setActionH(int fPointX, int lPointX) throws InterruptedException {

    currentX = fPointX;

    int down = 0;
    while (true) {

        Thread.sleep(10);

        if (fPointX == currentX) {
            movement = "right";
        } else if (currentX == lPointX) {
            movement = "left";
        }
        if (movement == "right") {
            picture.translate(+speed, 0);
            currentX = currentX + speed;
            worldX=worldX+speed;

            if (down <= 10) {
                picture.load("\\monster\\monster2\\right1.png");
                down++;
            } else {
                picture.load("\\monster\\monster2\\right2.png");
                if (down > 10) {
                    down++;
                    if (down == 20) {
                        down = 0;
                    }
                }
            }
            if (currentX == lPointX) {
                movement = "left";
            }
        }

        if (movement == "left") {
            picture.translate(-speed, 0);
            currentX = currentX - speed;
            worldX=worldX-speed;

            if (down <= 10) {
                picture.load("\\monster\\monster2\\left1.png");
                down++;

            } else {
                picture.load("\\monster\\monster2\\left2.png");
                if (down > 10) {
                    down++;
                    if (down == 20) {
                        down = 0;
                    }
                }
            }
        }
        if (currentX == fPointX) {
            movement = "right";
        }
    }
}

    public void setActionV(int fPointY, int lPointY) throws InterruptedException {

    currentY=fPointY;

        int down=0;
        while(true){

            Thread.sleep(10);

            if (fPointY==currentY){
                movement="down";
            } else if (currentY==lPointY) {
                movement="up";
            }

            if (movement=="down"){
                picture.translate(0,+speed);
                currentY=currentY+speed;
                worldY=worldY+speed;

                if(down<=10){
                    picture.load("\\monster\\monster2\\down1.png");
                    down++;}
                else{
                    picture.load("\\monster\\monster2\\down2.png");
                    if (down > 10) {
                        down++;
                        if (down == 20) {
                            down = 0;
                        }
                    }
                }
                if (currentY==lPointY) {movement="up";}
            }

            if (movement=="up") {
                picture.translate(0,-speed);
                currentY = currentY - speed;
                worldY=worldY-speed;

                if (down <= 10) {
                    picture.load("\\monster\\monster2\\up1.png");
                    down++;

                } else {
                    picture.load("\\monster\\monster2\\up2.png");
                    if (down > 10) {
                        down++;
                        if (down == 20) {
                            down = 0;
                        }
                    }
                }
            } if (currentY==fPointY) {movement="down";}

        }
    }
}










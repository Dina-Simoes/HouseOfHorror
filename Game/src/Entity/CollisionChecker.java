package Entity;

import Main.GamePanel;
import Tile.TileManager;
import monster.MON_red;

public class CollisionChecker {



    TileManager tileManager;
    GamePanel gamePanel;

    public CollisionChecker(TileManager tileManager, GamePanel gamePanel) {

        this.tileManager = tileManager;
        this.gamePanel=gamePanel;
    }

    public void playerCheckTile(Player player) {

        int playerLeftWorldX = player.worldX + player.solidArea.x;
        int playerRightWorldX = player.worldX + player.solidArea.x + player.solidArea.width;
        int playerTopWorldY = player.worldY + player.solidArea.y;
        int playerBottomWorldY = player.worldY + player.solidArea.y + player.solidArea.height;

        int playerLeftCol = playerLeftWorldX / GamePanel.tileSize;
        int playerRightCol = playerRightWorldX / GamePanel.tileSize;
        int playerTopRow = playerTopWorldY / GamePanel.tileSize;
        int playerBottomRow = playerBottomWorldY / GamePanel.tileSize;

        int tileNum1, tileNum2;

        switch (player.direction) {
            case "up":

                    playerTopRow = (playerTopWorldY - player.playerSpeed) / GamePanel.tileSize;
                    tileNum1 = tileManager.mapTileNum[playerLeftCol][playerTopRow];
                    tileNum2 = tileManager.mapTileNum[playerRightCol][playerTopRow];

                    if (tileManager.tile[tileNum1].collision == true || tileManager.tile[tileNum2].collision == true) {
                        player.collisionOn = true;
                    }
                break;
            case "down":

                    playerBottomRow = (playerBottomWorldY + player.playerSpeed) / GamePanel.tileSize;
                    tileNum1 = tileManager.mapTileNum[playerLeftCol][playerBottomRow];
                    tileNum2 = tileManager.mapTileNum[playerRightCol][playerBottomRow];

                    if (tileManager.tile[tileNum1].collision == true || tileManager.tile[tileNum2].collision == true) {
                        player.collisionOn = true;
                    }
                   break;
            case "right":
                    playerRightCol = (playerRightWorldX + player.playerSpeed) / GamePanel.tileSize;
                    tileNum1 = tileManager.mapTileNum[playerRightCol][playerTopRow];
                    tileNum2 = tileManager.mapTileNum[playerRightCol][playerBottomRow];
                    if (tileManager.tile[tileNum1].collision == true || tileManager.tile[tileNum2].collision == true) {
                        player.collisionOn = true;
                    }
                    break;
            case "left":
                    playerLeftCol = (playerLeftWorldX - player.playerSpeed) / GamePanel.tileSize;
                    tileNum1 = tileManager.mapTileNum[playerLeftCol][playerTopRow];
                    tileNum2 = tileManager.mapTileNum[playerLeftCol][playerBottomRow];
                    if (tileManager.tile[tileNum1].collision == true || tileManager.tile[tileNum2].collision == true) {
                        player.collisionOn = true;
                    }
                break;
        }
    }

    public int playerCheckObject(Player player, boolean isPlayer) {

        int index = 999;

        for (int i = 0; i < gamePanel.superObject.length; i++) {

            if(gamePanel.superObject[i]!=null) {

                //get entity solid area position
                player.solidArea.x = player.worldX + player.solidArea.x;
                player.solidArea.y = player.worldY + player.solidArea.y;

                //get the object solid position
                gamePanel.superObject[i].solidArea.x = gamePanel.superObject[i].objWorldX + gamePanel.superObject[i].solidArea.x;
                gamePanel.superObject[i].solidArea.y = gamePanel.superObject[i].objWorldY + gamePanel.superObject[i].solidArea.y;


                switch (player.direction) {
                    case "up":
                        player.solidArea.y -= player.speed;

                        if (player.solidArea.intersects(gamePanel.superObject[i].solidArea)) {
                            if(gamePanel.superObject[i].collision==true){
                                player.collisionOn=true;
                            }
                            if(isPlayer==true){
                                index=i;
                            }
                        }
                        break;
                    case "down":
                        player.solidArea.y += player.playerSpeed;
                        if (player.solidArea.intersects(gamePanel.superObject[i].solidArea)) {
                            if(gamePanel.superObject[i].collision==true){
                                player.collisionOn=true;
                            }
                            if(isPlayer==true){
                                index=i;
                            }
                        }
                        break;
                    case "right":
                        player.solidArea.x += player.playerSpeed;
                        if (player.solidArea.intersects(gamePanel.superObject[i].solidArea)) {
                            if(gamePanel.superObject[i].collision==true){
                                player.collisionOn=true;
                            }
                            if(isPlayer==true){
                                index=i;
                            }
                        }
                        break;
                    case "left":
                        player.solidArea.x -= player.playerSpeed;
                        if (player.solidArea.intersects(gamePanel.superObject[i].solidArea)) {
                            if(gamePanel.superObject[i].collision==true){
                                player.collisionOn=true;
                            }
                            if(isPlayer==true){
                                index=i;
                            }
                        }
                        break;
                }
                player.solidArea.x=player.solidAreaDefaultX;
                player.solidArea.y=player.solidAreaDefaultY;
                gamePanel.superObject[i].solidArea.x=gamePanel.superObject[i].solidAreaDefaultX;
                gamePanel.superObject[i].solidArea.y=gamePanel.superObject[i].solidAreaDefaultY;
            }
        }
        return index;
    }



}

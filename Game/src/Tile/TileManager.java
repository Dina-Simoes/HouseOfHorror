package Tile;

import Main.GamePanel;
import org.academiadecodigo.simplegraphics.pictures.Picture;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gamePanel;
    public Tile[] tile;
    Picture tempPicture;
    public int mapTileNum[][];

    public TileManager(GamePanel gamePanel) throws IOException {
        this.gamePanel=gamePanel;
        tile=new Tile[35]; //Quantity of tiles types !!!
        mapTileNum=new int[gamePanel.maxScreenCol][gamePanel.maxScreenRow];
        loadMap("/maps/map.txt");
        draw2();
    }

    public void loadMap(String filePath){

        try{
            InputStream is = getClass().getResourceAsStream(filePath); //import the text file from maps!
            BufferedReader br = new BufferedReader(new InputStreamReader(is)); //read the content of text file!

            int col=0;
            int row=0;

            while(col< gamePanel.maxScreenCol && row< gamePanel.maxScreenRow){

                String line = br.readLine(); // Read a line of text

                while(col< gamePanel.maxScreenCol){
                    String numbers[] = line.split(" ");  // split the string at a space
                    int num = Integer.parseInt(numbers[col]); // change String to Integer
                    mapTileNum[col][row]=num; // Store the extracted number to mapTileNum
                    col++;
                }
                if(col== gamePanel.maxScreenCol){
                    col=0;
                    row++;
                }
            }
            br.close();
        }catch (Exception e){
        }
    }

    public void draw2(){

        int col=0;
        int row=0;
        int x= gamePanel.tileSize/2;
        int y= gamePanel.tileSize/2;

        while (col<gamePanel.maxScreenCol && row< gamePanel.maxScreenRow){

            int tileNum=mapTileNum[col][row];

            String pathTile = null;

            switch (tileNum) {
                case 0:
                    pathTile = "\\Tiles\\[0]tileGrass.png";
                    break;
                case 1:
                    pathTile = "\\Tiles\\[1]tileWood.png";
                    break;
                case 2:
                    pathTile = "\\Tiles\\[2]tileWall1.png";
                    break;
                case 3:
                    pathTile = "\\Tiles\\[3]tileWall2.png";
                    break;
                case 4:
                    pathTile = "\\Tiles\\[4]tileWall3.png";
                    break;
                case 5:
                    pathTile = "\\Tiles\\[5]tilePuff.png";
                    break;
                case 6:
                    pathTile = "\\Tiles\\[6]tilePuffs1.png";
                    break;
                case 7:
                    pathTile = "\\Tiles\\[7]tilePuffs2.png";
                    break;
                case 8:
                    pathTile = "\\Tiles\\[8]tileWall4.png";
                    break;
                case 9:
                    pathTile = "\\Tiles\\[9]tileWall5.png";
                    break;
                case 10:
                    pathTile = "\\Tiles\\[10]tileTv1.png";
                    break;
                case 11:
                    pathTile = "\\Tiles\\[11]tileTv2.png";
                    break;
                case 12:
                    pathTile = "\\Tiles\\[12]tileConsole.png";
                    break;
                case 13:
                    pathTile = "\\Tiles\\[13]tileIceCream.png";
                    break;
                case 14:
                    pathTile = "\\Tiles\\[14]tileBigDuck.png";
                    break;
                case 15:
                    pathTile = "\\Tiles\\[15]tilePizza1.png";
                    break;
                case 16:
                    pathTile = "\\Tiles\\[16]tilePizza2.png";
                    break;
                case 17:
                    pathTile = "\\Tiles\\[17]tileWall6.png";
                    break;
                case 18:
                    pathTile = "\\Tiles\\[18]tileWall7.png";
                    break;
                case 19:
                    pathTile = "\\Tiles\\[19]tileWall8.png";
                    break;
                case 20:
                    pathTile = "\\Tiles\\[20]tileMcsTable1.png";
                    break;
                case 21:
                    pathTile = "\\Tiles\\[21]tileMcsTable2.png";
                    break;
                case 22:
                    pathTile = "\\Tiles\\[22]tileMcsTable3.png";
                    break;
                case 23:
                    pathTile = "\\Tiles\\[23]tileMcsTable4.png";
                    break;
                case 24:
                    pathTile = "\\Tiles\\[24]tilePcTable1.png";
                    break;
                case 25:
                    pathTile = "\\Tiles\\[25]tilePcTable2.png";
                    break;
                case 26:
                    pathTile = "\\Tiles\\[26]tilePcTable3.png";
                    break;
                case 27:
                    pathTile = "\\Tiles\\[27]tilePcTable4.png";
                    break;
                case 28:
                    pathTile = "\\Tiles\\[28]tileChair.png";
                    break;
                case 29:
                    pathTile = "\\Tiles\\[29]tilePcTable5.png";
                    break;
                case 30:
                    pathTile = "\\Tiles\\[30]tilePcTable6.png";
                    break;
                case 31:
                    pathTile = "\\Tiles\\[31]tilePcTable7.png";
                    break;
                case 32:
                    pathTile = "\\Tiles\\[32]tilePcTable8.png";
                    break;
                case 33:
                    pathTile = "\\Tiles\\[33]tilePcTable9.png";
                    break;
                case 34:
                    pathTile = "\\Tiles\\[34]tilePcTable10.png";
                    break;
            }

            try {
                tile[tileNum]= new Tile();
                tile[tileNum].tilePicture=new Picture(x,y,pathTile);
                tile[tileNum].tilePicture.grow((gamePanel.tileSize-gamePanel.originalTileSize)/2,(gamePanel.tileSize-gamePanel.originalTileSize)/2);
                tile[tileNum].tilePicture.draw();

             }catch (Exception e) {
            }

            col++;
            x += gamePanel.tileSize;

            if(col== gamePanel.maxScreenCol){
                col=0;
                x=gamePanel.tileSize/2;
                row++;
                y+= gamePanel.tileSize;
            }
        }

        tile[0].collision = false;
        tile[1].collision = false;
        tile[2].collision = true;
        tile[3].collision = true;
        tile[4].collision = true;
        tile[5].collision = true;
        tile[6].collision = true;
        tile[7].collision = true;
        tile[8].collision = true;
        tile[9].collision = true;
        tile[10].collision = true;
        tile[11].collision = true;
        tile[12].collision = true;
        //tile[13].collision = true;
        //tile[14].collision = true;
        //tile[15].collision = true;
        //tile[16].collision = true;
        tile[17].collision = true;
        tile[18].collision = true;
        tile[19].collision = true;
        tile[20].collision = true;
        tile[21].collision = true;
        tile[22].collision = true;
        tile[23].collision = true;
        tile[24].collision = true;
        tile[25].collision = true;
        tile[26].collision = true;
        tile[27].collision = true;
        tile[28].collision = true;
        tile[29].collision = true;
        tile[30].collision = true;
        tile[31].collision = true;
        tile[32].collision = true;
        tile[33].collision = true;
        tile[34].collision = true;

    }


}

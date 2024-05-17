package io.codeforall.tile;

import io.codeforall.main.GamePanel;
import javafx.embed.swing.SwingFXUtils;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    GamePanel gamePanel;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gamePanel){
        this.gamePanel=gamePanel;
        tile=new Tile[10]; //Quantity of tiles types !!!
        mapTileNum=new int[gamePanel.maxScreenCol][gamePanel.maxScreenRow];
        getTileImage();
        loadMap("/maps/map.txt");
    }

    public void getTileImage(){

        try{
            tile[0]= new Tile();
            tile[0].image=ImageIO.read(getClass().getResourceAsStream("/tiles/tileWood.png"));


            tile[1]= new Tile();
            tile[1].image=ImageIO.read(getClass().getResourceAsStream("/tiles/tileGrass.png"));



        }catch (IOException e){
            e.printStackTrace();
        }


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



    public void draw(Graphics2D g2){


        int col=0;
        int row=0;
        int x=0;
        int y=0;

        while (col<gamePanel.maxScreenCol && row< gamePanel.maxScreenRow){

            int tileNum=mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image,x,y, gamePanel.tileSize, gamePanel.tileSize, null);

            col++;
            x += gamePanel.tileSize;

            if(col== gamePanel.maxScreenCol){
                col=0;
                x=0;
                row++;
                y+= gamePanel.tileSize;
            }

        }

    }

}

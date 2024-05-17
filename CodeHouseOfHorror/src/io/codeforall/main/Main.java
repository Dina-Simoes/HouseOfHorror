package io.codeforall.main;

import io.codeforall.main.GamePanel;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame window= new JFrame(); //window instance
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // let the window close with the X button
        window.setResizable(false); //fixed size window
        window.setTitle("CodeHouseOfHorror"); //Game Title

        GamePanel gamePanel=new GamePanel(); //GamePanel classe instance

        window.add(gamePanel); // add gamePlanel to the window


        window.pack();  //window to be sized to fit the preferred size of subcomponent (gamePanel);

        window.setLocationRelativeTo(null); //Not specify the location of screen. Display the window at the centre of screen
        window.setVisible(true); //set the window visible

        gamePanel.startGameThread();







    }
}

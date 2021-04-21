package lesson7;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {

    public static final int PVE_MODE = 0;
    public static final int PVP_MODE = 1;

    GameMap() {
        setBackground(Color.LIGHT_GRAY);
    }

    void startGame(int gameMode, int gameMapSizeX, int gameMapSizeY, int winLength) {
        System.out.println("Game start with settings: [game mode = " + gameMode +
                "] [map size = " + gameMapSizeX + "x" + gameMapSizeY + "] [winLength = " + winLength + "]");
    }
}

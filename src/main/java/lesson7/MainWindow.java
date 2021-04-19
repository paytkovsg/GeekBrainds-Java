package lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

    //объявляем размеры окна
    private final int winWidth = 500;
    private final int winHeight = 600;
    private final int winPosX = 650;
    private final int winPosY = 300;

    private Settings settings;
    private GameMap gameMap;

    MainWindow() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(winWidth, winHeight);//размеры;
        setLocation(winPosX, winPosY); //локация;
        setTitle("Добро пожаловать в игру!!!");
        settings = new Settings(this);
        gameMap = new GameMap();

//        setResizable(false);//запрет изменения размеров, по умолчанию true;

        JButton btnStart = new JButton("Запустить игру");
        btnStart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);

            }
        });

        JButton btnExit = new JButton("Выйти из игры");
        btnExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
        JPanel panelForButton = new JPanel();
        panelForButton.setLayout(new GridLayout(1, 2));
        panelForButton.add(btnStart);
        panelForButton.add(btnExit);
        add(panelForButton, BorderLayout.SOUTH);


        add(gameMap);




        setVisible(true);//отвечает за отображение, указывается самым последним;

    }
    void getUserSettingsAndStartGame(int gameMode, int fieldSizeX, int fieldSizeY,  int winLength) {
        gameMap.startGame(gameMode, fieldSizeX, fieldSizeY, winLength);

    }
}

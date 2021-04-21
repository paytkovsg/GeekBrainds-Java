package lesson7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    private final int winWidth = 350;
    private final int winHeight = 250;
    private MainWindow mainWindow;
    private JRadioButton pveRb;
    private JRadioButton pvpRb;
    private JButton btnSaveUserSettings;
    private JLabel currentFieldSizeLabel;
    private JSlider sliderFieldSize;
    private final int minFieldSize = 3;
    private final int maxFieldSize = 10;
    private JLabel currentWinLengthLabel;
    private JSlider sliderWinLength;
    private final int minWinLength = 3;

    Settings(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        Rectangle mainWindowBounds = mainWindow.getBounds();
        int coordinateX = (int)mainWindowBounds.getCenterX() - winWidth / 2;
        int coordinateY = (int)mainWindowBounds.getCenterY() - winHeight / 2;
        setLocation(coordinateX, coordinateY);
        setResizable(false);
        setLayout(new GridLayout(10, 1));
        setTitle("Настойки игры");
        setSize(winWidth, winHeight);
        setupGameMode();
        setupFieldSizeSetting();
        setupWinLength();
        collectAndSendUserSetting();
    }

    private void setupGameMode() {
        add(new JLabel("Настройки типа игры"));
        pveRb = new JRadioButton("PVE", true);
        pvpRb = new JRadioButton("PVP");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(pveRb);
        buttonGroup.add(pvpRb);
        add(pveRb);
        add(pvpRb);
    }

    private void setupFieldSizeSetting() {
        add(new JLabel("Настройки игрового поля"));
        currentFieldSizeLabel = new JLabel("Выбран размер игрового поля: 3x3");
        sliderFieldSize = new JSlider(minFieldSize, maxFieldSize, minFieldSize);
        sliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = sliderFieldSize.getValue();
                currentFieldSizeLabel.setText("Выбран размер игрового поля: " + currentValue + "x" + currentValue);
                sliderWinLength.setMaximum(currentValue);
            }
        });
        add(currentFieldSizeLabel);
        add(sliderFieldSize);
    }

    private void setupWinLength() {
        add(new JLabel("Настройки выигрышной длины"));
        currentWinLengthLabel = new JLabel("Выигрышная длина: 3");
        sliderWinLength = new JSlider(minWinLength, minFieldSize, minFieldSize);
        sliderWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentWinLengthLabel.setText("Выигрышная длина: " + sliderWinLength.getValue());
            }
        });
        add(currentWinLengthLabel);
        add(sliderWinLength);
    }

    private void collectAndSendUserSetting() {
        btnSaveUserSettings = new JButton("Сохранить и начать игру");
        btnSaveUserSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectUserSettings();
            }
        });
        add(btnSaveUserSettings);





    }
    private void collectUserSettings() {
        int gameMode;

        if (pvpRb.isSelected()) {
            gameMode = GameMap.PVE_MODE;
        } else if (pveRb.isSelected()) {
            gameMode = GameMap.PVP_MODE;
        } else {
            JOptionPane.showMessageDialog(this, "Что-то пошло не так в методе collectUserSettings");
            throw new RuntimeException("Что-то пошло не так в методе collectUserSettings");
        }
        int fieldSize = sliderFieldSize.getValue();
        int winLength = sliderWinLength.getValue();
        mainWindow.getUserSettingsAndStartGame (gameMode, fieldSize, fieldSize, winLength);
        setVisible(false);
    }

}

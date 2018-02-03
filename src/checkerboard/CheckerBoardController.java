/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author daviddean
 */
public class CheckerBoardController implements Initializable {
    
    private double boardHeight;
    private double boardWidth;
    private int numCols = 8;
    private int numRows = 8;
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    private Scene scene;
    
    @FXML private AnchorPane anchorPane;
    @FXML private Menu gridMenu;
    @FXML private Menu colorsMenu;
    @FXML private MenuBar menuBar;
    @FXML private MenuItem defaultColors;
    @FXML private MenuItem blueColors;
    @FXML private MenuItem threeByThree;
    @FXML private MenuItem eightByEight;
    @FXML private MenuItem tenByten;
    @FXML private MenuItem sixteenBySixteen;
    @FXML private VBox vBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //leave blank
    }    

    @FXML private void changeGridLayout(ActionEvent event) {
        MenuItem menuItem = (MenuItem)(event.getSource());
        
        switch(menuItem.getId()) {
            case "threeByThree":
                numRows = numCols = 3;
                break;
            case "eightByEight":
                numRows = numCols = 8;
                break;
            case "tenByTen":
                numRows = numCols = 10;
                break;
            case "sixteenBySixteen":
                numRows = numCols = 16;
                break;
            default:
                numRows = numCols = 8;
                break;
        }
        
        refresh();
    }
    
    @FXML private void changeColorScheme(ActionEvent event) {
        MenuItem menuItem = (MenuItem)(event.getSource());
        
        switch(menuItem.getId()) {
            case "defaultColors":
                lightColor = Color.RED;
                darkColor = Color.BLACK;
                break;
            case "blueColors":
                lightColor = Color.SKYBLUE;
                darkColor = Color.DARKBLUE;
                break;
            default:
                lightColor = Color.RED;
                darkColor = Color.BLACK;
                break;
        }
        
        refresh();
    }
    
    public void start(Scene scene) {
        this.scene = scene;
        
        ChangeListener<Number> sizeChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh(); 
        };
        
        scene.widthProperty().addListener(sizeChangeListener);
        scene.heightProperty().addListener(sizeChangeListener);
        
        refresh();
    }
    
    public void refresh() {   
        //first, the old checker board needs to be cleared
        anchorPane.getChildren().clear();
        
        boardWidth = vBox.getWidth();
        boardHeight = vBox.getHeight() - menuBar.getHeight();
        
        //Build new checkerboard
        CheckerBoard cb = new CheckerBoard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
        AnchorPane cBoard = cb.build();
        
        anchorPane.getChildren().addAll(cBoard); 
    }  
}


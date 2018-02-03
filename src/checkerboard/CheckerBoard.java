/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;
        
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 *
 * @author daviddean
 */

public class CheckerBoard {
    
    private double boardHeight;
    private double boardWidth;
    private double rectangleHeight;
    private double rectangleWidth;
    private int numCols;
    private int numRows;
    private AnchorPane cBoard = null;
    private Color lightColor;
    private Color darkColor;
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane build() {
        
        cBoard = new AnchorPane();
        
        if (boardWidth < boardHeight) {
            rectangleWidth = boardWidth / numCols;
            rectangleHeight = boardWidth / numRows;
        }
        else {
           rectangleWidth = boardHeight / numCols;
           rectangleHeight = boardHeight / numRows; 
        }
                 
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                
                Rectangle rect = new Rectangle(rectangleWidth*j, rectangleWidth*i, rectangleWidth, rectangleHeight);
                
                if ((j % 2 == 0 && i % 2 != 0) || (j % 2 != 0 && i % 2 == 0)) {
                    rect.setFill(darkColor);
                }
                else {
                    rect.setFill(lightColor);
                }
            
                // Add rectangle to anchor pane
                cBoard.getChildren().add(rect);
            }
        }            
        return cBoard;
    }
    
    public AnchorPane getBoard() {
        return cBoard;
    }
    
    public int getNumRows() {
        return numRows;
    }
    
    public int getNumCols() {
        return numCols;
    }
    
    public double getWidth() {
        return boardWidth;
    }
    
    public double getHeight() {
        return boardHeight;
    }
    
    public Color getLightColor() {
        return lightColor;
    }
    
    public Color getDarkColor() {
        return darkColor;
    }
    
    public double getRectangleWidth() {
        return rectangleWidth;
    }
    
    public double getRectangleHeight() {
        return rectangleHeight;
    }
}


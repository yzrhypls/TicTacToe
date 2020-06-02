/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.objects;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yizrahya Paulus <yizrahya.paulus@gmail.com>
 */
public class GameEngine {
    
   private int gameRows,gameCols;
   private Cell.CellTypes[][] cellStatus;
   
   
    public GameEngine(int rows, int cols){
        this.cellStatus = new Cell.CellTypes[rows][cols];
    }
   
   public Cell.CellTypes[][] initializeGame(int rows, int cols){
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                
                this.cellStatus[row][col] = Cell.CellTypes.EMPTY;
                
            }
        }
        
        return this.cellStatus;
    }
   
   
   public List<Row> getGridLines(){
       
        List<Row> rows = new ArrayList<>();
        int index = 0;
        for(Cell.CellTypes[] rowDatas : this.cellStatus){
            rows.add(new Row(rowDatas, index));
            index++;
        }
        return rows;
    }
   
   
    public void setSelectedCell(String player, int row, int col){
        
        if(this.cellStatus[row][col] == Cell.CellTypes.EMPTY){
            Player playerCell = new Player();
            switch(player){
                
                case "PLAYERONE" : this.cellStatus[row][col] = playerCell.getPLAYERONE();
                                   break;
                case "PLAYERTWO" : this.cellStatus[row][col] = playerCell.getPLAYERTWO();
                                   break;
                
            }
            
        }
    }
    
    
    public Cell.CellTypes[][] getGameGrid(){
        
        return this.cellStatus;
        
    }
    
    public String getWinner(){
        
        String winnerName = "";
        
        //Lines
        Player player = new Player();
        for(int line = 0; line < this.cellStatus[0].length; line++){
            Cell.CellTypes lineState = this.cellStatus[line][0];
            boolean win = true;
            for(int col = 0; col < this.cellStatus[0].length; col++){
                if(lineState == Cell.CellTypes.EMPTY){
                    win = false;
                    break;
                }
                if(!this.cellStatus[line][col].equals(lineState)){
                    win = false;
                    break;
                }
            }
            if(win){
                 winnerName = player.getPlayerByCellType(lineState);
                
            }
        }
        
        //Cols
        for(int col = 0; col < this.cellStatus[0].length; col++){
            Cell.CellTypes colState = this.cellStatus[0][col];
            boolean win = true;
            for(int line = 0; line < this.cellStatus[0].length; line++){
                if(!this.cellStatus[line][col].equals(colState) || colState == Cell.CellTypes.EMPTY){
                    win = false;
                    break;
                }
            }
            if(win){
                  winnerName = player.getPlayerByCellType(colState);
            }
        }
        
        //Cross
        Cell.CellTypes pCrossState = this.cellStatus[0][0];
        Cell.CellTypes nCrossState = this.cellStatus[0][this.cellStatus[0].length - 1];
        boolean pWin = true;
        boolean nWin = true;
        for(int index = 0; index < this.cellStatus[0].length; index++){
            if(!this.cellStatus[index][index].equals(pCrossState)){
                pWin = false;
            }
            if(!this.cellStatus[index][this.cellStatus[0].length - 1 - index].equals(nCrossState)){
                nWin = false;
            }
        }
        if(pWin){
              winnerName = player.getPlayerByCellType(pCrossState);
        }
        else if(nWin){
              winnerName = player.getPlayerByCellType(nCrossState);
        }
        else if(winnerName == ""){
            
             winnerName = "";
        }
        
        
        if(!this.hasEmptyCell() && winnerName == ""){
            winnerName = "NOWINNER";
        }
        
        System.out.println("WINNN " + winnerName);
        return winnerName;
        
    }
    
    
    public boolean hasEmptyCell(){
        for(int line = 0; line < this.cellStatus[0].length; line++){
            for(int col = 0; col < this.cellStatus[0].length; col++){
                if(this.cellStatus[line][col] == Cell.CellTypes.EMPTY){
                    return true;
                }
            }       
        }
        return false;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.objects;

/**
 *
 * @author Yizrahya Paulus <yizrahya.paulus@gmail.com>
 */
public class Player {
    
    private final Cell.CellTypes PLAYERONE = Cell.CellTypes.X;
    private final Cell.CellTypes PLAYERTWO = Cell.CellTypes.O;
    private final Cell.CellTypes COMP = Cell.CellTypes.EMPTY;
    private final String PLAYERONENAME = "PLAYERONE";
    private final String PLAYERTWONAME = "PLAYERTWO";
    
    public enum Players{
        PLAYERONE(Cell.CellTypes.X),
        PLAYERTWO(Cell.CellTypes.O),
        COMP(Cell.CellTypes.EMPTY);
        
        private Cell.CellTypes cellType;
        private Players(Cell.CellTypes cellType){
            this.cellType = cellType;
        }
    }
    

    public Player() {
    }

    public Cell.CellTypes getPLAYERONE() {
        return PLAYERONE;
    }

    public Cell.CellTypes getPLAYERTWO() {
        return PLAYERTWO;
    }

    public Cell.CellTypes getCOMP() {
        return COMP;
    }

    public String getPLAYERONENAME() {
        return PLAYERONENAME;
    }

    public String getPLAYERTWONAME() {
        return PLAYERTWONAME;
    }
    
    public String getPlayerByCellType(Cell.CellTypes cellType){
        
        String playerName = "";
        switch(cellType.toString()){
            
            case "X" : playerName= this.PLAYERONENAME;break;
            case "O" : playerName= this.PLAYERTWONAME;break;
            
        }
        
        return playerName;
    }
    
    
    
}

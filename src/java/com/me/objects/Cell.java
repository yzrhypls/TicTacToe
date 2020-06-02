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
public class Cell {
    
    private int lineCell;
    private int colCell;
    private CellTypes cellType;
    
    public Cell() {
        
    }

    public Cell(int lineCell, int colCell, CellTypes cellType) {
        this.lineCell = lineCell;
        this.colCell = colCell;
        this.cellType = cellType;
    }
    
    public enum CellTypes{
        X, O, EMPTY
    }  

    public int getLineCell() {
        return lineCell;
    }

    public void setLineCell(int lineCell) {
        this.lineCell = lineCell;
    }

    public int getColCell() {
        return colCell;
    }

    public void setColCell(int colCell) {
        this.colCell = colCell;
    }

    public CellTypes getCellType() {
        return cellType;
    }

    public void setCellType(CellTypes cellType) {
        this.cellType = cellType;
    }
    
    
    
    
    
}

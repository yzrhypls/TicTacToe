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
public class Row {
    
    private Cell.CellTypes[] rowCellType;
    private int rowIndex;

    public Row() {
    }

    
    public Row(Cell.CellTypes[] rowCellType, int rowIndex) {
        this.rowCellType = rowCellType;
        this.rowIndex = rowIndex;
    }
    
    

    public Cell.CellTypes[] getRowCellType() {
        return rowCellType;
    }

    public void setRowCellType(Cell.CellTypes[] rowCellType) {
        this.rowCellType = rowCellType;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }
    
    
    
}

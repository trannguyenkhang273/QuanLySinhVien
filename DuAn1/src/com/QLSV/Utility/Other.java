/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.Utility;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;

/**
 *
 * @author Tho
 */
public class Other {
    public static void setTable(JTable table){
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
        table.setSelectionBackground(new Color(6,159,235));
        table.setSelectionForeground(Color.white);
        table.setRowHeight(35);
        table.setFont(new Font("SansSerif", Font.PLAIN, 16)); 
        table.setBackground(Color.white);
        table.setShowGrid(true);
        table.setGridColor(new Color(240,240,240));
        table.getTableHeader().setBackground(Color.blue);
        table.setOpaque(true);
    }
}

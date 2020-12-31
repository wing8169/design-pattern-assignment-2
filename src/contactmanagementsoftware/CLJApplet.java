/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;

import javax.swing.JApplet;

/**
 *
 * @author ritz619
 */
public class CLJApplet extends JApplet {
    
    @Override
    public void init() {
        MUI mg = MUI.getInstance();
        this.add(mg.getContentPane());
        this.setSize(mg.getContentPane().getSize());
        this.setMinimumSize(mg.getContentPane().getSize());
    }
}

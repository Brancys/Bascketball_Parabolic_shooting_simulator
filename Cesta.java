/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.awt.Image;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class Cesta {
    JLabel cesta = new JLabel();

    public Cesta() {        
        cesta.setSize(80,70); 
        cesta.setLocation(800, 200);
        paint();        
    }
    
    
    public void paint(){
        URL url = getClass().getResource("imagenes/cesta.jpg");
        ImageIcon imgcesta = new ImageIcon(url);
        Icon iconcesta = new ImageIcon(imgcesta.getImage().getScaledInstance( cesta.getWidth(), cesta.getHeight(), Image.SCALE_DEFAULT));
        cesta.setIcon(iconcesta);
        cesta.repaint();
    }
}

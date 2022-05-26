package Juego;

import java.awt.Image;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Ball {
    JLabel balon = new JLabel();
    static boolean bajando;

    public Ball(int x , int y) {
        setTamaño(); 
        paint();
        setPosicion(x, y);
    }

    public int getX() {
        return balon.getX();
    }
    public int getY() {
        return balon.getY();
    }
    
    
    public void setPosicion(int posX, int posY){
        balon.setLocation(posX, posY);
    }

    private void setTamaño() {
        balon.setSize(70,60);
    }
    
    public void paint(){
        URL url = getClass().getResource("imagenes/balon.png");
        ImageIcon imgbalon = new ImageIcon(url);
        Icon iconbalon = new ImageIcon(imgbalon.getImage().getScaledInstance( balon.getWidth(), balon.getHeight(), Image.SCALE_DEFAULT));
        balon.setIcon(iconbalon);
        balon.repaint();
    }
    
    
    
}

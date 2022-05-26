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
public class Jugador {
    JLabel jugador = new JLabel();

    public Jugador() {        
        setTamaño(); 
        jugador.setLocation(90, 450);
        paint();
        
    }
    

    private void setTamaño() {
        jugador.setSize(80,100);
    }
    
    public void paint(){
        URL url = getClass().getResource("imagenes/player.png");
        ImageIcon imgbalon = new ImageIcon(url);
        Icon iconbalon = new ImageIcon(imgbalon.getImage().getScaledInstance( jugador.getWidth(), jugador.getHeight(), Image.SCALE_DEFAULT));
        jugador.setIcon(iconbalon);
        jugador.repaint();
    }
    
    
}

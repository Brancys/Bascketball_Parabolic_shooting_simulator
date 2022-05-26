package Juego;


import java.awt.Color;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class frame {
    
    JFrame frame;
    panel comp;
    
    public frame(float v0, float gravedad, double angulo){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.RED);
        frame.getContentPane().setLayout(null);
        frame.setSize(1000, 600);
        comp = new panel(frame);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        comp.setGravedad(gravedad);
        comp.setAngulogrados(angulo);
        comp.setV0(v0);        
      
    }
    
   
        
    
}

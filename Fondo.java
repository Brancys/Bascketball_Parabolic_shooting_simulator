package General;

import java.awt.*;
import javax.swing.*;


public class Fondo extends JPanel{
   private Image imagen;
   
   public Fondo( ImageIcon imagen ){
       this.imagen = imagen.getImage();
   }
   
   public void paint( Graphics g ){
       g.drawImage( imagen, 0, 0, this);
   }
    
}
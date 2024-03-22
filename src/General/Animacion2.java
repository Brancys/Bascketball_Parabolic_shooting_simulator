/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;

/**
 *
 * @author Alumnos
 */
public final class Animacion2 extends JPanel implements Runnable {
    private PanelDibujo panelDibujo;
    private PanelBotones panelBotones;
    private double y; //posición y
    private double y0; //posición y inicial
    private final int vy0 = 0; //velocidad y inicial;
    private double x;// posición x;
    private double x0; //posicion x inicial;
    private double vx0; //velocidad x inicial ;
    private double tiempo;
    private boolean puedoDisparar = true;
    private static  Animacion2 panel = new Animacion2();
    Fondo fondoAnimacion;
    private ArrayList<Integer> ys = new ArrayList<Integer>();
    private ArrayList<Integer> xs = new ArrayList<Integer>();
    private JButton salir;
    private JButton anterior;
        private JLabel info;
    private JLabel desplegar;
    private int cuenta;

    public static Animacion2 getInstance(){
        return panel;
    }

    private Animacion2(){
	   setLayout(null);
	   salir = new JButton();
	   anterior = new JButton();
        panelDibujo = new PanelDibujo();
        panelBotones = new PanelBotones();
        iniciarVariables();
	   panelDibujo.setBounds(0,0,1020,620);
        fondoAnimacion = new Fondo( new ImageIcon(this.getClass().getResource("imagenes/fondob.jpg")) );
        fondoAnimacion.setBounds(0,0,1038,645);
        panelBotones.setBounds(50,565,520,50);
	   	   salir.setIcon(new ImageIcon(this.getClass().getResource("imagenes/Salir.png")) );
	   salir.setBounds(885,575,130,29);
	   anterior.setIcon(new ImageIcon(this.getClass().getResource("imagenes/Anterior.png")) );
	   anterior.setBounds(615,575,130,29);
	   
	   	   info = new JLabel();
	   info.setIcon(new ImageIcon(this.getClass().getResource("imagenes/Info2.png")) );
	   info.setBounds(210,160,660,300);
	   info.setOpaque(false);
	   info.setVisible(false);
	   desplegar = new JLabel("Ver Información");
	   desplegar.setFont( new Font("Century Gothic", Font.BOLD, 14 ) );
	   desplegar.setForeground( Color.white );
	   desplegar.setBounds(900,530,150,40);
	   desplegar.setOpaque(false);
	   desplegar.addMouseListener( new MouseAdapter(){
		  public void mouseClicked( MouseEvent evt ) {
			 cuenta++;
			 if( cuenta % 2 == 0 ){
				info.setVisible(false);
				puedoDisparar = true;
			 }
			 else{
				info.setVisible(true);
				puedoDisparar = false;
			 }
		  }
		  
	   });
	   add(desplegar);
	   
	   add(info);
	   	   add(salir);
	   add(anterior);
	   add(panelDibujo);
        add(panelBotones);
        add(fondoAnimacion);
    
    }
    public void iniciarVariables() {
        y = 100;
        y0 = 0;
        x = 870;
        x0 = 0;
        vx0 = 0;
        tiempo = 0;
	   xs.removeAll(xs);
	   ys.removeAll(ys);
	   panelDibujo.repaint();
    }
    
    public void disparar() {
        if (puedoDisparar) {
            new Thread(this).start();
        }
    }
    
    public void update() {
        //actualizar el tiempo y la nueva posicion.
        double incrementoTiempo = 0.05;
        tiempo += incrementoTiempo;

        //se aplica la primera fórmula
        x = x0 + vx0 * tiempo;
        //posicionamos el proyectil respecto a sus coordenadas iniciales.
        x = ( -1 * x ) + 870;

        double g = -9.81;
        //se aplica la segunda fórmula.
        y = y0 + vy0 * tiempo + 0.5 * g * tiempo * tiempo;
        //posicionamos el proyectil respecto a sus coordenadas iniciales.
        y = 100 - y;
	   
	   ys.add((int)y);
	   xs.add((int)x);

    }
    public void run() {
        puedoDisparar = false;
        //El bucle se ejecuta hasta que el projectil sobrepasa el suelo.
        while (y < 700 ) {
            try {
                update();
                Thread.sleep(20);
                panelDibujo.repaint();

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
        //Reinicia las varibles y activa el disparo        
        iniciarVariables();
        puedoDisparar = true;
       
    }
    
    class PanelDibujo extends JPanel {
        Image giru = new ImageIcon( this.getClass().getResource("imagenes/balonb.png")).getImage();
	   Image mano = new ImageIcon( this.getClass().getResource("imagenes/mano2.png")).getImage();
	   Image punto = new ImageIcon( this.getClass().getResource("imagenes/punto.png")).getImage();

        public PanelDibujo() {
            setSize(1038,640);
            setDoubleBuffered(true);            
        }


        public void paint(Graphics g) {
            setOpaque(false);
            g.drawImage(giru,(int) x, (int) y, 50, 47, null );
            g.drawImage(mano,870, 50,null ); 
		   for( int i = 0; i< xs.size(); i++){
			 if( i % 8 == 0)
				g.drawImage(punto, xs.get(i), ys.get(i), null);
		  }
        }
    }
    
    class PanelBotones extends JPanel implements ActionListener {
        JButton boton;
        JTextField textFieldVelocidad;
        JLabel labelVelocidad;

        
        
        public PanelBotones() {
            Font fuente = new Font("Century Gothic", Font.PLAIN, 14);
            setOpaque(false);
		  setLayout(null);
            boton = new JButton();
            textFieldVelocidad = new JTextField("50");
            textFieldVelocidad.setBounds(395,15,30,20);

            labelVelocidad = new JLabel("Velocidad en X ");
            labelVelocidad.setForeground(Color.WHITE);
            labelVelocidad.setFont(fuente);
		  labelVelocidad.setBounds(270,10,120,29);
            boton.setBounds(0,10,130, 29);
            boton.setIcon(new ImageIcon(this.getClass().getResource("imagenes/disparar.png")));
            add(boton);
            add(labelVelocidad);
            add(textFieldVelocidad);
            boton.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
		  if( e.getSource() == boton ){
			 iniciarVariables();
			 vx0 = Double.valueOf(textFieldVelocidad.getText());
			 disparar();
		  }
		  else{
			 if( puedoDisparar )
			  iniciarVariables();
		  }
			 

		  
        }
    }
    public JButton getSalir(){
	   return salir;
	   
    }
    public JButton getAnterior(){
	   return anterior;
	   
    }
    
    
}

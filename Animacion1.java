/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

/**
 *
 * @author Alumnos
 */
public final class Animacion1 extends JPanel implements Runnable {
    private PanelDibujo panelDibujo;
    private PanelBotones panelBotones;
    private JButton salir;
    private JButton siguiente;
    private JLabel info;
    private JLabel desplegar;
    private double y; //posición y
    private double y0; //posición y inicial
    private double vy0; //velocidad y inicial;
    private double x;// posición x;
    private double x0; //posicion x inicial;
    private double vx0; //velocidad x inicial ;
    private double velocidadInicial;
    private double tiempo;
    private boolean puedoDisparar = true;
    private int angulo;
    private ArrayList<Integer> ys = new ArrayList<Integer>();
    private ArrayList<Integer> xs = new ArrayList<Integer>();
    
    private double fx;
    private double fy = 0;
    private static  Animacion1 panel = new Animacion1();
    private Fondo fondoAnimacion;
    private int cuenta;

    private Animacion1(){
	setLayout(null);
	salir = new JButton();
	siguiente = new JButton();
        panelDibujo = new PanelDibujo();
        panelBotones = new PanelBotones();
        iniciarVariables();
	panelDibujo.setBounds(0,0,1020,620);
        fondoAnimacion = new Fondo( new ImageIcon(this.getClass().getResource("imagenes/fondob.jpg")) );
	   salir.setIcon(new ImageIcon(this.getClass().getResource("imagenes/Salir.png")) );
	   salir.setBounds(885,575,130,29);
	   siguiente.setIcon(new ImageIcon(this.getClass().getResource("imagenes/Siguiente.png")) );
	   siguiente.setBounds(615,575,130,29);
        fondoAnimacion.setBounds(0,0,1038,645);
        panelBotones.setBounds(50,565,400,50);
	   info = new JLabel();
	   info.setIcon(new ImageIcon(this.getClass().getResource("imagenes/Info1.png")) );
	   info.setBounds(210,160,660,300);
	   info.setOpaque(false);
	   info.setVisible(false);
	   desplegar = new JLabel("Ver Información");
	   desplegar.setFont( new Font("Century Gothic", Font.BOLD, 14 ) );
	   desplegar.setForeground( Color.white );
	   desplegar.setBounds(390,568,150,40);
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
	   add(siguiente);
	add(panelDibujo);
        add(panelBotones);
        add(fondoAnimacion);
    
    }
    public void iniciarVariables() {
        y = 475;
        y0 = 0;
        //se aplica la fórmula v0=v0.senθ
        vy0 = velocidadInicial * Math.sin(Math.toRadians(angulo));
        //se aplica la fórmula v0=v0.cosθ
        vx0 = velocidadInicial * Math.cos(Math.toRadians(angulo));
        x = 60;
        x0 = 0;
        tiempo = 0;

	   
    }
    
    public void disparar() {
        if (puedoDisparar) {
            new Thread(this).start();
        }
    }
    
    public synchronized void update() {
        //actualizar el tiempo y la nueva posicion.
        double incrementoTiempo = 0.05;
        tiempo += incrementoTiempo;

        //se aplica la fórmula x= v0.cosθ.t
        x = vx0 *Math.cos(Math.toRadians(angulo))* tiempo;
        //posicionamos el proyectil respecto a sus coordenadas iniciales.
        x = x + 60;

        double g = -9.81;

        //se aplica la fórmula y(t)=v0 . sen θ . t - .5 g t2.
        y =  vy0 * Math.sin(Math.toRadians(angulo)) * tiempo + 0.5 * g * tiempo * tiempo;
        //posicionamos el proyectil respecto a sus coordenadas iniciales.
        y = 475 - y;

	   ys.add((int)y);
	   xs.add((int)x);

    }
    public void run() {
        //El bucle se ejecuta hasta que el projectil sobrepasa el suelo.
	   puedoDisparar = false;
        while (y <= 475 ) {
            try {
                update();
                Thread.sleep(20);
                panelDibujo.repaint();

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
	   //fx = (x-60) / 2;
	   //fx = fx + 60;
	   fx = ( Collections.max(xs) / 2 );
	   fy = Collections.min(ys);
        //Reinicia las varibles y activa el disparo
        iniciarVariables();
	   panelDibujo.repaint();
        puedoDisparar = true;
   
       
    }
    
    class PanelDibujo extends JPanel {
        Image imagen = new ImageIcon( this.getClass().getResource("imagenes/balonb.png")).getImage();
	   Image vertice = new ImageIcon( this.getClass().getResource("imagenes/Vertice.png")).getImage();
	   Image punto = new ImageIcon( this.getClass().getResource("imagenes/punto.png")).getImage();
	   Image foco = new ImageIcon( this.getClass().getResource("imagenes/Foco.png")).getImage();
           Image mano = new ImageIcon( this.getClass().getResource("imagenes/mano.png")).getImage();


        public PanelDibujo() {
            setSize(1038,640);
            setDoubleBuffered(true);
        }


        public void paint(Graphics g) {
            setOpaque(false);
		  g.setColor(new Color(6,97,161));
		  
            g.drawImage(imagen,(int) x, (int) y, null );
            g.drawImage(mano, 35, 530, null);
		  for( int i = 0; i< xs.size(); i++){
			 if( i % 8 == 0)
				g.drawImage(punto, xs.get(i), ys.get(i), null);
		  }


		  if( fx != 0 && fy != 0 && angulo < 71 && angulo > 29 ){
			 g.drawImage(vertice, (int) fx, (int ) fy, null );
			 g.drawImage(foco, (int) fx, (int ) fy + 85, null );
		  }
 
        }
    }
    
    class PanelBotones extends JPanel implements ActionListener {

        JButton boton;
        JTextField textFieldVelocidad;
        JTextField textFieldAngulo;
        JLabel labelVelocidad;
        JLabel labelAngulo;
        
        
        public PanelBotones() {
            Font fuente = new Font("Century Gothic", Font.PLAIN, 14);
            setOpaque(false);
            setLayout(null);
            boton = new JButton();
		  
            
            labelAngulo = new JLabel("Ángulo");
            labelAngulo.setFont(fuente);
            labelAngulo.setForeground(Color.WHITE);

		  labelAngulo.setBounds(253,10,50,29);

            textFieldVelocidad = new JTextField("130");
            textFieldVelocidad.setBounds(218,15,30,20);

            textFieldAngulo = new JTextField("45");
		  textFieldAngulo.setBounds(308,15,30,20);

            labelVelocidad = new JLabel("Velocidad ");
            labelVelocidad.setFont(fuente);
            labelVelocidad.setForeground(Color.WHITE);

		  labelVelocidad.setBounds(135,10,78,29);

            boton.setBounds(0,10,130, 29);
            boton.setIcon(new ImageIcon(this.getClass().getResource("imagenes/disparar.png")));
            
            add(boton);
            add(labelAngulo);
            add(textFieldAngulo);
            add(labelVelocidad);
            add(textFieldVelocidad);
            boton.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
                velocidadInicial = Double.valueOf(textFieldVelocidad.getText());
                angulo = Integer.valueOf(textFieldAngulo.getText());
			 if( angulo > 90 || angulo <= 0 ){
				JOptionPane.showMessageDialog(null,"El angulo Tiene que ser mayor a 0, pero menor o igual a 90");
			 }
			 else if( velocidadInicial <= 0 ){
				JOptionPane.showMessageDialog(null,"La velocidad inicial debe ser mayor a 0");				
			 }
			 else{
				xs.removeAll(xs);
				ys.removeAll(ys);
				fx = 0;
				fy = 0;
				iniciarVariables();
				disparar();

			 }
        }
    }
    public static Animacion1 getInstance(){
        return panel;
    }
    public JButton getSalir(){
	   return salir;
	   
    }
    public JButton getSiguiente(){
	   return siguiente;
	   
    }
  
    public void limpiarTodo(){
	   iniciarVariables();
	   xs.removeAll(xs);
	   ys.removeAll(ys);
	   fx = 0;
	   fy = 0;
	   panelDibujo.repaint();
    }


    
}

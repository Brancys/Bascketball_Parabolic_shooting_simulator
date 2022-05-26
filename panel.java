package Juego;


import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
class panel implements Runnable{
    //JPanel y JFrame
    JFrame frame;
    JPanel pane;
    Thread hilo;
    //Constantes
    final int x_inicial;
    final int y_inicial;
    //Objetos
    private Ball ball = new Ball(130,400);
    private final Jugador player = new Jugador();
    private final Cesta basket = new Cesta();
    //Variables de tiro parabolico
    private static float v0;
    private static float gravedad;
    private static double angulogrados;
    private static double angulorad=angulogrados*Math.PI/180.0;
    private static double t=0;  
    public int subiendo =1;
    
    
    public panel(JFrame fram) {    
        this.frame=fram;
        hilo = new Thread(this);
        components();
        componentsFrame();
        pane.add(player.jugador);
        pane.add(ball.balon);
        pane.add(basket.cesta);
        hilo.start();
        x_inicial = this.ball.getX();
        y_inicial = this.ball.getY();
    } 
    public int y_t(int t,int y_inicial,int subiendo){
       double y = y_inicial +v0*Math.sin(angulorad)*t -0.5*subiendo*gravedad*Math.pow(t, 2);
       return (int)y;
    }
    public int x_t(int t, int x_inicial){
       double x = 130 + v0*Math.cos(angulorad)*t;
       return (int)x;
    }
    public int x_Max(){
        double n1= Math.pow(v0, 2)/gravedad;
        n1 = n1*Math.sin(2*angulorad);
        return (int)n1;
    }
    public static int y_Max(){
        double n1= Math.pow(v0, 2)/2*gravedad;
        n1 = n1*Math.pow(Math.sin(angulorad), 2);
        return (int)n1;
    }
    
    public static int t_Max(){
        double n1= Math.sin(angulorad)*v0*2/gravedad;
        return (int)n1;
    }

    private void components() {
        pane=new JPanel();
        GroupLayout grupo = new GroupLayout(pane);
        pane.setLayout(grupo);
        pane.setBackground(Color.white);
        pane.setBounds(0, 0, 1000, 600);
        
    }

    private void componentsFrame() {       
        frame.getContentPane().add(pane);
    }   

    @Override
    public void run() {
        while(hilo.isAlive()){
            if (ball.getY()>= y_Max()) {
                subiendo=-1;
            }
            ball.setPosicion(x_t((int)t, 130), y_t((int)t, 400,subiendo));                            
            t=t+0.01;
            this.frame.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(panel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.frame.setVisible(false);  
        Datos again = new Datos();
        again.setVisible(true);
    }

    public float getV0() {
        return v0;
    }

    public void setV0(float vo) {
        v0 = vo;
    }

    public float getGravedad() {
        return gravedad;
    }

    public void setGravedad(float gravedadx) {
       gravedad = gravedadx;
    }

    public double getAngulogrados() {
        return angulogrados;
    }

    public void setAngulogrados(double angulo) {
        angulogrados = angulo;
    }

    public double getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }
    
    

    
}

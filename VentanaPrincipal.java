package General;

import java.awt.event.*;

import javax.swing.*;


public final class VentanaPrincipal extends JFrame implements ActionListener {
    
    private PanelInicio panelInicio = PanelInicio.getInstance();
    private Animacion1 panelAnimacion = Animacion1.getInstance();
    private Animacion2 panelAnimacion2 = Animacion2.getInstance();

    private VentanaPrincipal(){
	   super("Simulador de Tiro Parabólico: by Andres Evertz & Brancys Barrios");
        setSize(1030,638);
	   setResizable(false);
	   
           
	   setLayout(null);
	   panelInicio.setBounds(0,0,1038,640);
	   
        panelAnimacion.setBounds(0,0,1038,640);
	   panelAnimacion2.setBounds(0,0,1038,640);
        panelAnimacion.setVisible(false);
        add(panelAnimacion);
	   add(panelAnimacion2);
	   panelAnimacion2.setVisible(false);
	   add(panelInicio);
           panelInicio.getAlumno().getBoton().addActionListener(this);
		 panelAnimacion.getSiguiente().addActionListener(this);
		 panelAnimacion.getSalir().addActionListener(this);
		 panelAnimacion2.getAnterior().addActionListener(this);
		 panelAnimacion2.getSalir().addActionListener(this);
 
    }
    public void actionPerformed( ActionEvent e ){
        if( e.getSource() == panelInicio.getAlumno().getBoton() ){
            if( panelInicio.getAlumno().boletaCorrecta() && panelInicio.getAlumno().grupoCorrecto() ){
                String nombre = panelInicio.getAlumno().getNombre();
                String grupo = panelInicio.getAlumno().getGrupo();
                String boleta = panelInicio.getAlumno().getBoleta();
                JOptionPane.showMessageDialog(this, " Has sido Registrado, ahora a lanzar"); 
			 panelInicio.getAlumno().limpiarCampos();
                panelInicio.setVisible(false);
                panelAnimacion.setVisible(true);
            }  
            else
               JOptionPane.showMessageDialog(this, "Datos Incorrectos"); 
        }
	   else if( e.getSource() == panelAnimacion.getSalir() ){
		  panelAnimacion.setVisible(false);
		  panelAnimacion.limpiarTodo();
		  panelAnimacion2.iniciarVariables();
		  panelInicio.setVisible(true);		  
	   }
	   else if( e.getSource() == panelAnimacion.getSiguiente() ){
		  panelAnimacion.setVisible(false);  
		  panelAnimacion2.setVisible(true);
	   }
	   
	   else if( e.getSource() == panelAnimacion2.getAnterior() ){
		  panelAnimacion2.setVisible(false);
		  panelAnimacion.setVisible(true);
	  
	   }
	   else if( e.getSource() == panelAnimacion2.getSalir() ){
		  panelAnimacion2.iniciarVariables();
		  panelAnimacion.limpiarTodo();
		  panelAnimacion2.setVisible(false);
		  panelInicio.setVisible(true);
		  
	   } 
    }
    public static void main( String args[] ){
        VentanaPrincipal aplicacion = new VentanaPrincipal();
        aplicacion.setVisible(true);
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}

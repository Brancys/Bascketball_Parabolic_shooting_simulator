package General;
import java.awt.event.*;

import javax.swing.*;


public final class RegistroAlumno extends JPanel implements KeyListener {
	private JTextField campoNombre;
    private JTextField campoGrupo;
    private JTextField campoBoleta;
	private JLabel etiquetas;
	private JLabel borde;

    public JButton registrarse;
    
    private static RegistroAlumno panelAlumno = new RegistroAlumno(); // creamos un objeto de nuestra misma clase

    private RegistroAlumno(){ 
		setLayout(null);
		campoNombre = new JTextField();
		campoGrupo = new JTextField();
		campoBoleta = new JTextField();
		etiquetas = new JLabel();
		borde = new JLabel();
		registrarse = new JButton();
		inicializaComponentes();
    }
    public void limpiarCampos(){
	   campoNombre.setText("");
	   campoGrupo.setText("");
	   campoBoleta.setText("");
    }
	
	private void inicializaComponentes(){
		etiquetas.setIcon( new ImageIcon(this.getClass().getResource("imagenes/etiquetas.png"))); // setIcon recibe un ImageIcon no Image
		registrarse.setIcon( new ImageIcon(this.getClass().getResource("imagenes/Registrarse.png")));
		borde.setIcon( new ImageIcon(this.getClass().getResource("imagenes/borde1.png")));
		registrarse.setBounds(169,160,130,29);
		etiquetas.setBounds(0,20,120,150);
		borde.setBounds(10,10,314,194);
		campoNombre.setBounds (105,33,195,22);
		campoNombre.addKeyListener(this);
		campoBoleta.setBounds (105,78,195,22);
		campoBoleta.addKeyListener(this);
		campoGrupo.setBounds (105,123,195,22);
		campoGrupo.addKeyListener(this);
		add(etiquetas);
		add(registrarse);
		add(campoNombre);
		add(campoGrupo);
		add(campoBoleta);
		add(borde);

	}
    public void borrarDatos(){
	   campoNombre.setText("");
	   campoGrupo.setText("");
	   campoBoleta.setText("");
    }
    public static RegistroAlumno getInstance(){
	   return panelAlumno;
    }
        
    public JButton getBoton(){
	   return registrarse;
	   
    }
    public String getNombre(){
	   return campoNombre.getText();
    }
    public String getGrupo(){
	   return campoGrupo.getText();
    }
    public String getBoleta(){
	   return campoBoleta.getText();
    }
    public boolean boletaCorrecta(){
		  return true;
   
    }
    public boolean grupoCorrecto(){
		  return true;
    }
   
    
    public void keyTyped(KeyEvent e) {
	   if( e.getSource() == campoNombre ){
		  if (campoNombre.getText().length() == 28)
		   e.consume();  
	   }
	   else if( e.getSource() == campoGrupo ){
		   if( campoGrupo.getText().length() == 4 )
			 e.consume();
	   }
	   else{
		if( campoBoleta.getText().length() == 10 )
			 e.consume();  
	   }

        }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    }



package General;
import java.io.Serializable;
public class Student implements Serializable{
    
	private String name;
	private String group;
	private String ID;
	
	public Student(){
		this( "", "", "" );
	}
	
	public Student( String name, String group, String mk ){
		setName( name );
		setGroup( group );
		setID( mk );
	}
	public void setGroup( String group2 ){
	    group = group2;
	}
	public String getGroup(){
	    return group;
	}
	

	public void setName( String nm){
		name = nm;
	}
	
	public String getName(){
		return name;
	}
	
	public void setID( String mk ){
		ID  = mk;
	}
	
	public String getID(){
		return ID;
	}

}

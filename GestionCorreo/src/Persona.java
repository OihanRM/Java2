import java.util.regex.Matcher;

import javax.swing.JOptionPane;

public class Persona 
{
	//DATOS
	private String nombre, apellido, correo, web;

	//CONSTRUCTOR/ES
	public Persona()
	{
		nombre="";
		apellido="";
		correo="";
		web="";
	}

	public  Persona(String nombre, String apellido, String correo, String web)
	{
		this.nombre=nombre;
		this.apellido=apellido;
		this.correo=correo;
		this.web=web;
	}
	
	//MÉTODOS
		//SET-GET

	//nombre	
	public String getNombre()
	{
		return this.nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
	//apellido
	public String getApellido()
	{
		return this.apellido;
	}
	public void setApellido(String apellido)
	{
		this.apellido=apellido;
	}

	//correo
	public String getCorreo()
	{
		return this.correo;
	}
	public void setCorreo(String correo)
	{
		this.correo=correo;
	}

	//web
	public String getWeb()
	{
		return this.web;
	}
	public void setWeb(String web)
	{
		this.web=web;
	}

	//AUX FUNCTION
	public boolean checkCorreo()
	{
		if(correo.indexOf('@')!=correo.lastIndexOf('@'))
		{
			System.out.println("DEBUG----------------->falla en @@");
			return false;
		}
		if(correo.startsWith("@"))
		{
			System.out.println("DEBUG----------------->falla en @----");
			return false;
		}
		if(correo.indexOf('@')<2)
		{
			System.out.println("DEBUG----------------->falla en corto@");
			return false;
		}
		if(correo.lastIndexOf('.')-correo.indexOf('@')<2)
		{
			System.out.println("DEBUG----------------->falla en @....@");
			return false;
		}
		if(correo.length()-correo.lastIndexOf('@')<=2)
		{
			System.out.println("DEBUG----------------->falla en .----");
			return false;
		}
		return true;
	}
	// STATIC AUX FUNCTION
	public static boolean checkCorreo(String correo)
	{
		if(correo.matches("[\\w]+[a-zA-Z0-9_]+[a-zA-Z0-9_.]*@[a-zA-Z0-9_]{2,}[.][a-zA-Z0-9_]{2,}"))
		{
			return true;
		}
		return false;
	}

}

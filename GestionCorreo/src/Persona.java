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
}

public class Empleado extends Persona
{
    //DATOS
    //extiende la clase Persona
    private int edad;
    private String direccion, telefono;
    //Constructor
    public Empleado()
    {
        super();
        edad=0;
        direccion="";
        telefono="";

    }
    public Empleado(String nombre, String apellido, String correo, String web, int edad, String direccion, String telefono)
    {
        super(nombre, apellido, correo, web);
        this.edad=edad;
        this.direccion=direccion;
        this.telefono=telefono;

    }
    public Empleado(Persona p, int edad, String direccion, String telefono)
    {
        super(p.getNombre(), p.getApellido(), p.getCorreo(), p.getWeb());
        this.edad=edad;
        this.direccion=direccion;
        this.telefono=telefono;
    }

    //METODS
//edad
    public int getEdad()
    {
        return this.edad;
    }
    public void setEdad(int edad)
    {
        this.edad=edad;
    }
//direccion
    public String getDireccion()
    {
        return this.direccion;
    }
    public void setDireccion(String direccion)
    {
        this.direccion=direccion;
    }
//Telefono
    public String getTelefono()
    {
        return this.telefono;
    }
    public void setTelefono(String telefono)
    {
        this.telefono=telefono;
    }

}

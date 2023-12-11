
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JTextField txtWeb;
	private JCheckBox chckbxEmpleado;
	private JButton btnAdd;
	private JPanel pnlEmpl;
	private JTextField txtEdad;
	private JTextField txtTlfn;
	private JTextField txtDireccion;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JList<String> lstNombre;
	private JList<String> lstCorreo;
	private JList<String> lstWeb;
	private JButton btnEnviar;
    private JButton btnGuardar;
	private JButton btnCargar;
	//private ArrayList<JTextField> txtList = new ArrayList<>();
    private int y=0;
	//Gestion Jlist
	private DefaultListModel<String> modeloNombres;
	private DefaultListModel<String> modeloCorreo;
	private DefaultListModel<String> modeloWeb;
	private ArrayList<Persona> arrayDatos;
	private Receptor receptor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//CONSTRUCTOR
	public Ventana() {
		setResizable(false);
		setTitle("Gestion Correo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 666);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(64, 44, 118, 57);
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(64, 86, 59, 42);
		contentPane.add(lblApellido);

		JLabel lblCorreo = new JLabel("correo");
		lblCorreo.setBounds(64, 151, 46, 14);
		contentPane.add(lblCorreo);

		JLabel lblWeb = new JLabel("Web");
		lblWeb.setBounds(64, 200, 46, 14);
		contentPane.add(lblWeb);

		txtNombre = new JTextField();
		txtNombre.setBounds(145, 62, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(145, 97, 86, 20);
		contentPane.add(txtApellido);

		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(145, 148, 170, 20);
		contentPane.add(txtCorreo);

		txtWeb = new JTextField();
		txtWeb.setColumns(10);
		txtWeb.setBounds(145, 197, 170, 20);
		contentPane.add(txtWeb);

		chckbxEmpleado = new JCheckBox("Empleado");
		chckbxEmpleado.setBounds(503, 61, 97, 23);
		contentPane.add(chckbxEmpleado);
        // try
        // {
        // this.setFocusTraversalPolicy(new Component[]{txtNombre, txtApellido, txtCorreo, txtWeb, btnAdd, btnEnviar});
        // } catch (Exception e)
        // {
        //     System.out.println("---------NOWORK");
        // }

		btnAdd = new JButton("Añadir");
		btnAdd.setBounds(334, 196, 89, 23);
		contentPane.add(btnAdd);

		pnlEmpl = new JPanel();
		pnlEmpl.setBounds(492, 86, 249, 131);
		contentPane.add(pnlEmpl);
		pnlEmpl.setLayout(null);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(10, 11, 46, 14);
		pnlEmpl.add(lblEdad);

		JLabel lblTlf = new JLabel("Telefono");
		lblTlf.setBounds(10, 46, 46, 14);
		pnlEmpl.add(lblTlf);

		JLabel lblNewLabel_5 = new JLabel("Direccion:");
		lblNewLabel_5.setBounds(10, 80, 68, 14);
		pnlEmpl.add(lblNewLabel_5);


		txtEdad = new JTextField();
		txtEdad.setBounds(129, 8, 86, 20);
		pnlEmpl.add(txtEdad);
		txtEdad.setColumns(10);

		txtTlfn = new JTextField();
		txtTlfn.setBounds(129, 43, 86, 20);
		pnlEmpl.add(txtTlfn);
		txtTlfn.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(129, 77, 86, 20);
		pnlEmpl.add(txtDireccion);
		txtDireccion.setColumns(10);

		lblNewLabel_6 = new JLabel("Nombre:");
		lblNewLabel_6.setBounds(30, 259, 109, 14);
		contentPane.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Direcciones de correo");
		lblNewLabel_7.setBounds(226, 259, 162, 14);
		contentPane.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("Direcciones Web:");
		lblNewLabel_8.setBounds(432, 259, 162, 14);
		contentPane.add(lblNewLabel_8);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 284, 162, 290);
		contentPane.add(scrollPane);
		

		lstNombre = new JList<String>();
		scrollPane.setViewportView(lstNombre);
		modeloNombres=new DefaultListModel<String>();
		lstNombre.setModel(modeloNombres);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(226, 284, 162, 290);
		contentPane.add(scrollPane_1);

		lstCorreo = new JList<String>();
		scrollPane_1.setViewportView(lstCorreo);
		modeloCorreo=new DefaultListModel<String>();
		lstCorreo.setModel(modeloCorreo);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(432, 284, 162, 290);
		contentPane.add(scrollPane_2);

		lstWeb = new JList<String>();
		scrollPane_2.setViewportView(lstWeb);
		modeloWeb=new DefaultListModel<String>();		
		lstWeb.setModel(modeloWeb);
		
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(662, 392, 89, 23);
		contentPane.add(btnEnviar);
		pnlEmpl.setVisible(false);

        btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(662, 342, 129, 23);
		contentPane.add(btnGuardar);

		btnCargar = new JButton("Cargar");
		btnCargar.setBounds(662, 362, 129, 23);
		contentPane.add(btnCargar);


		
		arrayDatos=new ArrayList<Persona>();
		
		regEvents();
        //FIN CONST


	}
		//REGEVENTS
	
	public void regEvents() {
		btnEnviar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				receptor = new Receptor(Ventana.this);
				receptor.setVisible(true);
				Ventana.this.setVisible(false);
			}
			
		});

		ListSelectionListener listener=new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				//Ha cambiado el elemento seleccionado
				JList lista=(JList)e.getSource();
				int pos= lista.getSelectedIndex();
				lstCorreo.setSelectedIndex(pos);
				lstNombre.setSelectedIndex(pos);
				lstWeb.setSelectedIndex(pos);
			}
			
		};
		lstNombre.addListSelectionListener(listener);
		lstCorreo.addListSelectionListener(listener);
		lstWeb.addListSelectionListener(listener);

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
            }
        });

		btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                BaseDatos insert = new BaseDatos();
				insert.connectDatabase();
				for (Persona persona : arrayDatos) 
				{
					insert.insertSQL(persona);
				}
				insert.disconectDatabase();
            }
        });

		chckbxEmpleado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(chckbxEmpleado.isSelected()) {
					pnlEmpl.setVisible(true);
				}else {
					pnlEmpl.setVisible(false);
				}
			}
		});

		btnAdd.addActionListener(new ActionListener() {
			Persona per;
			Empleado em;
			@Override
			public void actionPerformed(ActionEvent e) {
                if(txtNombre.getText().trim().equals(""))
                {
                    JOptionPane.showMessageDialog(btnAdd, "El campo nombre es obligatorio");
                    txtNombre.requestFocus();
                    return;
                }
                if(txtCorreo.getText().trim().equals(""))
                {
                    txtCorreo.setText("Null");
                    System.out.println("---------------CADENA VACIACHECK1");
                }
                if(txtWeb.getText().trim().equals(""))
                {
                    txtWeb.setText("Null");
                    System.out.println("---------------CADENA VACIACHECK2");
                }
				per = new Persona(txtNombre.getText(),txtApellido.getText(),txtCorreo.getText(),txtWeb.getText());
				//if (!per.checkCorreo())
				if(!Persona.checkCorreo(per.getCorreo()))
				{
					JOptionPane.showMessageDialog(null, "correo incorrecto");
					txtCorreo.requestFocus();
					txtCorreo.selectAll();
					return;    
				}
                if(!chckbxEmpleado.isSelected())
                {
                    arrayDatos.add(per);
                    System.out.println("__---------------------------------------->1");
                    System.out.println(arrayDatos);
					listarDatos();
                    y++;
                } else {
                    try
                    {
                        System.out.println("-------------------------------------->2");
                        em = new Empleado(per, Integer.parseInt(txtEdad.getText()), txtTlfn.getText(), txtDireccion.getText());
                        arrayDatos.add(em);
                        System.out.println(arrayDatos);
						listarDatos();
                        y++;
                    }catch(Exception e1)
                    {
                        System.out.println("DEBUG; SHOW ME INDEX = "+y);
                        System.err.println("Hay algun tipo de dato incorrecto");
                        JOptionPane.showMessageDialog(null, "Error en los datos", "ERROR",1 );
                        modeloNombres.remove(y);
                        modeloCorreo.remove(y);
                        modeloWeb.remove(y);
                    }
                }
                vaciarBoxes();
			}
		});
	}
    /// FUNCIONES AUXILIARES
    public void vaciarBoxes()
    {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtEdad.setText("");
        txtNombre.setText("");
        txtTlfn.setText("");
        txtWeb.setText("");
        txtNombre.requestFocus();
    }
	public void listarDatos()
	{
		modeloNombres.addElement(txtNombre.getText());
        modeloCorreo.addElement(txtCorreo.getText());
        modeloWeb.addElement(txtWeb.getText());
		txtNombre.requestFocus();
	}
	/// GETTER SETTER DEL ARRAYLIST
	public ArrayList<Persona> getPersona()
	{
		return arrayDatos;
	}
	
}
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Receptor extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPara;
    private JList<String> lstRecibidos;
	private JTextField txtPara;
	private JTextField txtCC;
	private JTextField txtAsunto;
	private JTextArea txtMensaje;
    private JButton btnFlecha;
    private JButton btnVolver;
    private Ventana ventana;
	private ArrayList<Persona> arrayDatos = new ArrayList<>();
	private DefaultListModel<String> recibidosModel;
	private JScrollPane scrollPane = new JScrollPane();

    //CONSTRUCTOR
	public Receptor(Ventana ventana) {
        this.ventana = ventana;
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPara = new JLabel("Para:");
		lblPara.setBounds(29, 31, 46, 14);
		contentPane.add(lblPara);
		
		JLabel lblCC = new JLabel("CC:");
		lblCC.setBounds(29, 56, 46, 14);
		contentPane.add(lblCC);
		
		JLabel lblAsunto = new JLabel("Asunto:");
		lblAsunto.setBounds(29, 81, 46, 14);
		contentPane.add(lblAsunto);
		
		JLabel lblMensaje = new JLabel("Mensaje:");
		lblMensaje.setBounds(29, 106, 46, 14);
		contentPane.add(lblMensaje);
		
		txtPara = new JTextField();
		txtPara.setBounds(73, 28, 164, 20);
		contentPane.add(txtPara);
		txtPara.setColumns(10);
		
		txtCC = new JTextField();
		txtCC.setBounds(73, 53, 164, 20);
		contentPane.add(txtCC);
		txtCC.setColumns(10);
		
		txtAsunto = new JTextField();
		txtAsunto.setBounds(73, 81, 164, 20);
		contentPane.add(txtAsunto);
		txtAsunto.setColumns(10);
		
		txtMensaje = new JTextArea();
		txtMensaje.setBounds(85, 106, 151, 144);
		contentPane.add(txtMensaje);
        txtMensaje.setBorder(txtAsunto.getBorder());

  
		scrollPane.setBounds(250, 106, 151, 144);
		contentPane.add(scrollPane);

        lstRecibidos = new JList<String>();
        scrollPane.setViewportView(lstRecibidos);
		recibidosModel = new DefaultListModel<String>();
		lstRecibidos.setModel(recibidosModel);

        btnFlecha = new JButton(">>");
		btnFlecha.setBounds(250, 50, 89, 23);
		contentPane.add(btnFlecha);

        btnVolver = new JButton("Volver");
		btnVolver.setBounds(250, 30, 89, 23);
		contentPane.add(btnVolver);
        regEvents();
	}
    //REGEVENTS

    public void regEvents()
    {
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
				{

					txtPara.setText(txtPara.getText()+";"+arrayDatos.get(lstRecibidos.getSelectedIndex()).getCorreo());

				}
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ventana.setVisible(true);
			}
		});
        btnVolver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.setVisible(true);
                Receptor.this.dispose();
            }
            
        });

		btnFlecha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//OBTENER LOS DATOS DEL ARRAYLIST
				arrayDatos=ventana.getPersona();
				System.out.println(arrayDatos);
				recibidosModel.clear();
				for (Persona persona : arrayDatos) 
				{					
					System.out.println("<"+persona.getCorreo()+">"+"RESULTADO GETTER");
					recibidosModel.addElement("<"+persona.getCorreo()+">");
					System.out.println(persona.getApellido()+" "+persona.getCorreo());
				}
			}
			
		});
    }

}
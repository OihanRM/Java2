import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JList lstRecibidos;
	private JTextField txtPara;
	private JTextField txtCC;
	private JTextField txtAsunto;
	private JTextArea txtMensaje;
    private JButton btnFlecha;
    private JButton btnVolver;
    private Ventana ventana;

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

        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(250, 106, 151, 144);
		contentPane.add(scrollPane);

        lstRecibidos = new JList<String>();
        scrollPane.setViewportView(lstRecibidos);
        lstRecibidos.setVisible(true);
        contentPane.add(lstRecibidos);

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
        btnVolver.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.setVisible(true);
                Receptor.this.dispose();
            }
            
        });
    }
}
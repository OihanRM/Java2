package xagu;
import java.awt.EventQueue;
import java.awt.FileDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JLabel;


public class xagu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pHeader;
	private JButton btnExit;
	private JButton btnStart;
	private JButton btnMapa;
	private JPanel pLab;
	private JLabel[][] gridLab = new JLabel[10][10];
	private Font f=new Font("Agency FB", Font.BOLD, 18);
	private FileDialog dlgMapa =  new FileDialog(xagu.this,"Cargar Mapa", FileDialog.LOAD);
	private File mapa;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					xagu frame = new xagu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//CONSTRUCTOR
	public xagu() {

		// JFRAME ---> VENTANA
		setTitle("XAGU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// HEADER
		pHeader = new JPanel();
		contentPane.add(pHeader, BorderLayout.NORTH);
		pHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnMapa = new JButton("Cargar Mapa");
		pHeader.add(btnMapa);
		btnMapa.setFont(f);

		btnStart = new JButton("Start");
		btnStart.setFont(f);
		pHeader.add(btnStart);

		btnExit = new JButton("Exit");
		pHeader.add(btnExit);
		btnExit.setFont(f);

		// GRID LABELS
		pLab = new JPanel();
		pLab.setBorder(null);
		contentPane.add(pLab, BorderLayout.CENTER);
		pLab.setLayout(new GridLayout(10, 10, 0, 0));
		pLab.setBorder(BorderFactory.createLineBorder(Color.black));	
		rellenarGrid();	

		// 


		regEvents();
	}
	//REGEVENTS
	private void regEvents()
	{
		btnMapa.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				dlgMapa.setDirectory(".//map");
				dlgMapa.setVisible(true);
				//obtener el fichero elegido. controlar cierre X
				darValores();


			}
		});

		btnExit.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {


			}
		});

		btnStart.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {


			}
		});
	}

	//FUNCTIONS
	public void rellenarGrid()
	{
		for (int i=0; i<gridLab.length; i++)
		{
			for(int j=0; j<gridLab.length; j++)
			{
				gridLab[i][j]=new JLabel();
				pLab.add(gridLab[i][j]);
				//gridLab[i][j].setText("*");
				gridLab[i][j].setHorizontalAlignment(JLabel.CENTER);
				gridLab[i][j].setFont(f);			
			}
		}
	}
	public void darValores()
	{
		if(dlgMapa.getFile()!=null)
		{
			try 
			{
				Scanner scan = new Scanner(new File(dlgMapa.getDirectory()+dlgMapa.getFile()));
				String linea;
				int fila=0;
				while(scan.hasNext())
				{
					linea=scan.next();
					for (int i = 0; i < 10; i++) 
					{
						//gridLab[fila][i].setText(null);
						//gridLab[fila][i].setIcon(null);
						if(linea.charAt(i)=='1')
						{
							gridLab[fila][i].setIcon(new ImageIcon("img/muro.jpg"));

						}
						if(linea.charAt(i)=='2')
						{	
							Image img=new ImageIcon("img/xagu.jpg").getImage();
							img=img.getScaledInstance(gridLab[0][0].getHeight(),gridLab[0][0].getWidth(), 0);
							gridLab[fila][i].setIcon(new ImageIcon(img));
						}
					}
					fila++;

				}
			} catch (FileNotFoundException e1) {

			}
		}

	}
}




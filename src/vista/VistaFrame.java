package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.CargarListener;
import control.EmpezarJuegoListener;
import control.SalirListener;

public class VistaFrame extends JFrame {
	private static final long serialVersionUID = 2455968239710758371L;

	private static VistaFrame instance;
	
	private JButton botonInit;
	private JButton botonCargar;
	private JButton botonSalir;
	private JPanel panel;
	
	private JPanel vista;
	private JPanel controls;
	
	public static VistaFrame getInstance(){
		if (instance == null)
			instance = new VistaFrame();
		return instance;
	}
	
	private VistaFrame(){
		super("Pooglin");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		botonInit = new JButton("Iniciar");
		botonCargar = new JButton("Cargar juego guardado");	
		botonSalir = new JButton("Guardar y salir");
		
		panel = new JPanel();				
		
		panel.add(botonInit, BorderLayout.NORTH);
		panel.add(botonCargar, BorderLayout.NORTH);
		panel.add(botonSalir, BorderLayout.NORTH);
		
		botonInit.setSize(50,20);
		botonCargar.setSize(50,20);
		botonSalir.setSize(50,20);

		setLayout(new BorderLayout());
		
		add(panel, BorderLayout.NORTH);
				
		cargaControl();	
		
		pack();
		
		setAlwaysOnTop(true);
		
		setVisible(true);
		
		setResizable(false);
	}
	
	private void cargaControl() {
		botonInit.addMouseListener(new EmpezarJuegoListener(botonInit));
		botonCargar.addMouseListener(new CargarListener(botonCargar));
		botonSalir.addMouseListener(new SalirListener(botonSalir));
	}
	
	public void setVistaPanel(JPanel vista, JPanel controls){
		if (this.vista != null)
			remove(this.vista);
		this.vista = vista;
		add(vista, BorderLayout.CENTER);
		
		if (this.controls != null)
			remove(this.controls);
		this.controls = controls;
		add(controls, BorderLayout.SOUTH);

		pack();
		repaint();
	}
											 				
}

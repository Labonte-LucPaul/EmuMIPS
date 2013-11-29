package ca.qc.lpl.emumips.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainWindow {

	private JFrame frame;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainWindow window = new MainWindow();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	//private static MainWindow window = new MainWindow();
	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		try {
			//window.frame.setVisible(true);
			frame.setVisible(true);
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

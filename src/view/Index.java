package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Index extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @param contentPane 
	 */
	public Index() {
		setBounds(100, 100, 746, 412);
		setLocationRelativeTo(null);
		setTitle("Oficina Mecânica");
//		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		
		JMenu menuCliente = new JMenu("Cliente");
		menuCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCliente registerClient = new CadastroCliente ();
				setContentPane(registerClient);
				revalidate();
			}
		});
		menuBar.add(menuCliente);
		
		JMenu menuProfissionais = new JMenu("Profissionais");
		menuBar.add(menuProfissionais);
		
		JMenu menuOrcamento = new JMenu("Orçamento");
		menuBar.add(menuOrcamento);
		
		JMenu menuRelatorios = new JMenu("Relatórios");
		menuBar.add(menuRelatorios);
		
		JMenu menuSobre = new JMenu("Sobre");
		menuBar.add(menuSobre);
		
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
}

package view;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Index extends JFrame {

	private JPanel contentPane;
	private JPanel CadastroCliente;
	private JMenuBar menuBar;
	private JMenu menuProfissionais;
	private JMenu menuOrcamento;
	private JMenu menuRelatorios;
	private JMenu menuSobre;

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

	public Index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		setBounds(100, 100, 746, 412);
		setBounds(100, 100, 746, 480);
		setLocationRelativeTo(null);
		setTitle("Oficina Mecânica");
		setResizable(false);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		
		CadastroCliente cadastrarCliente = new CadastroCliente();
	
		
		JMenu menuCliente = new JMenu("Cliente");
		menuCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(cadastrarCliente);
				revalidate();
			}
		});
		menuBar.add(menuCliente);
		
		menuProfissionais = new JMenu("Profissionais");
		menuBar.add(menuProfissionais);
		
		menuOrcamento = new JMenu("Orçamento");
		menuBar.add(menuOrcamento);
		
		menuRelatorios = new JMenu("Relatórios");
		menuBar.add(menuRelatorios);
		
		menuSobre = new JMenu("Sobre");
		menuBar.add(menuSobre);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(cadastrarCliente);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
}

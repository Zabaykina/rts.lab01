package rts.lab01;

import javax.swing.JFrame;

import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class View {

	private JFrame frame;
	private Controller controller;
	private JTextPane textPane;
	private JButton btnStart;
	private JButton btnStop;
	private JTextArea textArea = new JTextArea();

	
	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		controller = new Controller();

		JLabel lblThreadsCount = new JLabel("Количество потоков:");

		textPane = new JTextPane();
		textPane.setText("3");

		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.start(Integer.valueOf(textPane.getText()), textArea);
				btnStart.setEnabled(false);
				btnStop.setEnabled(true);

			}
		});

		btnStop = new JButton("Stop");
		btnStop.setEnabled(false);
		btnStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.stop();
				btnStart.setEnabled(true);
				btnStop.setEnabled(false);

			}
		});

				
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnStart)
							.addGap(6)
							.addComponent(btnStop))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(textPane, Alignment.LEADING)
							.addComponent(lblThreadsCount, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblThreadsCount)
							.addGap(11)
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(172)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnStart)
								.addComponent(btnStop))))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}

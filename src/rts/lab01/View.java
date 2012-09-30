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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{265, 57, 0, 0};
		gridBagLayout.rowHeights = new int[]{14, 0, 0, 0, 172, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
														
																JLabel lblThreadsCount = new JLabel("Количество потоков:");
																GridBagConstraints gbc_lblThreadsCount = new GridBagConstraints();
																gbc_lblThreadsCount.anchor = GridBagConstraints.NORTHWEST;
																gbc_lblThreadsCount.insets = new Insets(10, 0, 5, 10);
																gbc_lblThreadsCount.gridwidth = 2;
																gbc_lblThreadsCount.gridx = 1;
																gbc_lblThreadsCount.gridy = 2;
																frame.getContentPane().add(lblThreadsCount, gbc_lblThreadsCount);
														textArea.setTabSize(0);
												
																
														JScrollPane scrollPane = new JScrollPane(textArea);
														textArea.setEditable(false);
														GridBagConstraints gbc_scrollPane = new GridBagConstraints();
														gbc_scrollPane.fill = GridBagConstraints.BOTH;
														gbc_scrollPane.insets = new Insets(10, 10, 10, 10);
														gbc_scrollPane.gridheight = 6;
														gbc_scrollPane.gridx = 0;
														gbc_scrollPane.gridy = 2;
														frame.getContentPane().add(scrollPane, gbc_scrollPane);
																																						
																																								btnStart = new JButton("Start");
																																								btnStart.addActionListener(new ActionListener() {

																																									@Override
																																									public void actionPerformed(ActionEvent e) {
																																										controller.start(Integer.valueOf(textPane.getText()), textArea);
																																										btnStart.setEnabled(false);
																																										btnStop.setEnabled(true);

																																									}
																																								});
																																								
																																										textPane = new JTextPane();
																																										textPane.setText("3");
																																										GridBagConstraints gbc_textPane = new GridBagConstraints();
																																										gbc_textPane.anchor = GridBagConstraints.NORTH;
																																										gbc_textPane.fill = GridBagConstraints.HORIZONTAL;
																																										gbc_textPane.insets = new Insets(0, 0, 5, 10);
																																										gbc_textPane.gridwidth = 2;
																																										gbc_textPane.gridx = 1;
																																										gbc_textPane.gridy = 3;
																																										frame.getContentPane().add(textPane, gbc_textPane);
																																								GridBagConstraints gbc_btnStart = new GridBagConstraints();
																																								gbc_btnStart.insets = new Insets(0, 0, 10, 5);
																																								gbc_btnStart.anchor = GridBagConstraints.NORTH;
																																								gbc_btnStart.fill = GridBagConstraints.HORIZONTAL;
																																								gbc_btnStart.gridx = 1;
																																								gbc_btnStart.gridy = 7;
																																								frame.getContentPane().add(btnStart, gbc_btnStart);
																																								
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
																																										GridBagConstraints gbc_btnStop = new GridBagConstraints();
																																										gbc_btnStop.insets = new Insets(0, 0, 5, 10);
																																										gbc_btnStop.anchor = GridBagConstraints.NORTHWEST;
																																										gbc_btnStop.gridx = 2;
																																										gbc_btnStop.gridy = 7;
																																										frame.getContentPane().add(btnStop, gbc_btnStop);
	}
}

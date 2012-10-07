package rts.lab01;

import javax.swing.JTextArea;

public class ThreadItem implements Runnable {

	private String name;
	private JTextArea output;

	public ThreadItem(String name, JTextArea output) {
		super();
		this.name = name;
		this.output = output;
	}

	@Override
	public void run() {
		try {
			while (true) {
				output.append(name + "\n");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

	}
	
	
}

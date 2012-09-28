package rts.lab01;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextArea;

public class Controller {

	private List<Thread> threads;
	private JTextArea textArea;
	
	public void start(int countThreads, JTextArea textArea){
		this.textArea = textArea;
		textArea.append("start" + "\n");
		threads = new LinkedList<Thread>();
	
		for (int i = 1; i <= countThreads; i++) {
			Runnable r = new ThreadItem("Thread " + i, textArea);
			
			Thread thread = new Thread(r);
			threads.add(thread);
			thread.start();
		}
	}
	
	public void stop(){
		textArea.append("stop" + "\n");
		for (Thread thread : threads) {
			thread.interrupt();
		}
	}
}

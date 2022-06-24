package p1;


import java.awt.Dimension;
import java.io.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

/**
 * Control-client that shows a frame with different buttons that imitate directions, stop and different speed.
 * when a specific button is clicked or aktivated a message is sent throw a socket to the server
 * @author Johan
 *
 */
public class Window extends JPanel implements ActionListener{
	private Socket gSocket = null;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private JButton right= new JButton("Right");
	private JButton left = new JButton("Left");
	private JButton stop= new JButton("stop");
	private JButton v1 = new JButton("1");
	private JButton v2 = new JButton("2");
	private JButton v3 = new JButton("3");
	
	
	/**
	 * The constructor create a socket and bond it to the specified host and port
	 * It also construct the frame and its apperance 
	 * @param ip the host name or ip address
	 * @param port the port number at witch the socket will communicate thru
	 */
	public Window(String ip, int port){
		try {
			gSocket = new Socket(ip, port);
			out= new PrintWriter(gSocket.getOutputStream(),true);
			in= new BufferedReader(new InputStreamReader(gSocket.getInputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.print("nåt fel här windowserver");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		JPanel extra= new JPanel();
		JPanel panel= new JPanel();
		
		setPreferredSize(new Dimension(600, 400));
		setLayout(new GridLayout(3, 3,1,1));
		
		right.setPreferredSize(new Dimension(60, 40));
		left.setPreferredSize(new Dimension(60, 40));
		stop.setPreferredSize(new Dimension(60, 40));
		v1.setPreferredSize(new Dimension(60, 40));
		v2.setPreferredSize(new Dimension(60, 40));
		v3.setPreferredSize(new Dimension(60, 40));
		
		
		add(v1);
		add(left);
		add(right);
		add(v2);
		add(stop);
		add(extra);
		add(v3);
		v1.addActionListener(this);
		v2.addActionListener(this);
		v3.addActionListener(this);
		right.addActionListener(this);
		left.addActionListener(this);
		stop.addActionListener(this);
		
	}
	public static void main(String[] args) {
		Window panel= new Window("127.0.0.1",4444);
		JOptionPane.showMessageDialog(null, panel);
		
	}
	/**
	 * action listners to listen to each button and send streamdata to the server 
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==v1){
			out.println("120");	
		}
		if(e.getSource()==v2){
			out.println("140");
		}
		if(e.getSource()==v3){
			out.println("160");
		}
		if(e.getSource()==right){
			out.println("200");
		}
		if(e.getSource()==left){
			out.println("299");
		}
		if(e.getSource()==stop){
			out.println("100");
		}
}
}

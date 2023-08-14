import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class DragoInterface implements ActionListener{
	
	JFrame mainFrame;
	
	DragoInterface(){
		
		mainFrame = new JFrame("");
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(500,500);
		mainFrame.getContentPane().setBackground(Color.BLACK);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}

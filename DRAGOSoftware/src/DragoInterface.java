import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DragoInterface implements ActionListener{
	
	ImageIcon icon;
	JFrame mainFrame;
	JPanel imgPanel,controlPanel;
	JLabel mainImage,modeLabel;
	JComboBox<String> choiceBox;
	
	
	
	DragoInterface(){
		icon = new ImageIcon("./Assets/appLogo.png");
		
		int iconWidth = 120;  // Desired width
        int iconHeight = 120; // Desired height

        Image resizedImage = icon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        
		
		//MainFrame
		mainFrame = new JFrame("DRAGO Interface");
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(500,500);
		mainFrame.setIconImage(icon.getImage());
		mainFrame.getContentPane().setBackground(Color.BLACK);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setLocationRelativeTo(null);
		
		
		
		//Frame Components	
		imgPanel = new JPanel();
		
		imgPanel.setBackground(Color.BLACK);
		imgPanel.setLayout(new FlowLayout());
		
		controlPanel = new JPanel();
		
		controlPanel.setBackground(Color.BLACK);
		controlPanel.setLayout(new FlowLayout());
		
		
		//setting Up Image And TextLabels
		mainImage = new JLabel();
		
		mainImage.setIcon(resizedIcon);
		mainImage.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
		
		modeLabel = new JLabel();
		
		modeLabel.setText("<MODE>");
		modeLabel.setBackground(Color.BLACK);
		modeLabel.setForeground(Color.ORANGE);
		modeLabel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
		modeLabel.setFont(new Font("Roboto",Font.PLAIN,65));
		
		//setting up choice box
		String[] choices = {"Battery", "Solar Power", "Hybrid"};
	    choiceBox = new JComboBox<>(choices);
	    choiceBox.setForeground(Color.ORANGE);
	    choiceBox.setSelectedIndex(0);
	    choiceBox.setBackground(Color.DARK_GRAY);
	    choiceBox.setUI(new CustomComboBoxUI());
	    choiceBox.setRenderer(new ColorfulListCellRenderer());
	    choiceBox.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
	    choiceBox.setPreferredSize(new Dimension(300, 30));
	    choiceBox.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    String selectedOption = choiceBox.getSelectedItem().toString();
                    modeLabel.setText(selectedOption);
                    
                    if(choiceBox.getSelectedItem().toString() == "Battery") {
                    	System.out.println("Battery State");
                    }
                    else if(choiceBox.getSelectedItem().toString() == "Solar Power") {
                    	System.out.println("Solar Power State");
                    }
                    else if(choiceBox.getSelectedItem().toString() == "Hybrid") {
                    	System.out.println("Hybrid State");
                    }
                    else {
                    	System.out.println("No State");
                    }
                }
	    	}    	
	    });
	    
	    
		
		//Adding components to Panels
		imgPanel.add(mainImage);
		
		controlPanel.add(choiceBox);
		controlPanel.add(modeLabel);
		
		
		//Adding Components To MainFrame
		mainFrame.add(imgPanel,BorderLayout.NORTH);
		mainFrame.add(controlPanel,BorderLayout.CENTER);
		
	
		
		//Frame Visibility
		mainFrame.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}

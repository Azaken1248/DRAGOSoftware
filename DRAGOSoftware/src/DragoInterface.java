import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DragoInterface{
	
	ImageIcon icon,modeIcon;
	JFrame mainFrame;
	JPanel imgPanel,controlPanel;
	JLabel mainImage,modeLabel,modeImage;
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
		
		modeLabel.setText("Battery");
		modeLabel.setBackground(Color.BLACK);
		modeLabel.setForeground(Color.ORANGE);
		modeLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		modeLabel.setFont(new Font("Roboto",Font.PLAIN,70));
		
		modeImage = new JLabel();
		
		modeIcon = new ImageIcon("./Assets/batteryModeLogo.png");
		
		Image resizedModeImage = modeIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    	ImageIcon resizedModeIcon = new ImageIcon(resizedModeImage);
		
    	modeImage.setBorder(BorderFactory.createEmptyBorder(20, 100, 0, 100));
    	modeImage.setIcon(resizedModeIcon);
		
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
                    	modeIcon = new ImageIcon("./Assets/batteryModeLogo.png");
                    	
                    	Image resizedModeImage = modeIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    	ImageIcon resizedModeIcon = new ImageIcon(resizedModeImage);
                    	
                    	modeImage.setBorder(BorderFactory.createEmptyBorder(20, 100, 0, 100));
                    	modeImage.setIcon(resizedModeIcon);
                    }
                    else if(choiceBox.getSelectedItem().toString() == "Solar Power") {
                    	modeIcon = new ImageIcon("./Assets/solarModeLogo.png");
                    	
                    	Image resizedModeImage = modeIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    	ImageIcon resizedModeIcon = new ImageIcon(resizedModeImage);
                    	
                    	modeImage.setBorder(BorderFactory.createEmptyBorder(0, 100, 20, 100));
                    	modeImage.setIcon(resizedModeIcon);
                    }
                    else if(choiceBox.getSelectedItem().toString() == "Hybrid") {
                    	modeIcon = new ImageIcon("./Assets/hybridModeLogo.png");
                    	
                    	Image resizedModeImage = modeIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    	ImageIcon resizedModeIcon = new ImageIcon(resizedModeImage);
                    	
                    	modeImage.setBorder(BorderFactory.createEmptyBorder(20, 100, 0, 100));
                    	modeImage.setIcon(resizedModeIcon);
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
		controlPanel.add(modeImage);
		
		
		
		//Adding Components To MainFrame
		mainFrame.add(imgPanel,BorderLayout.NORTH);
		mainFrame.add(controlPanel,BorderLayout.CENTER);
		
	
		
		//Frame Visibility
		mainFrame.setVisible(true);
		
		
	}
}

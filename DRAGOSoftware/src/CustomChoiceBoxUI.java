import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

class CustomComboBoxUI extends BasicComboBoxUI {
    
    // Override the paintCurrentValue() method to change the selected value color
    @Override
    public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
        if (comboBox.getSelectedIndex() == -1) {
            g.setColor(Color.ORANGE);
            g.drawString("Select", bounds.x + 3, bounds.y + bounds.height - 3);
        } else {
            super.paintCurrentValue(g, bounds, false);
        }
    }
    
    // Override the paintCurrentValueBackground() method to change the background color of the selected value
    @Override
    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height); // Fill the background
    }
    
    @Override
    public void configureArrowButton() {
        super.configureArrowButton();
        
        // Remove border around the arrow button on hover
        arrowButton.setBorder(null);
        
        // Show choices immediately on arrow button click
        arrowButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (comboBox.isEditable()) {
                    comboBox.getEditor().getEditorComponent().requestFocus();
                } else {
                    comboBox.requestFocus();
                }
                comboBox.setPopupVisible(true);
            }
        });
    }
    
    // Override the paintArrowButton() method to change the color of the dropdown arrow
    @Override
    protected JButton createArrowButton() {
        JButton button = super.createArrowButton();
        button.setBackground(Color.DARK_GRAY); // Set background color to dark gray
        button.setForeground(Color.ORANGE); // Set arrow color to orange
        button.setBorder(BorderFactory.createEmptyBorder(2, 4, 2, 4));
        button.setFocusable(false);
        return button;
    }
}

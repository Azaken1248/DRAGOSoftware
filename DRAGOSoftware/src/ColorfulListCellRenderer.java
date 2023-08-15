import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

@SuppressWarnings("serial")
class ColorfulListCellRenderer extends BasicComboBoxRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        if (isSelected) {
            component.setForeground(Color.DARK_GRAY); // Change the selected item text color
            component.setBackground(Color.ORANGE); // Change the selected item background color
        } else {
            component.setForeground(Color.ORANGE); // Reset the default text color
            component.setBackground(Color.DARK_GRAY); // Reset the default background color
        }
        
        return component;
    }
}
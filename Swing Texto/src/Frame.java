import java.awt.Container;
import java.awt.GraphicsEnvironment;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

	Lienzo lienzo;
	
	public Frame() {
		super("Swing Text Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		JPanel p = new JPanel();
		p.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createRaisedBevelBorder(), 
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		JCheckBox cb;
		cb = new JCheckBox("Centrado vertical");
		cb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				lienzo.setCentrado(e.getStateChange() == ItemEvent.SELECTED);
			}
		});
		p.add(cb);
		cb = new JCheckBox("Ascent");
		cb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				lienzo.setAscent(e.getStateChange() == ItemEvent.SELECTED);
			}
		});
		p.add(cb);
		cb = new JCheckBox("Descent");
		cb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				lienzo.setDescent(e.getStateChange() == ItemEvent.SELECTED);
			}
		});
		p.add(cb);
		cb = new JCheckBox("Leading");
		cb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				lienzo.setLeading(e.getStateChange() == ItemEvent.SELECTED);
			}
		});
		p.add(cb);
		JComboBox<String> fonts = new JComboBox<String>(
				GraphicsEnvironment.
					getLocalGraphicsEnvironment().
					getAvailableFontFamilyNames());
		fonts.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				lienzo.setFontName((String) e.getItem());
			}
		});
		p.add(fonts);
		c.add(p);
		c.add(lienzo = new Lienzo(500, 500));
		pack();
	}
	
}

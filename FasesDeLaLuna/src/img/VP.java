
	package img;

	import java.awt.Color;
	import java.awt.Container;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.BorderFactory;
	import javax.swing.BoxLayout;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.SwingUtilities;

	public class VP extends JFrame {

		private JLabel luna;
		private JButton ant;
		private JButton sgt;
		
		private ImageIcon [] imgFases = new ImageIcon[8];
		private String [] txtFases = {"Luna Nueva", "Luna Creciente",
				"Cuarto Creciente", "Quinto Octante", "Luna Llena",
				"Tercer Octante", "Cuarto Menguante", "Luna Menguante"
		};
		private int fase = 0;
		
		public VP() {
			super("Fases de la Luna");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			for (int i=0; i<imgFases.length; i++)
				imgFases[i] = new ImageIcon(getClass().getResource("/img/" + i + ".png"));
			Container c = getContentPane();
			c.setBackground(Color.BLACK);
			c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
			c.add(luna = new JLabel(txtFases[fase], imgFases[fase], JLabel.CENTER));
			luna.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			luna.setHorizontalTextPosition(JLabel.CENTER);
			luna.setVerticalTextPosition(JLabel.BOTTOM);
			luna.setForeground(Color.WHITE);
			luna.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			JPanel p = new JPanel();
			p.add(ant = new JButton("Anterior", new ImageIcon(getClass().getResource("/img/left-arrow.png"))));
			ant.setMnemonic('a');
			ant.setEnabled(false);
			ant.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (fase > 0) {
						fase--;
						luna.setIcon(imgFases[fase]);
						luna.setText(txtFases[fase]);
						if (fase == 0)
							ant.setEnabled(false);
						if (!sgt.isEnabled())
							sgt.setEnabled(true);
					}
				}
			}
			);
			p.add(sgt = new JButton("Siguiente", new ImageIcon(getClass().getResource("/img/right-arrow.png"))));
			sgt.setHorizontalTextPosition(JButton.LEFT);
			sgt.setMnemonic('s');
			sgt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (fase < 7) {
						fase++;
						luna.setIcon(imgFases[fase]);
						luna.setText(txtFases[fase]);
						if (fase == 7)
							sgt.setEnabled(false);
						if (!ant.isEnabled())
							ant.setEnabled(true);
					}
				}
			});
			c.add(p);
			pack();
		}
		
		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new VP().setVisible(true);
				}
			});
		}

	}



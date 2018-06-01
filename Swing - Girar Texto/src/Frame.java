import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.TransferHandler;

import com.sun.glass.events.KeyEvent;
import com.sun.prism.Graphics;

public class Frame extends JFrame {

	Lienzo lienzo;
	double angulo=1;

	public Frame() {
		super("Swing Text Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(lienzo = new Lienzo(500, 500));
		pack();

		Action izda = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lienzo.girarIzquierda(angulo);
		
			}

		};

		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0);
		getRootPane().getInputMap().put(key, "izda");
		getRootPane().getActionMap().put("izda", izda);

		Action dcha = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lienzo.girarDerecha(angulo);

			}

		};

		key = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
		getRootPane().getInputMap().put(key, "dcha");
		getRootPane().getActionMap().put("dcha", dcha);

	}

}


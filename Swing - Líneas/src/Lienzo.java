import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;

public class Lienzo extends JPanel /*implements ComponentListener*/{

	int n;
	double dx;
	double dy;

	public Lienzo(int ancho, int alto, int numLineas) {
		//addComponentListener(this);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				dx = (double)getWidth() / (double)n;
				dy = (double)getHeight() /(double) n;
			}
		});
		setPreferredSize(new Dimension(ancho, alto));
		n = numLineas + 1;
		dx = (double)ancho /(double) n;
		dy = (double)alto / (double)n;
	}

	public void setNumeroLineas(int numLineas) {
		//if(numLineas%2!=0) {
		n = numLineas + 1;
		dx = (double)getWidth() / (double)n;
		dy = (double)getHeight() /(double) n;
		repaint();
		//}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		setBackground(Color.DARK_GRAY);
		
		for(int i=1; i<n; i++) {
			int x1 = (int) (dx * (n - i));
			int x2 = (int) (dx * i);
			int y = (int) (dy * i);
			g.drawLine(0, 0, x1 , y);
			g.drawLine(getWidth() - 1, getHeight() - 1, x1, y);
			g.drawLine(getWidth() - 1, 0, x2, y);
			g.drawLine(0, getHeight() - 1, x2, y);
		}
	}

/*	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		dx = (double)getWidth() / (double)n;
		dy = (double)getHeight() /(double) n;
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}*/
}

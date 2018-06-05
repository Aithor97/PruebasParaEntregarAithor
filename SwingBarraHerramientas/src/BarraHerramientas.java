import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class BarraHerramientas extends JFrame {

public BarraHerramientas() {
super("Eclipse");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setPreferredSize(new Dimension(500, 500));

JMenuBar menuBar = new JMenuBar();
setJMenuBar(menuBar);
JMenu menu;
JMenuItem menuItem;
menu = new JMenu("File");
menu.setMnemonic(KeyEvent.VK_F);
menuBar.add(menu);

setJMenuBar(menuBar);
menuBar.setEnabled(false);

ImageIcon img = new ImageIcon(getClass().getResource("folder.png"));
ImageIcon img2 = new ImageIcon(getClass().getResource("save.png"));
ImageIcon img3 = new ImageIcon(getClass().getResource("saveas.png"));
ImageIcon img4 = new ImageIcon(getClass().getResource("saveall.png"));
ImageIcon img5 = new ImageIcon(getClass().getResource("rename.png"));
ImageIcon img6 = new ImageIcon(getClass().getResource("refresh.png"));
ImageIcon img7 = new ImageIcon(getClass().getResource("print.png"));
ImageIcon img8 = new ImageIcon(getClass().getResource("import.png"));
ImageIcon img9 = new ImageIcon(getClass().getResource("export.png"));

JToolBar toolBar = new JToolBar();

AbstractAction a1 = new AbstractAction("New") {
@Override
public void actionPerformed(ActionEvent arg0) {
JOptionPane.showMessageDialog(BarraHerramientas.this,
"Has seleccionado New", "Aviso!",
JOptionPane.INFORMATION_MESSAGE);
}
};
a1.putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.ALT_MASK| KeyEvent.VK_SHIFT));

AbstractAction a2 = new AbstractAction("Open File", img) {
@Override
public void actionPerformed(ActionEvent arg0) {
JOptionPane.showMessageDialog(BarraHerramientas.this, "Has seleccionado Open File", "Aviso!",
JOptionPane.INFORMATION_MESSAGE);
}
};

AbstractAction a3 = new AbstractAction("Open Projects from File system...") {
@Override
public void actionPerformed(ActionEvent arg0) {
JOptionPane.showMessageDialog(BarraHerramientas.this,
"Has seleccionado Open Projects From File System...", "Aviso!",
JOptionPane.INFORMATION_MESSAGE);
}
};

AbstractAction a4 = new AbstractAction("Close") {
@Override
public void actionPerformed(ActionEvent arg0) {
JOptionPane.showMessageDialog(BarraHerramientas.this, "Has seleccionado Close", "Aviso!",
JOptionPane.INFORMATION_MESSAGE);
}
};
a4.putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.ALT_MASK));

AbstractAction a5 = new AbstractAction("Close All") {
@Override
public void actionPerformed(ActionEvent arg0) {
JOptionPane.showMessageDialog(BarraHerramientas.this, "Has seleccionado Close All", "Aviso!",
JOptionPane.INFORMATION_MESSAGE);
}
};
a5.putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.ALT_MASK| KeyEvent.VK_SHIFT));

AbstractAction a6 = new AbstractAction("Save", img2) {
@Override
public void actionPerformed(ActionEvent arg0) {
JOptionPane.showMessageDialog(BarraHerramientas.this, "Has seleccionado Save", "Aviso!",
JOptionPane.INFORMATION_MESSAGE);
}
};
a6.putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.VK_CONTROL));

AbstractAction a7 = new AbstractAction("Save As", img3) {
@Override
public void actionPerformed(ActionEvent arg0) {
JOptionPane.showMessageDialog(BarraHerramientas.this, "Has seleccionado Save As", "Aviso!",
JOptionPane.INFORMATION_MESSAGE);
}
};

AbstractAction a8 = new AbstractAction("Save All", img4) {
@Override
public void actionPerformed(ActionEvent arg0) {
JOptionPane.showMessageDialog(BarraHerramientas.this, "Has seleccionado Save All", "Aviso!",
JOptionPane.INFORMATION_MESSAGE);
}
};
a8.putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.VK_CONTROL|KeyEvent.VK_SHIFT));

AbstractAction a9 = new AbstractAction("Revert") {
@Override
public void actionPerformed(ActionEvent arg0) {
JOptionPane.showMessageDialog(BarraHerramientas.this, "Has seleccionado Revert", "Aviso!",
JOptionPane.INFORMATION_MESSAGE);
}
};

a4.putValue(AbstractAction.ACCELERATOR_KEY,
KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.VK_CONTROL | KeyEvent.SHIFT_MASK));

AbstractAction a10 = new AbstractAction("Rename", img5) {
@Override
public void actionPerformed(ActionEvent arg0) {
JOptionPane.showMessageDialog(BarraHerramientas.this, "Has seleccionado Rename", "Aviso!",
JOptionPane.INFORMATION_MESSAGE);
}
};
a10.putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));

AbstractAction a11 = new AbstractAction("Refresh", img6) {
@Override
public void actionPerformed(ActionEvent arg0) {
JOptionPane.showMessageDialog(BarraHerramientas.this, "Has seleccionado Refresh", "Aviso!",
JOptionPane.INFORMATION_MESSAGE);
}
};
a11.putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));

AbstractAction a12 = new AbstractAction("Convert Line Delimiters To") {
@Override
public void actionPerformed(ActionEvent arg0) {
JOptionPane.showMessageDialog(BarraHerramientas.this, "Has seleccionado Convert Line Delimiters To",
"Aviso!", JOptionPane.INFORMATION_MESSAGE);
}
};

AbstractAction a13 = new AbstractAction("Print", img7) {
@Override
public void actionPerformed(ActionEvent arg0) {
JOptionPane.showMessageDialog(BarraHerramientas.this, "Has seleccionado Print", "Aviso!",
JOptionPane.INFORMATION_MESSAGE);
}
};
a13.putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.VK_CONTROL));

AbstractAction a14 = new AbstractAction("Import", img8) {
@Override
public void actionPerformed(ActionEvent arg0) {
JOptionPane.showMessageDialog(BarraHerramientas.this, "Has seleccionado Import", "Aviso!",
JOptionPane.INFORMATION_MESSAGE);
}
};

AbstractAction a15 = new AbstractAction("Export", img9) {
@Override
public void actionPerformed(ActionEvent arg0) {
JOptionPane.showMessageDialog(BarraHerramientas.this, "Has seleccionado Export", "Aviso",
JOptionPane.INFORMATION_MESSAGE);
}
};

AbstractAction a16 = new AbstractAction("Exit") {
@Override
public void actionPerformed(ActionEvent arg0) {
System.exit(EXIT_ON_CLOSE);
}
};

menuItem = new JMenuItem(a1);
menu.add(menuItem);
toolBar.add(a2);
menuItem = new JMenuItem(a2);
menu.add(menuItem);
menuItem = new JMenuItem(a3);
menu.add(menuItem);
menu.add(new JSeparator());
menuItem = new JMenuItem(a4);
menu.add(menuItem);
menuItem = new JMenuItem(a5);
menu.add(menuItem);
menu.add(new JSeparator());
menuItem = new JMenuItem(a6);
toolBar.add(a6);
menu.add(menuItem);
menuItem = new JMenuItem(a7);
toolBar.add(a7);
menu.add(menuItem);
menuItem = new JMenuItem(a8);
toolBar.add(a8);
menu.add(menuItem);
menuItem = new JMenuItem(a9);
menu.add(menuItem);
menu.add(new JSeparator());
menuItem = new JMenuItem(a10);
menu.add(menuItem);
menuItem = new JMenuItem(a11);
toolBar.add(a11);
menu.add(menuItem);
menuItem = new JMenuItem(a12);
menu.add(menuItem);
menu.add(new JSeparator());
menuItem = new JMenuItem(a13);
menu.add(menuItem);
menu.add(new JSeparator());
toolBar.add(a14);
menuItem = new JMenuItem(a14);
menu.add(menuItem);
toolBar.add(a15);
menuItem = new JMenuItem(a15);
menu.add(menuItem);
menu.add(new JSeparator());
menuItem = new JMenuItem(a16);
menu.add(menuItem);
add(toolBar, BorderLayout.NORTH);
toolBar.setFloatable(false);
pack();

}

public static void main(String[] args) {

SwingUtilities.invokeLater(new Runnable() {
@Override
public void run() {
new BarraHerramientas().setVisible(true);
}
});
}

}
package Interface;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
  MyPanel myPanel;
  private JPanel mainPanel;

  public MyFrame(MyPanel panel) {
    myPanel = panel;
    add(myPanel);
    setContentPane(myPanel);
    setSize(500, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}

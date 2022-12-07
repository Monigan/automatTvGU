package Interface;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
  private MyPanel myPanel;

  public MyFrame(MyPanel myPanel) {
    this.myPanel = myPanel;
    add(this.myPanel);
    setContentPane(this.myPanel);
    setSize(500, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}

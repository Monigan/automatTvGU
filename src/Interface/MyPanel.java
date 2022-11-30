package Interface;

import Controller.AutomateController;
import Controller.AutomateControllerImpl;
import Storage.TovarStorage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MyPanel extends JPanel {
  private JPanel corePanel;
  private JComboBox tovarListBox;
  private JButton buyButton;
  private JButton putButton;
  private JPanel buyPanel;
  private JPanel putPanel;
  private JRadioButton putMoneyRadioButton;

  AutomateController automateController = new AutomateControllerImpl();
  TovarStorage tovarStorage = new TovarStorage();

  public MyPanel() {
//        setModal(true);
    add(corePanel);
    putButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (automateController.hasMonet()) {
          automateController.makeAutomate("ТверьЕда", tovarStorage.getList());
          putPanel.setVisible(false);

          buyPanel.enableInputMethods(true);
          buyPanel.setVisible(true);

          onPutButton();
        } else {
          callDialog("Не вставлена монетка!");
        }
      }
    });
    buyButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int index = tovarListBox.getSelectedIndex();
        if (!automateController.hasTovar(index)) {
          callDialog("Товар закончился!");
        }
        callDialog("Товар куплен!");
      }
    });
    putMoneyRadioButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (putMoneyRadioButton.isSelected()) {
          automateController.putMoney(true);
        } else {
          automateController.putMoney(false);
        }
      }
    });
  }

  void onPutButton() {
    for (int i = 0; i < automateController.getTovarList().size(); i++) {
      tovarListBox.addItem(
          automateController.getTovarList().get(i).getName()
              + " " +
              automateController.getTovarList().get(i).getCoast());
    }
  }

  void callDialog(String result) {
    SellDialog dialog = new SellDialog(result);
    dialog.pack();
    dialog.setVisible(true);
    System.exit(0);
  }
}

package Interface;

import Controller.AutomateController;
import States.HasMoneyState;
import States.HasState;
import States.HasTovarState;
import Storage.TovarStorage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class MyPanel extends JPanel {
  private JPanel corePanel;
  private JComboBox tovarListBox;
  private JButton buyButton;
  private JButton putButton;
  private JPanel buyPanel;
  private JPanel putPanel;
  private JRadioButton putMoneyRadioButton;
  private JTextArea resultLabel;
  private JPanel resultPanel;

  AutomateController automateController = new AutomateController();
  HasState moneyState = new HasMoneyState(automateController);
  HasState tovarState = new HasTovarState(automateController);
  TovarStorage tovarStorage = new TovarStorage();

  public MyPanel() {
    add(corePanel);
    putButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (moneyState.hasState()) {
          automateController.makeAutomate("ТверьЕда", tovarStorage.getList());
          putPanel.setVisible(false);

          buyPanel.enableInputMethods(true);
          buyPanel.setVisible(true);

          onPutButton();
        }
        else{
          putPanel.setVisible(false);
          resultLabel.setText("Вы не внесли монетку");
        }
      }
    });
    buyButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int index = tovarListBox.getSelectedIndex();
        buyPanel.setVisible(false);
        if (!tovarState.hasState(index)) {
          resultLabel.setText("Товара нет");
        }
        else{
          resultLabel.setText("Вы купили товар");
        }
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
      tovarListBox.addItem(automateController.getTovarList().get(i).getName() + " " +
          automateController.getTovarList().get(i).getCoast());
    }
  }
}

package Interface;

import Controller.AutomateController;
import Controller.AutomateControllerImpl;
import Storage.TovarStorage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutomateInterface extends JFrame {
    private JPanel corePanel;
    private JTextField putMoneyField;
    private JComboBox tovarListBox;
    private JButton buyButton;
    private JButton putButton;
    private JPanel buyPanel;
    private JPanel putPanel;

    AutomateController automateController = new AutomateControllerImpl();
    TovarStorage tovarStorage = new TovarStorage();

    public AutomateInterface() {
        setContentPane(corePanel);
        //setModal(true);
        putButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!putMoneyField.getText().isEmpty()){
                    automateController.putMoney(Double.parseDouble(putMoneyField.getText()));
                    if (!automateController.hasMoney()){
                        callDialog("Вы не внесли деньги!");
                    }
                    automateController.makeAutomate("ТверьЕда", tovarStorage.getList());
                    putPanel.setVisible(false);

                    buyPanel.enableInputMethods(true);
                    buyPanel.setVisible(true);

                    onPutButton();
                    pack();
                }
            }
        });
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = tovarListBox.getSelectedIndex();
                if (!automateController.hasTovar(index)){
                    callDialog("Товар закончился!");
                }
                if(Double.parseDouble(putMoneyField.getText()) >= automateController.getTovarList().get(index).getCoast()){
                    callDialog("Товар куплен, ваша сдача составляет: " + (Double.parseDouble(putMoneyField.getText()) - automateController.getTovarList().get(index).getCoast()));
                }
                else {
                    callDialog("Вам не хватает денег!");
                }
            }
        });
    }

    void onPutButton(){
        for (int i = 0; i < automateController.getTovarList().size(); i++){
            tovarListBox.addItem(
                    automateController.getTovarList().get(i).getName()
                    + " " +
                    automateController.getTovarList().get(i).getCoast());
        }
    }

    void callDialog(String result){
        SellDialog dialog = new SellDialog(result);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

package Controller;

import Entity.AutomateEntity;
import Entity.TovarEntity;

import java.util.List;

public class AutomateControllerImpl implements AutomateController {
    AutomateEntity automate;
    double moneyValue;
    @Override
    public void makeAutomate(String name, List<TovarEntity> tovarList) {
        this.automate = new AutomateEntity(name, tovarList);
    }

    @Override
    public List<TovarEntity> getTovarList() {
        return automate.getTovarList();
    }

    @Override
    public boolean hasTovar(int index) {
        return automate.getTovarList().get(index).getValue() != 0;
    }

    @Override
    public boolean hasMoney() {
        return moneyValue != 0;
    }

    @Override
    public void putMoney(double money) {
        this.moneyValue = money;
    }
}

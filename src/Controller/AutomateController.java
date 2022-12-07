package Controller;

import Entity.AutomateEntity;
import Entity.TovarEntity;
import java.util.List;

public class AutomateController {
  AutomateEntity automate;
  boolean hasMonet = false;

  public void makeAutomate(String name, List<TovarEntity> tovarList) {
    this.automate = new AutomateEntity(name, tovarList);
  }

  public List<TovarEntity> getTovarList() {
    return automate.getTovarList();
  }

  public boolean hasTovar(int index) {
    return automate.getTovarList().get(index).getValue() != 0;
  }

  public boolean hasMonet() {
    return hasMonet;
  }

  public void putMoney(boolean hasMonet) {
    this.hasMonet = hasMonet;
  }
}

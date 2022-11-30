package Controller;

import Entity.AutomateEntity;
import Entity.TovarEntity;
import java.util.List;

public class AutomateControllerImpl implements AutomateController {
  AutomateEntity automate;
  boolean hasMonet = false;

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
  public boolean hasMonet() {
    return hasMonet;
  }

  @Override
  public void putMoney(boolean hasMonet) {
    this.hasMonet = hasMonet;
  }
}

package Controller;

import Entity.TovarEntity;
import java.util.List;

public interface AutomateController {
  void makeAutomate(String name, List<TovarEntity> tovarList);

  List<TovarEntity> getTovarList();

  boolean hasTovar(int index);

  boolean hasMonet();

  void putMoney(boolean hasMonet);
}

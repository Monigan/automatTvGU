package Entity;

import java.util.List;

public class AutomateEntity {
  String name;
  List<TovarEntity> tovarList;

  public AutomateEntity(String name, List<TovarEntity> tovarList) {
    this.name = name;
    this.tovarList = tovarList;
  }

  public String getName() {
    return name;
  }

  public List<TovarEntity> getTovarList() {
    return tovarList;
  }

  @Override
  public String toString() {
    return "AutomatEntity{" +
        "name='" + name + '\'' +
        ", tovarList=" + tovarList +
        '}';
  }
}

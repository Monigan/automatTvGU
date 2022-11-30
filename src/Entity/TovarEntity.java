package Entity;

public class TovarEntity {
  String name;
  Integer value;
  Double coast;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public TovarEntity(String name, Integer value, Double coast) {
    this.name = name;
    this.value = value;
    this.coast = coast;
  }

  public Double getCoast() {
    return coast;
  }

  public void setCoast(Double coast) {
    this.coast = coast;
  }

  @Override
  public String toString() {
    return "TovarEntity{" +
        "name='" + name + '\'' +
        ", value=" + value +
        ", coast=" + coast +
        '}';
  }
}

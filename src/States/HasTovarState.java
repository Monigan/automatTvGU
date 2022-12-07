package States;

import Controller.AutomateController;

public class HasTovarState implements HasState{
  AutomateController automateController;

  public HasTovarState(AutomateController automateController) {
    this.automateController = automateController;
  }

  @Override
  public boolean hasState() {
    return false;
  }

  @Override
  public boolean hasState(int index) {
    return automateController.hasTovar(index);
  }
}

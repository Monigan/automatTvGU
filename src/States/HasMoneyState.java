package States;

import Controller.AutomateController;

public class HasMoneyState implements HasState {
  AutomateController automateController;

  public HasMoneyState(AutomateController automateController) {
    this.automateController = automateController;
  }

  @Override
  public boolean hasState() {
    return automateController.hasMonet();
  }

  @Override
  public boolean hasState(int index) {
    return false;
  }
}

package com.nehru.designpatterns.behavioral;

public class ChainOfResponsibilityPatternDemo {

  public static void main(String[] args) {
    validateStage(2);
    validateStage(4);

  }

  private static void validateStage(int stage) {
    Handler stageOneHandler = new StageOneHandler();
    Handler stageTwoHandler = new StageTwoHandler();
    Handler stageThreeHandler = new StageThreeHandler();
    Handler successHandler = new SuccessHandler();

    stageOneHandler.setNextHandler(stageTwoHandler);
    stageTwoHandler.setNextHandler(stageThreeHandler);
    stageThreeHandler.setNextHandler(successHandler);

    stageOneHandler.handle(stage);
  }

}

abstract class Handler {

  Handler nextHandler;


  public void setNextHandler(Handler nextHandler) {
    this.nextHandler = nextHandler;
  }


  public abstract void handle(int stage);
}

class StageOneHandler extends Handler {

  @Override
  public void handle(int stage) {
    if (1 == stage) {
      System.out.println("failed at stage one");
      return;
    }
    this.nextHandler.handle(stage);
  }
}

class StageTwoHandler extends Handler {

  @Override
  public void handle(int stage) {
    if (2 == stage) {
      System.out.println("failed at stage two");
      return;
    }
    this.nextHandler.handle(stage);
  }
}

class StageThreeHandler extends Handler {

  @Override
  public void handle(int stage) {
    if (3 == stage) {
      System.out.println("failed at stage three");
      return;
    }
    this.nextHandler.handle(stage);
  }
}

class SuccessHandler extends Handler {

  @Override
  public void handle(int stage) {
    System.out.println("Process successfully completed");
  }
}



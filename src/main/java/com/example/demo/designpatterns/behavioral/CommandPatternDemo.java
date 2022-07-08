package com.example.demo.designpatterns.behavioral;

/**
 * The type Command pattern decouple objects that produce the commands from their consumers
 */
public class CommandPatternDemo {


  public static void main(String[] args) {
    Remote tvRemote = new TvRemote();
    Button onButton = new OnButton(tvRemote);

    RemoteUser.pressButton(onButton);

    Remote acRemote = new AcRemote();
    Button offButton = new OnButton(acRemote);

    RemoteUser.pressButton(offButton);

  }


}

interface Button {

  void pressButton();
}


class RemoteUser {


  static void pressButton(Button button) {
    button.pressButton();
  }
}

abstract class Remote {

  abstract void on();

  abstract void off();
}

class TvRemote extends Remote {

  @Override
  void on() {
    System.out.println("TV is switched on");
  }

  @Override
  void off() {
    System.out.println("TV is switched off");
  }
}

class AcRemote extends Remote {

  @Override
  void on() {
    System.out.println("AC is switched on");
  }

  @Override
  void off() {
    System.out.println("AC is switched off");
  }
}

class OnButton implements Button {

  Remote remote;

  public OnButton(Remote remote) {
    this.remote = remote;
  }

  @Override
  public void pressButton() {
    remote.on();
  }


}

class OffButton implements Button {

  Remote remote;

  public OffButton(Remote remote) {
    this.remote = remote;
  }


  @Override
  public void pressButton() {
    remote.off();
  }
}


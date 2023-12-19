package com.example.demo.designpatterns.behavioral;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Observable pattern - notifies all subscribers when the observable object is changing
 */

@Slf4j
public class ObservablePatternDemo {

    public static void main(String[] args) {
        NotificationHandler notificationHandler = new NotificationHandler();

        User user = new User();
        Seller seller = new Seller();
        Warehouse warehouse = new Warehouse();

        notificationHandler.registerObserver(user);
        notificationHandler.registerObserver(seller);
        notificationHandler.registerObserver(warehouse);

        notificationHandler.notifyObservers();
        log.info("Dergistering Warehouse");
        notificationHandler.deRegisterObserver(warehouse);
        notificationHandler.notifyObservers();

    }
}

interface Observer {

    void update();
}


class User implements Observer {

    @Override
    public void update() {
        System.out.println("User info updated");
    }
}

class Seller implements Observer {

    @Override
    public void update() {
        System.out.println("Seller info updated");
    }
}

class Warehouse implements Observer {

    @Override
    public void update() {
        System.out.println("Warehouse info updated");
    }
}

class NotificationHandler {

    List<Observer> observers;

    NotificationHandler() {
        observers = new ArrayList<>();
    }

    void registerObserver(Observer observer) {
        observers.add(observer);
    }
    void deRegisterObserver(Observer observer) {
        observers.remove(observer);
    }

    void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }


}

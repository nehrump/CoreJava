package com.nehru.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;


/**
 * The interface Observer.
 */
interface Observer {

    /**
     * Update.
     */
    void update();
}

/**
 * The type Observable pattern demo.
 */
public class ObservablePatternDemo {

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args) {
        NotificationHandler notificationHandler = new NotificationHandler();

        User user = new User();
        Seller seller = new Seller();
        Warehouse warehouse = new Warehouse();

        notificationHandler.registerObserver(user);
        notificationHandler.registerObserver(seller);
        notificationHandler.registerObserver(warehouse);

        notificationHandler.notifyObservers();

        notificationHandler.deRegisterObserver(warehouse);
        notificationHandler.notifyObservers();

    }
}

/**
 * The type User.
 */
class User implements Observer {

    @Override
    public void update() {
        System.out.println("User info updated");
    }
}

/**
 * The type Seller.
 */
class Seller implements Observer {

    @Override
    public void update() {
        System.out.println("Seller info updated");
    }
}

/**
 * The type Warehouse.
 */
class Warehouse implements Observer {

    @Override
    public void update() {
        System.out.println("Warehouse info updated");
    }
}

/**
 * The type Notification handler which responsible for managing the subscriptions
 */
class NotificationHandler {

    /**
     * The Observers.
     */
    List<Observer> observers;

    /**
     * Instantiates a new Notification handler.
     */
    NotificationHandler() {
        observers = new ArrayList<>();
    }

    /**
     * Register observer.
     *
     * @param observer the observer
     */
    void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * De register observer.
     *
     * @param observer the observer
     */
    void deRegisterObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notify observers.
     */
    void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }


}

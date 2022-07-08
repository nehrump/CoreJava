package com.example.demo.designpatterns.structural;

import java.util.ArrayList;
import java.util.List;


/**
 * Composite Pattern allows the Leaf and composite to be treated same
 */
public class CompositePatternDemo {

    public static void main(String[] args) {

        CurrentAccount currentAccount = new CurrentAccount();
        SavingsAccount savingsAccount = new SavingsAccount();
        CompositeAccount compositeAccount = new CompositeAccount();

        compositeAccount.addAccount(currentAccount);
        compositeAccount.addAccount(savingsAccount);
        compositeAccount.showBalance();

        System.out.println("Current account removed");

        compositeAccount.removeAccount(currentAccount);
        compositeAccount.showBalance();

    }
}

interface Account {

    int showBalance();
}


class CurrentAccount implements Account {

    int balance = 50;

    @Override
    public int showBalance() {
        System.out.println("Current Balance is " + balance);
        return balance;
    }
}

class SavingsAccount implements Account {

    int balance = 100;

    @Override
    public int showBalance() {
        System.out.println("Savings Balance is " + balance);
        return balance;
    }
}

class CompositeAccount implements Account {

    List<Account> accounts;

    @Override
    public int showBalance() {
        int balance = accounts.stream().map(Account::showBalance).reduce(Integer::sum).get();
        System.out.println("Composite Balance is " + balance);
        return balance;
    }

    public void addAccount(Account account) {
        if (accounts == null) {
            accounts = new ArrayList<>();
        }
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        if (accounts != null) {
            accounts.remove(account);
        }
    }

}



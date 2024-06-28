package org.example.account;

public class AccountDemo {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(20000);
        Account account1 = new Account(20000);

        AccaountThread accaountThread1 = new AccaountThread(account, account1);
        AccaountThread accaountThread2 = new AccaountThread(account1, account);
        accaountThread1.start();
        accaountThread2.start();

        accaountThread1.join();
        accaountThread2.join();

        System.out.println(account);
        System.out.println(account1);

    }
}

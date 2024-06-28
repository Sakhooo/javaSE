package org.example.account;

public class AccaountThread extends Thread {
  private final Account accountFrom;
  private final Account accountTo;


  public AccaountThread(Account accountFrom, Account accountTo) {
    this.accountFrom = accountFrom;
    this.accountTo = accountTo;
  }

  @Override
  public void run() {

    for (int i = 0; i < 2000; i++) {
      lockAccounts();
      try {
        if (accountFrom.takeOff(10)) {
          accountTo.add(10);
        }
      } finally {
        accountFrom.getLock().unlock();
        accountTo.getLock().unlock();
      }
    }
  }

  private void lockAccounts() {
    while (true) {
      boolean fromLockResult = accountFrom.getLock().tryLock();
      boolean toLockResult = accountTo.getLock().tryLock();
      if (fromLockResult && toLockResult) {
        break;
      }
      if (fromLockResult) {
        accountFrom.getLock().unlock();
      }
      if (toLockResult) {
        accountTo.getLock().unlock();
      }
    }
  }
}

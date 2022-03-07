package codility;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.text.*;
import java.math.*;
import java.util.regex.*;

  // Class name should be "Source",
// otherwise solution won't be accepted
  public class Source implements Runnable {
    private Account account = new Account();
    public static void main(String args[] ) throws Exception {
      /**
       * Do not modify the main method.
       * */
      Source testing = new Source();
      Thread one = new Thread(testing);
      Thread two = new Thread(testing);
      one.setName("John");
      two.setName("Juliet");
      one.start();
      two.start();
    }

    @Override
    public void run() {
      for (int x = 0; x < 5; x++) {
        makeWithdrawal(-1000);
        if (account.getBalance() < 0) {
          System.out.println("account is overdrawn!");
        }
      }
    }

    public void performTryLock() throws InterruptedException{
    	ReentrantLock lock = new ReentrantLock();
        lock.lock();
        boolean isLockAcquired = lock.tryLock(100, TimeUnit.SECONDS);
        
        if(isLockAcquired) {
            try {
                //Critical section here
            } finally {
                lock.unlock();
            }
        }
       
    }
    
    private void makeWithdrawal(int amt) {
      if (account.getBalance() >= amt) {
        try {
          Thread.sleep(100);
        } catch (InterruptedException ex) {
        }
        ReentrantLock lock = new ReentrantLock();
        boolean isLockAcquired=false;
		try {
			isLockAcquired = lock.tryLock(100, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
        
        if(isLockAcquired) {
            try {
            	account.withdraw(amt);
            	System.out.println("Lock Acquired");
            } finally {
                lock.unlock();
                System.out.println("Lock Released");
            }
        }
       
      } else {
        System.out.println("Not enough in account to withdraw " + account.getBalance());
      }
    }

  }

  class Account {
    private int balance = 50;
    public int getBalance() {
      return balance;
    }
    public void withdraw(int amount) {
      balance = balance - amount;
    }
  }
package com.bridgelabz.mapinterface;
import java.util.*;

public class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>(); // AccountNumber -> Balance
    private TreeMap<Double, List<Integer>> sortedAccounts = new TreeMap<>(); // Balance -> Account Numbers
    private Queue<String> withdrawalQueue = new LinkedList<>(); // Stores withdrawal requests

    // Create a new account
    public void createAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        sortedAccounts.computeIfAbsent(initialBalance, k -> new ArrayList<>()).add(accountNumber);
    }

    // Request withdrawal (adds to queue)
    public void requestWithdrawal(int accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found: " + accountNumber);
            return;
        }
        withdrawalQueue.add(accountNumber + " " + amount);
        System.out.println("Withdrawal requested: Account " + accountNumber + " -> $" + amount);
    }

    // Process withdrawals
    public void processWithdrawals() {
        System.out.println("\nProcessing Withdrawals...");
        while (!withdrawalQueue.isEmpty()) {
            String[] request = withdrawalQueue.poll().split(" ");
            int accountNumber = Integer.parseInt(request[0]);
            double amount = Double.parseDouble(request[1]);

            if (accounts.containsKey(accountNumber) && accounts.get(accountNumber) >= amount) {
                double oldBalance = accounts.get(accountNumber);
                double newBalance = oldBalance - amount;
                accounts.put(accountNumber, newBalance);

                // Update sortedAccounts
                sortedAccounts.get(oldBalance).remove((Integer) accountNumber);
                if (sortedAccounts.get(oldBalance).isEmpty()) {
                    sortedAccounts.remove(oldBalance);
                }
                sortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);

                System.out.println("Withdrawal successful: Account " + accountNumber + " -> $" + amount);
            } else {
                System.out.println("Insufficient funds: Account " + accountNumber);
            }
        }
    }

    // Display accounts sorted by balance
    public void displayAccountsSortedByBalance() {
        System.out.println("\nAccounts Sorted by Balance:");
        for (Map.Entry<Double, List<Integer>> entry : sortedAccounts.entrySet()) {
            for (int acc : entry.getValue()) {
                System.out.println("Account " + acc + " -> $" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Creating accounts
        bank.createAccount(101, 1000);
        bank.createAccount(102, 500);
        bank.createAccount(103, 1500);



        // Withdrawal requests
        bank.requestWithdrawal(101, 300);
        bank.requestWithdrawal(102, 800);
        bank.requestWithdrawal(103, 1000);

        // Display accounts before processing withdrawals
        bank.displayAccountsSortedByBalance();

        // Process withdrawals
        bank.processWithdrawals();

        // Display accounts after processing withdrawals
        bank.displayAccountsSortedByBalance();
    }
}
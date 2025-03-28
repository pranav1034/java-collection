package com.bridgelabz.insurancepolicysystemsets;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        // Creating sample policies
        manager.addPolicy(new Policy("P101", "Pranav", LocalDate.of(2025, 5, 10), "Health", 1000.00));
        manager.addPolicy(new Policy("P102", "Nikhil", LocalDate.of(2024, 4, 15), "Auto", 800.00));
        manager.addPolicy(new Policy("P103", "Aman", LocalDate.of(2024, 3, 20), "Home", 1200.00));
        manager.addPolicy(new Policy("P104", "Shyam", LocalDate.of(2024, 3, 30), "Health", 1500.00));
        manager.addPolicy(new Policy("P105", "Abhay", LocalDate.of(2024, 6, 10), "Auto", 950.00));

        // Displaying results
        manager.displayAllPolicies();
        manager.displayExpiringPolicies();
        manager.displayPoliciesByCoverage("Health");
    }
}


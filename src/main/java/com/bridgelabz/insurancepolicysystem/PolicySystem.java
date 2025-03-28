package com.bridgelabz.insurancepolicysystem;

import java.time.LocalDate;
import java.util.*;

public class PolicySystem {
    private Map<String, Policy> policyMap = new HashMap<>();
    private Map<String, Policy> orderedPolicyMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> expiryMap = new TreeMap<>();

    // Add a policy
    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicyMap.put(policy.policyNumber, policy);

        expiryMap.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    // Retrieve a policy by its number
    public Policy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List all policies expiring within the next 30 days
    public List<Policy> getExpiringSoonPolicies() {
        LocalDate today = LocalDate.now();
        LocalDate cutoffDate = today.plusDays(30);

        List<Policy> expiringPolicies = new ArrayList<>();
        for (Map.Entry<LocalDate, List<Policy>> entry : expiryMap.subMap(today, true, cutoffDate, true).entrySet()) {
            expiringPolicies.addAll(entry.getValue());
        }
        return expiringPolicies;
    }

    // List all policies for a specific policyholder
    public List<Policy> getPoliciesByHolder(String holder) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyHolder.equalsIgnoreCase(holder)) {
                result.add(policy);
            }
        }
        return result;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<String, Policy>> it = policyMap.entrySet().iterator();

        while (it.hasNext()) {
            Policy policy = it.next().getValue();
            if (policy.expiryDate.isBefore(today)) {
                it.remove(); // Remove from HashMap
                orderedPolicyMap.remove(policy.policyNumber); // Remove from LinkedHashMap
                expiryMap.get(policy.expiryDate).remove(policy); // Remove from TreeMap
                if (expiryMap.get(policy.expiryDate).isEmpty()) {
                    expiryMap.remove(policy.expiryDate);
                }
            }
        }
    }

    // Display all policies (for debugging)
    public void displayAllPolicies() {
        System.out.println("All Policies:");
        for (Policy policy : orderedPolicyMap.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        PolicySystem system = new PolicySystem();

        // Adding policies
        system.addPolicy(new Policy("P1001", "Pranav", LocalDate.now().plusDays(10)));
        system.addPolicy(new Policy("P1002", "Abhi", LocalDate.now().plusDays(40)));
        system.addPolicy(new Policy("P1003", "Akshay", LocalDate.now().minusDays(5))); // Expired
        system.addPolicy(new Policy("P1004", "Aman", LocalDate.now().plusDays(25)));

        // Display all policies
        system.displayAllPolicies();

        // Retrieve a specific policy
        System.out.println("\nPolicy P1002: " + system.getPolicy("P1002"));

        // Policies expiring in next 30 days
        System.out.println("\nExpiring Soon Policies: " + system.getExpiringSoonPolicies());

        System.out.println("\nPranav's Policies: " + system.getPoliciesByHolder("Pranav"));

        // Remove expired policies
        system.removeExpiredPolicies();
        System.out.println("\nAfter Removing Expired Policies:");
        system.displayAllPolicies();
    }
}

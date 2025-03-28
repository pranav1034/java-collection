package com.bridgelabz.insurancepolicysystemsets;
import java.util.*;
import java.time.LocalDate;


class PolicyManager {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();

    // Add policy to all sets
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Retrieve all unique policies
    public void displayAllPolicies() {
        System.out.println("\nAll Policies:");
        for (Policy p : hashSetPolicies) {
            System.out.println(p);
        }
    }

    // Retrieve policies expiring within 30 days
    public void displayExpiringPolicies() {
        LocalDate today = LocalDate.now();
        LocalDate cutoffDate = today.plusDays(30);

        System.out.println("\nPolicies Expiring Soon:");
        for (Policy p : treeSetPolicies) {
            if (p.getExpiryDate().isBefore(cutoffDate)) {
                System.out.println(p);
            }
        }
    }

    // Retrieve policies by coverage type
    public void displayPoliciesByCoverage(String coverageType) {
        System.out.println("\nPolicies with Coverage: " + coverageType);
        for (Policy p : hashSetPolicies) {
            if (p.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(p);
            }
        }
    }

    // Find duplicate policies based on policy number
    public void findDuplicatePolicies() {
        Map<String, Integer> policyCount = new HashMap<>();
        for (Policy p : hashSetPolicies) {
            policyCount.put(p.getPolicyNumber(), policyCount.getOrDefault(p.getPolicyNumber(), 0) + 1);
        }

        System.out.println("\nDuplicate Policies:");
        for (Map.Entry<String, Integer> entry : policyCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Policy Number: " + entry.getKey() + " (Count: " + entry.getValue() + ")");
            }
        }
    }
}


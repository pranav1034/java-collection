package com.bridgelabz.insurancepolicysystemsets;

import java.time.LocalDate;
import java.util.*;

class Policy implements Comparable<Policy> {
    private String policyNumber;  // Unique Identifier
    private String policyHolder;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyHolder, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyHolder() { return policyHolder; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }
    public double getPremiumAmount() { return premiumAmount; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return String.format("Policy[%s, %s, %s, %s, $%.2f]",
                policyNumber, policyHolder, expiryDate, coverageType, premiumAmount);
    }
}

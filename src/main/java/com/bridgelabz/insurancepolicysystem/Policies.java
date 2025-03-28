package com.bridgelabz.insurancepolicysystem;

import java.time.LocalDate;

class Policy {
    String policyNumber;
    String policyHolder;
    LocalDate expiryDate;

    public Policy(String policyNumber, String policyHolder, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return policyNumber + " (" + policyHolder + ") - Expiry: " + expiryDate;
    }
}

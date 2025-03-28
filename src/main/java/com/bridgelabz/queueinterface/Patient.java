package com.bridgelabz.queueinterface;
import java.util.*;

public class Patient {
    String name;
    int severity;

    public Patient(String name, int severity){
        this.name=name;
        this.severity=severity;
    }

    public String toString() {
        return name + (" |Severity: " + severity);
    }

    public static void main(String[] args) {
        PriorityQueue<Patient> pq = new PriorityQueue<>((p1, p2) -> p2.severity - p1.severity);

        // Add patients
        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));

        // Process patients based on severity
        System.out.println("Treatment Order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}

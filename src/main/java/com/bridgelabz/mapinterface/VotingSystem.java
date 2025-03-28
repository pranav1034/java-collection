package com.bridgelabz.mapinterface;

import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>(); // Stores votes (Candidate -> Votes)
    private Map<String, Integer> orderedVotes = new LinkedHashMap<>(); // Maintains order of voting
    private TreeMap<String, Integer> sortedVotes = new TreeMap<>(); // Stores sorted results

    // Cast a vote for a candidate
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        orderedVotes.put(candidate, voteMap.get(candidate)); // Maintain order of votes
    }

    // Display votes in the order they were received
    public void displayOrderedVotes() {
        System.out.println("\nVotes in Order Received:");
        for (Map.Entry<String, Integer> entry : orderedVotes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Display votes in sorted order (alphabetically by candidate name)
    public void displaySortedVotes() {

        sortedVotes.putAll(voteMap); // Copy data to TreeMap for sorting
        System.out.println("\nVotes in Sorted Order:");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }


    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        // Casting votes
        system.castVote("B");
        system.castVote("A");
        system.castVote("A");
        system.castVote("C");
        system.castVote("B");
        system.castVote("A");

        // Display results
        system.displayOrderedVotes();  // Order of votes received
        system.displaySortedVotes();   // Sorted by candidate names
    }
}

package com.bridgelabz.queueinterface;
import java.util.*;

public class CircularBuffer {
    private int[] buffer;
    private int size, front, rear, count;

    public CircularBuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public void enqueue(int value) {
        rear = (rear + 1) % size;
        buffer[rear] = value;

        if (count < size) {
            count++;
        } else {
            front = (front + 1) % size;
        }
    }


    public int dequeue() {
        if (count == 0) throw new RuntimeException("Buffer is empty!");

        int removedElement = buffer[front];
        front = (front + 1) % size;
        count--;

        return removedElement;
    }

    public int peek() {
        if (count == 0) throw new RuntimeException("Buffer is empty!");
        return buffer[front];
    }

    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size] + (i < count - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}

class Main {
    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.enqueue(1);
        buffer.enqueue(2);
        buffer.enqueue(3);
        buffer.display();

        buffer.enqueue(4);
        buffer.display();

        System.out.println("Dequeued: " + buffer.dequeue());
        buffer.display();

        buffer.enqueue(5);
        buffer.display();
    }
}


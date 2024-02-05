package edu.neu.csye6200;

public class Stack {
    int[] arr;
    int capacity, top;
    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
    public int size() {
        return top + 1;
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return (top == capacity - 1);
    }
    public void push(int item) {
        if (isFull()) {
            System.exit(1); // ERROR
        }
        System.out.println("Inserting " + item);
                arr[++top] = item;
    }
    public int pop() {
        if (isEmpty()) {
            System.exit(1); // ERROR
        }
        System.out.println("Removing " + peek());
        return arr[top--];
    }
    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            System.exit(1); // ERROR
        }
        return -1;
    }
    public static void demo() {
        Stack q = new Stack(5);
        q.push(1); // 1st in
        q.push(2); // 2nd in
        q.pop(); // 2nd out is 2
        q.pop(); // 1st out is 1
        q.push(2); // 3rd in
        System.out.println("Top element is: " + q.peek());
        System.out.println("Stack size is " + q.size());
        q.pop(); // 3rd out is 3
        if ( q.isEmpty() )
            System.out.println("Stack Is Empty");
        else
            System.out.println("Stack Is Not Empty");
    }
}

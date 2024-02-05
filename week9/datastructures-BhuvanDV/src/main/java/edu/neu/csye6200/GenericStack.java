package edu.neu.csye6200;

public class GenericStack <T> {
    T[] arr;
    int capacity, top;
    public GenericStack(int size) {
        arr = (T[]) new Object[size];
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
    public void push(T item) {
        if (isFull()) {
            System.exit(1); // ERROR
        }
        System.out.println("Inserting " + item);
        arr[++top] = item;
    }
    public T pop() {
        if (isEmpty()) {
            System.exit(1); // ERROR
        }
        System.out.println("Removing " + peek());
        return arr[top--];
    }
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return arr[top];
    }
    public static void demo() {
        GenericStack q = new GenericStack(5);
        q.push("Bhuvan"); // 1st in
        q.push("ajay"); // 2nd in
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

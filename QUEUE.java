
public class QUEUE {
    public static void main(String[] args) {
        SimpleQueue queue = new SimpleQueue(5); // Create a queue of size 5

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // Attempt to enqueue to a full queue

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); // Attempt to dequeue from an empty queue
    }
}

class SimpleQueue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    // Constructor to initialize the queue
    public SimpleQueue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    // Enqueue method to add an element to the queue
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Unable to enqueue " + value);
        } else {
            if (rear == maxSize - 1) {
                rear = -1;
            }
            queueArray[++rear] = value;
            nItems++;
            System.out.println("Enqueued " + value + " to queue");
        }
    }

    // Dequeue method to remove and return the front element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Unable to dequeue.");
            return -1;
        } else {
            int value = queueArray[front++];
            if (front == maxSize) {
                front = 0;
            }
            nItems--;
            System.out.println("Dequeued " + value + " from queue");
            return value;
        }
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return (nItems == 0);
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return (nItems == maxSize);
    }
}

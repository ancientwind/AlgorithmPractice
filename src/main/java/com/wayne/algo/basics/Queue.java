package com.wayne.algo.basics;

/**
 * Created by wayne on 2017/11/27.
 */
public class Queue {

    private final int MAX_SIZE = 10;

    private int[] queue;
    private int size;
    private int front;
    private int rear;

    public Queue() {
        this.size = this.MAX_SIZE;
        this.init();
    }

    public Queue(int size) {
        this.size = size;
        this.init();
    }

    public void init() {
        this.queue = new int[this.size];
        this.front = 0;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return this.front == this.rear + 1;
    }

    public void add(int v) {
        if (this.rear == this.size - 1) {
            rear = -1;
        }
        queue[++this.rear] = v;
    }

    public int remove() {
        int rs = queue[this.front++];
        if (front == size) {
            front = 0;
        }
        return rs;
    }

    public int element() {
        return queue[this.front];
    }
}

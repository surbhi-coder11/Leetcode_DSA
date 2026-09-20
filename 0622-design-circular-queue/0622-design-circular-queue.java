class MyCircularQueue {
    int capacity;
    int[] data;
    int head;
    int count =0;
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.data = new int[k];
        this.head = 0;
        this.count = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        int idx = (head+count)%capacity;
        data[idx] = value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        head = (head+1)% capacity;
        count--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return data[head];

    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }

      int  rear = (head+count -1)% capacity;
        return data[rear];
    }
    
    public boolean isEmpty() {
        return count==0;
    }
    
    public boolean isFull() {
        return count==capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
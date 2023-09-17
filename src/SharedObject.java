import java.util.Scanner;

public class SharedObject {
    // 값이 비어 있으면 Receiver객체는 기다림, 채워져 있으면 Sender는 기다림
    private int value;
    Scanner sc = new Scanner(System.in);
    private int SIZE;
    private boolean ValueFlag = false;
    public SharedObject(){
        this.SIZE = 10;
    }
    public synchronized int take() throws InterruptedException {
        while (!ValueFlag){
            wait();
        }
        ValueFlag = false;
        notifyAll();
        return value;
    }
    public synchronized void put(int val) throws InterruptedException {
        while (ValueFlag){
            wait();
        }
        value = val;
        System.out.println("MESSAGE RECEIVED : " + value);
        ValueFlag = true;
        notifyAll();
    }
    public synchronized int getSize(){
        return this.SIZE;
    }
    public synchronized void setSize(int size){
        this.SIZE = size;
    }
}

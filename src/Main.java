// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static void run(){
        SharedObject a = new SharedObject();
        Thread sendThread = new Sender(a);
        Thread receiveThread = new Receiver(a);
        sendThread.start();
        receiveThread.start();
    }
    public static void main(String[] args) {
        run();
    }
}
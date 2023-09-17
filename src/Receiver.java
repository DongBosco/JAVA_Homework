public class Receiver extends Thread{
    // SharedObject의 take()메소드를 주기적으로 호출하여 공유 값을 가져온 후 sum에 더함
    private final SharedObject obj;
    private  int sum = 0;
    public Receiver(SharedObject object){
        this.obj = object;
    }
    @Override
    public void run() {
        int size = obj.getSize();
        for(int i = 0; i<size; i++) {
            try {
                int value = obj.take();
                sum += value;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("sum :"+sum);
    }
}

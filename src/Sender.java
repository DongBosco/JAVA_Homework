public class Sender extends Thread{
    // SharedObject의 put()메소드를 주기적으로 호출하여 배열의 값을 하나씩 저장함
    private SharedObject obj;
    private int [] values;
    public Sender(SharedObject object){
        this.obj = object;
        values = new int[obj.getSize()];
        for(int i = 0 ; i < values.length; i++){
            values[i]= (i+1);
        }
    }
    @Override
    public void run() {
        int size = obj.getSize();
        for(int i = 0; i<size; i++){
            try{
                obj.put(values[i]);
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

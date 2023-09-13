public class SharedObject {
    private int score; // 값이 비어 있으면 Receiver객체는 기다림, 채워져 있으면 Sender는 기다림
    private int[] value;
    private boolean ValueFlag = false;

    SharedObject(){
        this.score = 0;
        this.value = new int[10];

    }
    public int take(){
        return 0;
    }
    public void put(int value){
        this.score += value;
    }
}

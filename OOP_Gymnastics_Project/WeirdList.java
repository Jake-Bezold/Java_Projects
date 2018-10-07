import java.io.*;


public class WeirdList{
    
    private int head;
    private WeirdList tail;
    
    public static final WeirdList EMPTY = new WeirdListEmpty();

    public WeirdList (int head0, WeirdList tail0){
	this.head = head0;
	this.tail = tail0;
    }

    public int length(){
	return 1 + tail.length();
    }
    
    public void print(){
	System.out.print(this.head + " ");
	tail.print();
    }

    public WeirdList map(IntUnaryFunction func) {
	return new WeirdList(func.apply(head), tail.map(func));
    }

}

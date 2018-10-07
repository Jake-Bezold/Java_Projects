import java.io.*;

public class WeirdListEmpty extends WeirdList {

    public WeirdListEmpty() {
	super(0, null);
    }

    
    public int length() {
	return 0;
    }

    
    public void print(){

    }

    public WeirdList map(IntUnaryFunction func){
	return new WeirdListEmpty();
    }
}

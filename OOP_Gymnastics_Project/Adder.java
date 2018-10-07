import java.io.*;

public class Adder implements IntUnaryFunction{
    private int x0;  
    
    public Adder(int n){
    x0 = n;
    }

    @Override
    public int apply(int x){
	return x + x0;
    }

}

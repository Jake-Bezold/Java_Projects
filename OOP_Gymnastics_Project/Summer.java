import java.io.*;

public class Summer implements IntUnaryFunction {
    private int s0;
    
    public Summer() {
	s0 = 0;
    }

    public int getS(){
	return s0;
    }

    @Override
    public int apply(int x) {
	s0 += x;
	return s0;
     }
}

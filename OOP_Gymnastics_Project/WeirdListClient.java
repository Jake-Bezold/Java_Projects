import java.io.*;

public class WeirdListClient{

    public static WeirdList add(WeirdList L, int n) {
	Adder adder = new Adder(n);
	return L.map(adder);
    }

    public static int sum(WeirdList L) {
	Summer summer = new Summer();
	L.map(summer);
	return summer.getS();
    }
    //made the test to output it here, rather than creating a whole different test class
    public static void main(String[] args){
	WeirdList L = new WeirdList(1, new WeirdList(2, new WeirdListEmpty()));

	int sum =  sum(L);
	L  = add(L, 1);
	L.print();
	System.out.println("\n" + sum);
    }

}

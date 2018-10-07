import java.io.*;

public class WeirdListTest{

    public static void main(String[] args){
	WeirdList L = new WeirdList(1, new WeirdList(2, new WeirdListEmpty()));
	L.print();
	

	L.map(adder).print();
    }
}

import java.io.IOException;
import java.io.StringReader;
import java.io.Reader;
import java.io.IOException;


/** String translation. */
public class Translate {
    /** Return the String S, but with all characters that occur in FROM
     *  changed to the corresponding characters in TO. FROM and TO must
     *  have the same length. */
    
    static String translate(String S, String from, String to) {
        /* NOTE: The try {...} catch is a technicality to keep Java happy. */
  
        char[] buffer = new char[S.length()];
        try {
	    Reader r = new StringReader(S);
	    TrReader trR = new TrReader(r, from, to );
	    
	    trR.read(buffer);
	    return new String(buffer);
            // REPLACE ABOVE LINE WITH THE RIGHT ANSWER.
        }
	catch (IOException e)
	    {
		return null;
	    }
    }
    
    /*
       REMINDER: translate must
      a. Be non-recursive
      b. Contain only 'new' operations, and ONE other method call, and no
         other kinds of statement (other than return).
      c. Use only the library classes String, and anything containing
         "Reader" in its name (browse the on-line documentation).
    */

    
    /* rather than making a whole new class to test, I created a main to make sure the translate
       method worked as intended*/
    public static void main(String[] args) throws IOException{
	Translate t = new Translate();
	System.out.println( t.translate("import jav.", "import jav.", "Jake Bezold"));
    }
}
    

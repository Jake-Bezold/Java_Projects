import java.io.Reader;
import java.io.IOException;

/** Translating Reader: a stream that is a translation of an
 *  existing reader. */
public class TrReader extends Reader {
    /** A new TrReader that produces the stream of characters produced
     *  by STR, converting all characters that occur in FROM to the
     *  corresponding characters in TO.  That is, change occurrences of
     *  FROM.charAt(0) to TO.charAt(0), etc., leaving other characters
     *  unchanged.  FROM and TO must have the same length. */
    private Reader str0;
    private String from0;
    private String to0;


    public TrReader(Reader str, String from, String to) {
        this.str0 = str;
	this.from0 = from;
	this.to0 = to;
    }

    @Override
    public int read(char[] cbuf) throws IOException{
	//translate "from" str to "to", store it in c
	try{
	    str0.read(cbuf);
	}
	catch (IOException e){
	    e.printStackTrace();
	}
	for(int i = 0; i < cbuf.length; i++){
	    if (from0.indexOf(cbuf[i]) != -1){
		cbuf[i] = to0.charAt(from0.indexOf(cbuf[i]));;
	    }
	}
	return 0;
    }

    @Override
    public int read(char[] cbuf, int off, int len)throws IOException{
	return str0.read(cbuf, off, len);

    }
    
    @Override
    public void  close()throws IOException{
	str0.close();
    }

    
    // FILL IN
    // NOTE: Until you fill in the right methods, the compiler will
    //       reject this file, saying that you must declare TrReader
    //     abstract.  Don't do that; define the right methods instead!
}



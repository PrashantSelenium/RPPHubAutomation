package hub.library;

import java.util.Arrays;

public class Results extends ObjectReference {

    public void pass(String value) {
        System.out.println("PASSED - " + value);
    }

    public void fail(String value) {
        java.lang.System.err.println("FAILED - " + value);
    }
    
    public void logInput(String[] input) {	
        System.out.println("INPUT - " + Arrays.toString(input));
    }

    public void log(String input) {	
        System.out.println("LOG - " + input);
    }

}

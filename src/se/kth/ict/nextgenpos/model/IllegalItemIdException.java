
package se.kth.ict.nextgenpos.model;


public class IllegalItemIdException extends Exception{
    /**
     * 
     * @param msg
     * @param rootCause
     
     */
    public IllegalItemIdException(String msg, Exception rootCause){
        super(msg, rootCause);
    }
    
}

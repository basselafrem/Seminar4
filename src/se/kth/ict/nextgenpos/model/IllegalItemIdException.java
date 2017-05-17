
package se.kth.ict.nextgenpos.model;


public class IllegalItemIdException extends Exception{
    /**
     * 
     * @param msg   the message to be thrown 
     * @param rootCause the root cause of the exception
     
     */
    public IllegalItemIdException(String msg, Exception rootCause){
        super(msg, rootCause);
    }
    
}

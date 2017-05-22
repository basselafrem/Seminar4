package se.kth.ict.nextgenpos.view;

import se.kth.ict.nextgenpos.controller.Controller;
import se.kth.ict.nextgenpos.model.IllegalItemIdException;
import se.kth.ict.nextgenpos.model.LogHandler;
import se.kth.ict.nextgenpos.model.Observer;


/**
 * A placeholder for the view.
 */
public class View {
    private Controller cont;
    private Observer obs;
    private LogHandler logger;
    private ErrorMessageHandler errorMsgHandler;

    /**
     * Creates a new <code>View</code>.
     * @param cont           The controller of the application.
     * @param obs   some observer of the application
     */
    public View(Controller cont) {
	this.cont = cont;
        this.obs = new SomeObserver();
    }

    /**
     * Simulates a view. Makes some calls to the controller.
     */
    public void test() {
	cont.makeNewSale();
        cont.addSaleObserver(obs);
        for (int i = 1; i < 5; i++) {
    try {
        enterItem(i);
    } catch (IllegalItemIdException iae) {
        //System.out.println(iae.getMessage());
        //logger.logException(iae);
        //errorMsgHandler.showErrorMsg("Product Not Found");
        errorMsgHandler.showErrorMsg(iae.getMessage() + " Product Not Found.");
    }
}
    }

    private void enterItem(int itemId) throws IllegalItemIdException {
	int quantity = 1;
	System.out.println("");
	System.out.println("Result for item " + itemId + ": " + cont.enterItem(itemId, quantity));
	System.out.println("");
    }
    /**
     *Takes care of all the exceptions so they will be printed and logged.
     *
     * @param msg The message of why there was an exception
     * @param e the exception that occurred
     */
    private void exceptionHandler(String msg, Exception e){
        errorMsgHandler.showErrorMsg(msg);
        logger.logException(e);

}
}

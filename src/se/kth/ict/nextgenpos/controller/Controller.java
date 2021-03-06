package se.kth.ict.nextgenpos.controller;

import se.kth.ict.nextgenpos.model.IllegalItemIdException;
import se.kth.ict.nextgenpos.model.LogHandler;
import se.kth.ict.nextgenpos.model.Observer;
import se.kth.ict.nextgenpos.model.Sale;
import se.kth.ict.nextgenpos.model.Receipt;
import se.kth.ict.nextgenpos.model.ProductCatalog;
import se.kth.ict.nextgenpos.model.ProductSpecification;
import se.kth.ict.nextgenpos.view.ErrorMessageHandler;

/**
 * The controller of the application. This is the sole controller, all calls to the
 * model pass through here.
 */
public class Controller {
    private Sale sale;
    private ProductCatalog catalog;
    private LogHandler logger;
    private ErrorMessageHandler errorMsgHandler;

    /**
     * Instantiates a new <code>Controller</code>.
     */
    public Controller() {
	catalog = new ProductCatalog();
    }
    
    /**
     * Initiates a new sale. Must be called before <code>enterItem()</code>. 
     *
     * When this method is called after <code>enterItem()</code> all previously stored 
     * information is lost and a new sale is started.
     */
    public void makeNewSale() {
	sale = new Sale();
    }

    /**
     * Adds an item to the current <code>Sale</code>. All calls to this method stores items to 
     * the same sale. When a new sale shall be started <code>makeNewSale()</code> must be
     * called.
     *
     * @param itemId         An identifier for the item that is entered.
     * @param quantity       The quantity of items to be entered.
     * @return               Information about the entered item.
     * @throws IllegalItemIdException if an IllegalArgument Exception is caught.
     * @throws IllegalStateException If this method is called before makeNewSale().
     */
    public ProductSpecification enterItem(int itemId, int quantity) throws IllegalItemIdException {
	if (sale == null) {
	    throw new IllegalStateException("enterItem() called before makeNewSale()");
	}
        try{
	ProductSpecification spec = catalog.findSpecification(itemId);
	sale.addItem(spec, quantity);
	return spec;
        }
        catch(IllegalArgumentException iae){
            throw new IllegalItemIdException("No product found "+ itemId, iae);
          
        }
    }

    /**
     * Returns the total cost for all items registered so far in the current sale.
     * When a new sale shall be started <code>makeNewSale()</code> must be called.
     *
     * @return                       The total cost for all items registered so far in 
     *                               the current sale.
     * @throws IllegalStateException If this method is called before makeNewSale().
     */
    public int getTotalCost() {
	if (sale == null) {
	    throw new IllegalStateException("enterItem() called before makeNewSale()");
	}
	return sale.getCurrentTotal();
    }

    /**
     * Calculates change and returns all information needed for the receipt.
     *
     * @return All information needed for the receipt.
     */
    public Receipt makePayment(int payedAmount) {
	return sale.createReceipt(payedAmount);
    }
    /**
     * calls sale to add an observer
     * @param observer an observer
     */
    public void addSaleObserver(Observer observer){
        sale.addObserver(observer);
    }

}

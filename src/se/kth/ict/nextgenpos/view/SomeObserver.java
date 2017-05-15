package se.kth.ict.nextgenpos.view;

import se.kth.ict.nextgenpos.model.Observer;
import se.kth.ict.nextgenpos.model.ProductSpecification;
import java.util.ArrayList;
import java.util.List;

class SomeObserver implements Observer {
    private List<ProductSpecification> items = new ArrayList<ProductSpecification>();
    /**
    * Creates an observer.
    */
    public SomeObserver () {
    }
    /**
    * Called by the model when a product is registered.
    */
    public void notify(ProductSpecification spec) {
        items.add(spec);
        System.out.println("CURRENT ITEMS REGISTERED:");
        for (int i = 0; i < items.size(); i++){
        System.out.println(""+ (i+1) + ". " + items.get(i));
        }
    }
}
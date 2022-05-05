package company;

import java.math.BigDecimal;

/**
 * @author yudong
 */
public class OrderItem {
    private Product product;
    private int quantity;
    public OrderItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }
    public BigDecimal computePrice(){
        return product.getPrice().multiply(new BigDecimal(Integer.toString(quantity)));
    }

}

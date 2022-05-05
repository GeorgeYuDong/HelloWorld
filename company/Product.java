package company;

import java.math.BigDecimal;

/**
 * @author yudong
 */
public class Product {

    private String id;
    private String name;
    private String pictureUrl;
    private String description;
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}

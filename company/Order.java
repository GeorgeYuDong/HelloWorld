package company;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yudong
 */
public class Order {
    private String id;
    private User user;

    /**产品列表和数量
     *
     */
    private OrderItem[] orderItems;

    /**
     * 下单时间
     * */
    private Date createTime;

    /**
     * 收货地址
     * */
    private String receiver;

    private String telephone;

    /**
     * 订单状态
     *
     */
    private String status;

    public BigDecimal computeTotalPrice(){
        BigDecimal bigDecimal = new BigDecimal("0");
        if(null != orderItems){
            for (OrderItem item:
                 orderItems) {
                bigDecimal = bigDecimal.add(item.computePrice());
            }       
        }
        return bigDecimal;
    }



}

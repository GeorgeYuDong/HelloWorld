package src.company.juc.deadlock;

/**
 * 按序申请共享资源，破坏循环等待条件
 * */
public class OrderedAccount {
    private int id;
    private int balance;
    // 转账
    void transfer(OrderedAccount target, int amt){
        OrderedAccount left = this;
        OrderedAccount right = target;
        if (this.id > target.id) {
            left = target;
            right = this;
        }
        // 锁定序号小的账户
        synchronized(left){
            // 锁定序号大的账户
            synchronized(right){
                if (this.balance > amt){
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
}
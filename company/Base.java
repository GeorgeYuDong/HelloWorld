package company;

/**
 * @author yudong
 */
public class Base {

    private String member;

    public int getA() {
        return a;
    }

    private int a;
    public static int s;
    public String m = "base";

    static {
        System.out.println("基类静态代码块,s: " + s);
        s = 1;
    }

    {
        System.out.println("基类实例代码块,a: " + a);
        a = 1;
    }

    public static void staticTest() {
        System.out.println("base static Test " );
    }

    public Base(String member) {
        System.out.println("基类构造方法，a: " + a);
        this.member = member;
        a = 5;
    }

    public long sum(int a, long b) {
        System.out.println("base_int_long");
        return a + b;
    }

    /**
     * 返回base对象是否可转换为Child类型
     * */
    public boolean canCast(Base b){
        return b instanceof Child;
    }

    protected int currentStep;
    protected void step1(){}
    protected void step2(){}
    /**
     * 模板方法由父类提供
     * action是对外方法
     * step1()由子类重写，定义了由子类查看的步骤currentStep
     * step2()同样子类重写
     * */
    public void action(){
        this.currentStep = 1;
        step1();
        this.currentStep = 2;
        step2();
    }

}

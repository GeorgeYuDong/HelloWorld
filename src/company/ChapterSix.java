package src.company;

/**
 * @author yudong
 */
public class ChapterSix {
    /**
     * 以Throwable为根，继承下去
     * 受检异常： Java要求程序员必须处理,否则会有编译错误。未受检没有要求。
     * RuntimeException,Error和其子类: 未受检异常
     * Exception其他子类和本身:受检异常
     *
     * Error:OutOfMemoryError(内存溢出), StackOverflowError(栈溢出),
     * VirtualMachineError(虚拟机错误)
     *
     * Throwable子类:
     * Exception:IOException, RuntimeException, SQLException
     *
     *
     * RuntimeException:
     * NullPointerException
     * IllegalStateException
     * NumberFormatException
     * IndexOutOfBoundsException
     * ClassCastException
     * ArrayIndexException
     * IllegalArgumentException
     * StringIndexOutOfBoundsException
     *
     * 自定义Exception
     *
     * 如果父类是RuntimeException或者它的子类,则自定义异常也是未受检异常
     * 如果父类是Exception或其其他子类,则自定义异常是受检异常（需要处理）
     *
     *
     * */
}

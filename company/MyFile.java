package company;

import java.util.Date;

/**
 * @author yudong
 */
public class MyFile {

    public String getName() {
        return name;
    }

    /**文件名称*/
    private String name;

    public MyFile(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    /**创建时间*/
    private Date createTime;

    public int getSize() {
        return size;
    }

    /**文件大小*/
    private int size;

    /**上级目录,两个类之间可以互相引用
     * 类的组合和继承，使得三生万物
     *
     * 包管理：
     * 域名唯一：apache.org反过来org.apache则为包
     * 与目录相同即/src/org.apache/
     * 包可以方便封装，供外部使用的类放在包的上层，而内部的实现细节放在子包中
     * 如果类不在一个包内，使用import关键字引用,或者使用完全限定名
     * java.lang包下的类可以直接使用，如String,System
     * */
    private MyFolder parent;

}

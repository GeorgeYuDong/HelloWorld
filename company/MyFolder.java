package company;

import java.util.Date;

/**
 * @author yudong
 */
public class MyFolder {
    private String name;
    private Date creatTime;
    private MyFolder parent;
    /**包含的文件*/
    private MyFile[] files;
    private MyFolder[] subFolders;
}

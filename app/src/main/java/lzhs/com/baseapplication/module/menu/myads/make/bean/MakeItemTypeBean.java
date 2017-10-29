package lzhs.com.baseapplication.module.menu.myads.make.bean;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/10/29 18:43<br/>
 * 邮箱：1050629507@qq.com
 */
public class MakeItemTypeBean {

    boolean isLast;


    int val;

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public MakeItemTypeBean() {
        super();
    }

    public MakeItemTypeBean(boolean isLast, int val) {
        this.isLast = isLast;
        this.val = val;
    }
}

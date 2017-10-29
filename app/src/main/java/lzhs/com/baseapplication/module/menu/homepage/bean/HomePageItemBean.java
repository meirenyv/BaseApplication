package lzhs.com.baseapplication.module.menu.homepage.bean;

/**
 * 作者：LZHS<br/>
 * 时间： 2017/10/29 18:43<br/>
 * 邮箱：1050629507@qq.com
 */
public  class HomePageItemBean {

    int itemType;

    public HomePageItemBean(int itemType) {
        this.itemType = itemType;
    }

    public HomePageItemBean() {
        super();
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
}
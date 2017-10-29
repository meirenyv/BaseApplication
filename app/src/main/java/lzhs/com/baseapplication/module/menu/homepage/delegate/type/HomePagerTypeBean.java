package lzhs.com.baseapplication.module.menu.homepage.delegate.type;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/10/29 22:34<br/>
 * 邮箱：1050629507@qq.com
 */
public class HomePagerTypeBean implements Parcelable {

    int id;
    String name;

    int imgID;

    public HomePagerTypeBean(int id, String name, int imgID) {
        this.id = id;
        this.name = name;
        this.imgID = imgID;
    }

    public HomePagerTypeBean() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(id);
        out.writeString(name);
        out.writeInt(imgID);
    }

    public static final Parcelable.Creator<HomePagerTypeBean> CREATOR = new Creator<HomePagerTypeBean>() {
        @Override
        public HomePagerTypeBean[] newArray(int size) {
            return new HomePagerTypeBean[size];
        }

        @Override
        public HomePagerTypeBean createFromParcel(Parcel in) {
            return new HomePagerTypeBean(in);
        }
    };

    public HomePagerTypeBean(Parcel in) {
        id = in.readInt();
        name = in.readString();
        imgID = in.readInt();
    }

}

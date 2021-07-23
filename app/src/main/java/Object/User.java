package Object;

import java.io.Serializable;

public class User implements Serializable {
    private int anh;
    private String tieude;

    public User(){}

    public User(int anh, String tieude) {
        this.anh = anh;
        this.tieude = tieude;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }
}

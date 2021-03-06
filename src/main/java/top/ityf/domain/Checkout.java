package top.ityf.domain;

/**
 * ClassName:Checkout
 * Package: top.ityf.domain
 * Description: 已经退租列表的实体类
 *
 * @Date: 2020/3/31 15:46
 * @Author: YanFei
 */
public class Checkout {
    private Integer id;
    private String house_id;
    private String address;
    private String status;
    private Integer userlist_id;
    private Userlist userlist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouse_id() {
        return house_id;
    }

    public void setHouse_id(String house_id) {
        this.house_id = house_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUserlist_id() {
        return userlist_id;
    }

    public void setUserlist_id(Integer userlist_id) {
        this.userlist_id = userlist_id;
    }

    public Userlist getUserlist() {
        return userlist;
    }

    public void setUserlist(Userlist userlist) {
        this.userlist = userlist;
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "id=" + id +
                ", house_id='" + house_id + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", userlist_id=" + userlist_id +
                ", userlist=" + userlist +
                '}';
    }
}

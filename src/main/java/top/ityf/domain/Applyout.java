package top.ityf.domain;

import java.util.List;

/**
 * ClassName:Applyout
 * Package: top.ityf.domain
 * Description: 退租申请的实体类
 *
 * @Date: 2020/3/31 15:45
 * @Author: YanFei
 */
public class Applyout {
    private Integer id;
    private String house_id;
    private String address;
    private String status;
    private Integer userlist_id;

    //在查询的时候还要根据userlist_id查询出userlist
    private List<Userlist> userlist;

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

    public List<Userlist> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<Userlist> userlist) {
        this.userlist = userlist;
    }

    @Override
    public String toString() {
        return "Applyout{" +
                "id=" + id +
                ", house_id='" + house_id + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", userlist_id=" + userlist_id +
                ", userlist=" + userlist +
                '}';
    }
}

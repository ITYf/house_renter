package top.ityf.domain;

import java.sql.Date;

/**
 * ClassName:Paid
 * Package: top.ityf.domain
 * Description:
 *
 * @Date: 2020/3/31 16:49
 * @Author: YanFei
 */
public class Paid {
    private Integer id;
    private String house_id;
    private String address;
    private Date date;
    private Double price;
    private String paydate;
    private String name;
    private Integer userlist_id;
    private String status;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserlist_id() {
        return userlist_id;
    }

    public void setUserlist_id(Integer userlist_id) {
        this.userlist_id = userlist_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Paid{" +
                "id=" + id +
                ", house_id='" + house_id + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", paydate='" + paydate + '\'' +
                ", name='" + name + '\'' +
                ", userlist_id=" + userlist_id +
                ", status='" + status + '\'' +
                '}';
    }
}

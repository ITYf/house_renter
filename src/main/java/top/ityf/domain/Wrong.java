package top.ityf.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 * ClassName:Wrong
 * Package: top.ityf.domain
 * Description: 关于保障信息的实体类
 *
 * @Date: 2020/3/31 16:57
 * @Author: YanFei
 */
public class Wrong {
    private Integer id;
    private String house_id;
    private String address;
    /**
     * 在遇到java.spl.Date或java.util.Date时，
     * 可能出现的错误：由于被认为是客户端对错误（例如：畸形的请求语法、无效的请求信息帧或者虚拟的请求路由），服务器无法或不会处理当前请求。
     * 原因：客户端传进来的数据类型和实体类的数据类型不一致
     * 解决：方法一是自定义类型转换器，方法二是采用 @DateTimeFormat注解
     */
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date date;
    private String detail;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
        return "Wrong{" +
                "id=" + id +
                ", house_id='" + house_id + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date +
                ", detail='" + detail + '\'' +
                ", name='" + name + '\'' +
                ", userlist_id=" + userlist_id +
                ", status='" + status + '\'' +
                '}';
    }
}

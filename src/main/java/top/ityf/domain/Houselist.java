package top.ityf.domain;

/**
 * ClassName:Houselist
 * Package: top.ityf.domain
 * Description:
 *
 * @Date: 2020/3/31 16:48
 * @Author: YanFei
 */
public class Houselist {
    private Integer id;
    private String houseid;
    private String address;
    private double area;
    private double price;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Houselist{" +
                "id=" + id +
                ", houseid='" + houseid + '\'' +
                ", address='" + address + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}

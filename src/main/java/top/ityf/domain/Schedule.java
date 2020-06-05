package top.ityf.domain;

/**
 * ClassName:Schedule
 * Package: top.ityf.domain
 * Description:
 *
 * @Date: 2020/3/31 16:51
 * @Author: YanFei
 */
public class Schedule {
    private Integer id;
    private String date;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

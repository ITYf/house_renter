package top.ityf.dao;

import top.ityf.domain.Schedule;

import java.util.List;

/**
 * ClassName:ApplyDao
 * Package: top.ityf.dao
 * Description:
 *
 * @Date: 2020/3/31 21:14
 * @Author: YanFei
 */
public interface ScheduleDao {
    public void insertSchedule(Schedule schedule);

    public List<Schedule> selectAll();

    public void deleteSchedule(Integer id);

    public void updateSchedule(Schedule schedule);

    public Schedule selectById(Integer id);
}

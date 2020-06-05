package top.ityf.service;

import top.ityf.domain.Schedule;

import java.util.List;

/**
 * ClassName:ScheduleService
 * Package: top.ityf.service
 * Description:
 *
 * @Date: 2020/4/5 10:17
 * @Author: YanFei
 */
public interface ScheduleService {
    public void insertSchedule(Schedule schedule);

    public List<Schedule> getAll();

    public void deleteSchedule(Integer id);

    public void updateSchedule(Schedule schedule);

    public Schedule findById(Integer id);
}

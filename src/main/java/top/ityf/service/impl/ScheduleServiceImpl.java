package top.ityf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.ityf.dao.ScheduleDao;
import top.ityf.domain.Schedule;
import top.ityf.service.ScheduleService;

import java.util.List;

/**
 * ClassName:ScheduleService
 * Package: top.ityf.service
 * Description:
 *
 * @Date: 2020/4/5 10:17
 * @Author: YanFei
 */
@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleDao scheduleDao;


    @Override
    public void insertSchedule(Schedule schedule) {
        scheduleDao.insertSchedule(schedule);
    }

    @Override
    public List<Schedule> getAll() {
        List<Schedule> list = scheduleDao.selectAll();
        return list;
    }

    @Override
    public void deleteSchedule(Integer id) {
        scheduleDao.deleteSchedule(id);
    }

    @Override
    public void updateSchedule(Schedule schedule) {
        scheduleDao.updateSchedule(schedule);
    }

    @Override
    public Schedule findById(Integer id) {
        Schedule schedule = scheduleDao.selectById(id);
        return schedule;
    }
}

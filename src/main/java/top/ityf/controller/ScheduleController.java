package top.ityf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.ityf.domain.Schedule;
import top.ityf.service.ScheduleService;

import java.util.List;

/**
 * ClassName:ScheduleController
 * Package: top.ityf.controller
 * Description:
 *
 * @Date: 2020/4/20 19:57
 * @Author: YanFei
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    /**
     * 管理员查看日程
     */
    @RequestMapping("/findAllSchedule")
    public String findAllSchedule(Model model) {
        List<Schedule> schedule = scheduleService.getAll();
        model.addAttribute("schedule", schedule);
        model.addAttribute("mainPage", "schedule.jsp");
        return "admin/main2";
    }

    /**
     * 管理员删除日程
     */
    @RequestMapping("/deleteSchedule")
    public String deleteSchedule(Integer id) {
        scheduleService.deleteSchedule(id);
        return "redirect:findAllSchedule.go";
    }

    /**
     * 跳转到添加日程
     */
    @RequestMapping("/toAddSchedule")
    public String toAddSchedule(Model model) {
        model.addAttribute("mainPage", "addschedule.jsp");
        return "admin/main2";
    }

    /**
     * 添加日程
     */
    @RequestMapping("/insertSchedule")
    public String insertSchedule(Schedule schedule) {
        scheduleService.insertSchedule(schedule);
        return "redirect:findAllSchedule.go";
    }

    /**
     * 跳转到修改日程
     */
    @RequestMapping("/toUpdateSchedule")
    public String toUpdateSchedule(Model model, Integer id) {
        Schedule schedule = scheduleService.findById(id);
        model.addAttribute("schedule", schedule);
        model.addAttribute("mainPage", "updateschedule.jsp");
        return "admin/main2";
    }

    /**
     * 修改日程
     */
    @RequestMapping("/updateSchedule")
    public String updateSchedule(Schedule schedule, Model model) {
        scheduleService.updateSchedule(schedule);
        model.addAttribute("error", "更新成功");
        model.addAttribute("schedule", schedule);
        model.addAttribute("mainPage", "updateschedule.jsp");
        return "admin/main2";

    }
}

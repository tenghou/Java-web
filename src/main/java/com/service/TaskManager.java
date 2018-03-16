package com.service;

import com.service.UpdateType;
import com.util.TimeUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;


/**
 * 调用UpdateType（）执行更新职级
 */
public class TaskManager implements ServletContextListener {

    // 时间间隔
    private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;  //一天
    /**
     * 定时器
     */
    private Timer timer;
    public void contextInitialized(ServletContextEvent event) {


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 1);//每天1点自动执行
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date date=calendar.getTime(); //第一次执行定时任务的时间
        //避免程序部署后立即执行更新
        if (date.before(new Date())) {
            date = this.addDay(date, 1);
        }

        // 第一次执行定时任务的时间
        System.out.println("执行时间：" + TimeUtil.TimeStamp2Date(TimeUtil.getNowTimeStamp()));

        event.getServletContext().log("定时器已启动");
        //定义定时器
        timer = new Timer("自动更新员工等级",true);
        //启动备份任务,每天执行一次
        timer.schedule(new UpdateType(),date, PERIOD_DAY);
        event.getServletContext().log("已经添加任务调度表");
    }

    public void contextDestroyed(ServletContextEvent event) {
        timer.cancel(); // 定时器销毁
        event.getServletContext().log("定时器已销毁");
    }

    // 增加或减少天数
    public Date addDay(Date date, int num) {
        Calendar startDT = Calendar.getInstance();
        startDT.setTime(date);
        startDT.add(Calendar.DAY_OF_MONTH, num);
        return startDT.getTime();
    }

}

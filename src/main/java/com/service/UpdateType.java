package com.service;

import com.service.impl.EmpTypeImpl;
import java.util.TimerTask;

/**
 * 执行更新职级任务
 */
public class UpdateType extends TimerTask{
    private static boolean isRunning = false;

    public void run() {

        if (!isRunning) {
            isRunning = true;
            System.out.println("开始执行任务..."); //开始任务
            //working  add what you want to do
            try {
                EmpTypeImpl empType = new EmpTypeImpl();
                //按部门根据入职时间长短自动更新职级
                empType.updateEmpType(31536000,"A");
                empType.updateEmpType(31536000 * 2,"B");
                empType.updateEmpType(31536000 * 2,"C");
                empType.updateEmpType(31536000 * 3,"D");
                empType.updateEmpType(31536000 * 4,"E");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("执行任务完成..."); //任务完成
            isRunning = false;
        } else {
            System.out.println("上一次任务执行还未结束..."); //上一次任务执行还未结束
        }
    }


}



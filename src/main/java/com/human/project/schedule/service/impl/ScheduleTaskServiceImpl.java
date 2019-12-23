package com.human.project.schedule.service.impl;

import com.human.project.schedule.dao.WagesInfoMapper;
import com.human.project.schedule.domain.WagesInfo;
import com.human.project.schedule.service.ScheduleTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author linwt
 * @date 2019/12/19 15:22
 */
@Service
@EnableScheduling
public class ScheduleTaskServiceImpl implements ScheduleTaskService {

    private static Logger logger = LoggerFactory.getLogger(ScheduleTaskService.class);
    public SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private WagesInfoMapper wagesInfoMapper;

    class MyThread extends Thread{
        public MyThread(){
            super();
        }
        public void run(){
            logger.info("TimeWater:执行更新实时数据, 开始" + now.format(new Date()));
            System.err.println("===========TimeWater: 执行更新实时数据, 开始");
            doNewInfo();
            logger.info("TimeWater: 执行更新实时数据, 结束" + now.format(new Date()));
            System.err.println("===========TimeWater: 执行更新实时数据, 结束......");

        }
    }
    public void doNewInfo(){
        //System.out.println();
        logger.info("开启定时任务，同步工资信息到工资记录表");
        List<WagesInfo> wagesInfos = wagesInfoMapper.getAllWageInfo();
        System.out.println(wagesInfos);
        wagesInfoMapper.insertWagesRecord(wagesInfos);
        logger.info("定时任务完成");
    }

    /**
     * 每月的第一天都将上一个月的员工工资导入工资发放记录，便于工资发放
     */
    @Override
    @Scheduled(cron = "0 0 0 1 * ?")//每个月1号执行
    public void insertWagesRecord(){
        System.out.println("定时执行");
        MyThread t=new MyThread();
        t.start();
    }


}

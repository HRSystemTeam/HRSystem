package com.human.project.schedule.service.impl;

import com.human.project.schedule.dao.WagesInfoMapper;
import com.human.project.schedule.domain.WagesInfo;
import com.human.project.schedule.service.ScheduleTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linwt
 * @date 2019/12/19 15:22
 */
@Service
public class ScheduleTaskServiceImpl implements ScheduleTaskService {

    private static Logger logger = LoggerFactory.getLogger(ScheduleTaskService.class);

    @Autowired
    private WagesInfoMapper wagesInfoMapper;

    @Override
    @Scheduled(cron = "0 0 0 1 * ?")
    public void insertWagesRecord() {
        logger.info("开启定时任务，同步工资信息到工资记录表");
        List<WagesInfo> wagesInfos = wagesInfoMapper.getAllWageInfo();
        wagesInfoMapper.insertWagesRecord(wagesInfos);
        logger.info("定时任务完成");
    }
}

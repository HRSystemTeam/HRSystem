package com.human.project.schedule.service.impl;

import com.human.project.schedule.dao.WagesInfoMapper;
import com.human.project.schedule.domain.WagesInfo;
import com.human.project.schedule.service.ScheduleTaskService;
import com.human.project.schedule.service.WagesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * @author cc
 * @date 2019/12/19 21:17
 */
@Service
public class WagesServiceImpl implements WagesService {

    private static Logger logger = LoggerFactory.getLogger(ScheduleTaskService.class);

    @Autowired
    private WagesInfoMapper wagesInfoMapper;

    @Override
    public List<WagesInfo> selectRecordList(WagesInfo wagesInfo) {
        logger.info("获取工资记录");
        return wagesInfoMapper.selectRecordList(wagesInfo);
    }

    @Override
    public List<String> getAllMonth() {
        logger.info("获取发放工资日期记录");
        return wagesInfoMapper.getAllMonth();
    }

    @Override
    public void sendWagesByIds(List<Long> ids) {
        logger.info("工资发放");
        wagesInfoMapper.sendWagesByIds(ids);
    }


}

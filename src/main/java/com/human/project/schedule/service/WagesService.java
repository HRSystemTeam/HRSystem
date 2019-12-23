package com.human.project.schedule.service;

import com.human.project.schedule.domain.WagesInfo;

import java.sql.Date;
import java.util.List;

public interface WagesService {
    List<WagesInfo> selectRecordList(WagesInfo wagesInfo);
    List<String> getAllMonth();
    void sendWagesByIds(List<Long> ids);

}

package com.human.project.schedule.dao;

import com.human.project.schedule.domain.WagesInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linwt
 * @date 2019/12/19 15:23
 */
@Mapper
public interface WagesInfoMapper {
    /**
     * 获取所有状态正常的员工的工资信息
     * @return 结果
     */
    List<WagesInfo> getAllWageInfo();

    /**
     * 插入员工工资发放记录
     * @param wagesInfos
     */
    void insertWagesRecord(@Param("wagesInfos")List<WagesInfo> wagesInfos);
}

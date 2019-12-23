package com.human.project.schedule.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.human.framework.web.controller.BaseController;
import com.human.framework.web.domain.AjaxResult;
import com.human.framework.web.page.TableDataInfo;
import com.human.project.schedule.domain.WagesInfo;
import com.human.project.schedule.service.WagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/system/wages")
public class WagesController extends BaseController {

    @Autowired
    private WagesService wagesService;

    /**
     * 获取工资发放记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:wages:list')")
    @GetMapping("/list")
    public TableDataInfo list(WagesInfo wagesInfo)
    {
        startPage();
        List<WagesInfo> list = wagesService.selectRecordList(wagesInfo);
        return getDataTable(list);
    }

    /**
     * 获取工资列表用于导出，没有分页
     */
    @PreAuthorize("@ss.hasPermi('system:wages:getListWages')")
    @GetMapping("/getListWages")
    public AjaxResult getListWages(WagesInfo wagesInfo)
    {
        return AjaxResult.success(wagesService.selectRecordList(wagesInfo));
    }

    /**
     * 获取工资发放的月份
     * @return
     */
    @PreAuthorize("@ss.hasPermi('system:wages:monthList')")
    @GetMapping("/monthList")
    public AjaxResult monthList()
    {
        AjaxResult ajaxResult = AjaxResult.success(wagesService.getAllMonth());
        return ajaxResult;
    }

    /**
     * 根据记录id发放工资
     * @param ids
     * @return
     */
    @PreAuthorize("@ss.hasPermi('system:wages:sendWagesByIds')")
    @PostMapping("/sendWagesByIds/{ids}")
    public AjaxResult sendWagesByIds(@PathVariable Long[] ids)
    {
        wagesService.sendWagesByIds(Arrays.asList(ids));
        return AjaxResult.success("工资发放成功");
    }


}

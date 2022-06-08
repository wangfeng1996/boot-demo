package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.TraceBack;

import java.util.List;

/**
 * @author wf
 * @date 2022/4/18 09:45
 * @description
 */
public interface TraceBackService extends IService<TraceBack> {
    /**
     * 查询单号
     *
     * @param sheetId
     * @return
     */
    List<TraceBack> getSheetId(String sheetId);


}

package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.TraceBackMapper;
import com.example.pojo.TraceBack;
import com.example.service.TraceBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wf
 * @date 2022/4/18 09:45
 * @description
 */
@Service
public class TraceBackServiceimpl extends ServiceImpl<TraceBackMapper, TraceBack> implements TraceBackService {

    @Autowired
    private TraceBackMapper traceBackMapper;

    @Override
    public List<TraceBack> getSheetId(String sheetId) {
        List<TraceBack> backList = traceBackMapper.selectList(null);
        TraceBack traceBack = traceBackMapper.selectById(sheetId);
        List<TraceBack> childList = null;
        List<TraceBack> parentList = new ArrayList<>();

        if (traceBack.getRootId() == 0) {
            childList = getChildList(backList, traceBack.getId());

        } else {
            childList = getChildList(backList, traceBack.getId());
            getParentList(backList, traceBack.getId(), parentList);
        }
        childList.add(traceBack);
        return childList;
    }

    /**
     * 获取所有的父节点
     *
     * @param backList
     * @param id
     * @return
     */
    private List<TraceBack> getParentList(List<TraceBack> backList, Integer id, List<TraceBack> list) {
        TraceBack traceBack = backList.stream().filter(s -> s.getId().equals(id)).findFirst().get();
        list.add(traceBack);
        if (traceBack.getParentId() != 0) {
            getParentList(backList, traceBack.getParentId(), list);
        }
        return list;

    }

    /**
     * 获取所有的子节点
     *
     * @param backList
     * @param pid
     * @return
     */
    private List<TraceBack> getChildList(List<TraceBack> backList, Integer pid) {
        List<TraceBack> result = new ArrayList<>();
        for (TraceBack track : backList) {
            //获取菜单的id
            //遍历出父id等于参数的id，add进子节点集合
            if (track.getParentId().equals(pid)) {
                //递归遍历下一级
                getChildList(backList, track.getId());
                result.add(track);
            }
        }
        return result;
    }
}


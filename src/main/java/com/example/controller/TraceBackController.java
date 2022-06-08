package com.example.controller;

import com.example.pojo.TraceBack;
import com.example.service.TraceBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wf
 * @date 2022/5/27 10:28
 * @description
 */
@RestController
@RequestMapping("/trace")
public class TraceBackController {
    @Autowired
    private TraceBackService traceBackService;

    @GetMapping
    public List<TraceBack> getSheetId(@RequestParam String sheetId) {

        return traceBackService.getSheetId(sheetId);

    }


}

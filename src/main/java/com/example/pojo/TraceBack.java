package com.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author wf
 * @date 2022/5/27 10:24
 * @description
 */
@Data
@TableName("trace_back")
public class TraceBack {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String sheetId;
    private Integer sheetType;
    private Integer parentId;
    private Integer rootId;
}

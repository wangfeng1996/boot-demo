package com.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * @author wf
 * @date 2022/4/18 09:34
 * @description
 */
@Data
@TableName("tb_user")
@Accessors(chain = true)
public class User implements Serializable {
    private static final long serialVersionUID = -749670099270787896L;
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @Excel(name = "序号", width = 15)
    private String id;
    @Excel(name = "姓名", width = 15)
    private String userName;
    @Excel(name = "地址", width = 15)
    private String address;
}

package com.tdh.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "user")
public class User {


    /**
     * id自增处理
     */
    @TableId(type = IdType.AUTO)
    private  Integer id;

    private String name;

    private Integer age;

    private String email;

    private Integer sex;

    private Date createTime;

    private Date updateTime;

    /**
     * 逻辑删除的处理
     */
    @TableLogic
    private Integer deleted;
}

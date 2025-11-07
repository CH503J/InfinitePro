package com.infinitepro.common.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * BaseIdEntity
 * <p>
 * 所有带主键ID的实体基类，继承 BaseEntity
 */
@Data
@Accessors(chain = true)
public class BaseIdEntity extends BaseEntity {

    public static final String ID = "id"; // id字段常量

    /**
     * 主键ID，使用 MyBatis-Plus 雪花算法生成
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 可选批量操作使用的ID列表（非数据库字段）
     */
    @TableField(exist = false)
    private List<String> ids;
}

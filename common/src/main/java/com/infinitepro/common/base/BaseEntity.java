package com.infinitepro.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * BaseEntity
 * <p>
 * 所有实体的基类，包含公共字段：
 * - 创建人、创建时间
 * - 更新人、更新时间
 * - 删除标志
 * <p>
 */
//MGZ TODO 2025/11/6:后期可以考虑做一个 MetaObjectHandler 减少更新时间、更新人之类的set代码了，这个是MyBatisPlus提供的配置类，如需配置可以在config包下进行配置
@Data
@Accessors(chain = true)
public class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final String CREATE_BY = "create_by";
    public static final String CREATE_TIME = "create_time";
    public static final String UPDATE_BY = "update_by";
    public static final String UPDATE_TIME = "update_time";
    public static final String IS_DELETE = "is_delete";

    /**
     * 创建人
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    // 这里已经设置了全局的Jackson序列化和反序列化的配置，所以这里就不需要配置了
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private String updateBy;

    /**
     * 更新时间
     */
    // 这里已经设置了全局的Jackson序列化和反序列化的配置，所以这里就不需要配置了
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 逻辑删除标志
     */
    @TableField(value = "is_delete")
    @TableLogic
    private Boolean isDelete;
}

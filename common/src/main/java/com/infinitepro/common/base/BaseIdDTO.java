package com.infinitepro.common.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * BaseIdDTO
 * <p>
 * 所有带主键 ID 的 DTO 基类，继承 BaseDTO
 */
@Data
@Accessors(chain = true)
public class BaseIdDTO extends BaseDTO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键 ID
     */
    private String id;

    /**
     * 批量操作使用的 ID 列表
     */
    private List<String> ids;
}

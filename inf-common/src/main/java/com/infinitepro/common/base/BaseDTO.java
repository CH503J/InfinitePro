package com.infinitepro.common.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * BaseDTO
 * <p>
 * 所有 DTO 的基类，包含公共字段
 */
@Data
@Accessors(chain = true)
public class BaseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // 如果需要，可以加一些公共字段，如分页参数等
}

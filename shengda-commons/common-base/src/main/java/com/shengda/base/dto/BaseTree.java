package com.shengda.base.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author takesi
 * @date 2020-03-24
 */
@Data
public class BaseTree<E, ID> implements Serializable {

    private static final long serialVersionUID = 4007099337571943957L;

    /**
     * ID
     */
    private ID id;

    /**
     * 父ID
     */
    private ID pid;

    /**
     * 是否含有子节点
     */
    private boolean hasChild = false;

    /**
     * 子节点集合
     */
    private List<E> children;

}

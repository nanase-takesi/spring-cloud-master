package com.shengda.zk.registry.base;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2020-03-25
 */
@Data
@AllArgsConstructor
public class RegisterDto implements Serializable {

    private static final long serialVersionUID = 2326898449065228508L;

    private String app;

    private String host;

    private CoordinatorRegistryCenter coordinatorRegistryCenter;

}

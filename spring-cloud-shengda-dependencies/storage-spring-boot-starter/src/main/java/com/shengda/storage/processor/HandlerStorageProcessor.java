package com.shengda.storage.processor;

import cn.hutool.core.lang.ClassScanner;
import com.google.common.collect.Maps;
import com.shengda.storage.annotation.HandlerStorageType;
import com.shengda.storage.enums.BucketType;
import com.shengda.storage.handler.AbstractStorageHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author takesi
 * @date 2020-03-27
 */
@Component
public class HandlerStorageProcessor implements BeanFactoryPostProcessor {

    private static final String HANDLER_PACKAGE = "com.shengda.storage.handler";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<BucketType, Class> handlerMap = Maps.newHashMapWithExpectedSize(3);
        ClassScanner.scanPackageByAnnotation(HANDLER_PACKAGE, HandlerStorageType.class).forEach(clazz -> {
            BucketType type = clazz.getAnnotation(HandlerStorageType.class).value();
            handlerMap.put(type, clazz);
        });
        HandlerContext handlerContext = new HandlerContext(handlerMap);
        beanFactory.registerSingleton(HandlerStorageType.class.getName(), handlerContext);
    }

    public static class HandlerContext {

        private Map<BucketType, Class> handlerMap;

        public HandlerContext(Map<BucketType, Class> handlerMap) {
            this.handlerMap = handlerMap;
        }

        public AbstractStorageHandler getInstance(BucketType type) {
            Class clazz = this.handlerMap.get(type);
            if (clazz != null) {
                // return BeanTool.getBean(clazz);
                return null;
            }
            throw new IllegalArgumentException("not fount handler for type: " + type.name());
        }
    }

}

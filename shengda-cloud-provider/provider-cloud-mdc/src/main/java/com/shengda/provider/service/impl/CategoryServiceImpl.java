package com.shengda.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shengda.provider.mapper.CategoryMapper;
import com.shengda.provider.model.domain.Category;
import com.shengda.provider.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * @author takesi
 * @date 2020-03-19
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}

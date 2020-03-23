package com.shengda.dto;

import com.shengda.annotation.Storage;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author takesi
 * @date 2020-03-20
 */
@Data
public class BrandDto implements Serializable {

    private static final long serialVersionUID = 7980897422340442008L;

    /**
     * 名称
     */
    @NotBlank
    @Length(min = 1, max = 64)
    private String name;

    /**
     * 首字母
     */
    @Length(max = 8)
    private String firstLetter;

    /**
     * 品牌logo
     */
    @Storage
    @NotBlank
    @Length(min = 1, max = 100)
    private String logo;

    /**
     * 大图专区
     */
    @Storage
    @Length(max = 100)
    private String bigPicture;

    /**
     * 排序
     */
    @Min(0)
    @NotNull
    private Integer sort;

    /**
     * 是否为品牌制造商：0->不是；1->是
     */
    @NotNull
    private Boolean isFactory;

    /**
     * 品牌故事
     */
    private String story;

    /**
     * 状态
     */
    @NotNull
    private Boolean state;

}

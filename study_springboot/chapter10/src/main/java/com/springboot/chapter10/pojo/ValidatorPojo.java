package com.springboot.chapter10.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author: jianglei
 * @date: 2020/1/30 14:25
 */
@Data
public class ValidatorPojo {
    @NotNull(message = "id不能为空")
    private Long id;

    //表示将来日期
    @Future(message = "需要一个将来日期")
    //@Past 表示过去日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date date;

    @NotNull
    @DecimalMin(value = "0.1")
    @DecimalMax(value = "10000.00")
    private Double doubleValue;

    @Min(value = 1, message = "最小值为1")
    @Max(value = 88, message = "最大值为88")
    @NotNull
    private Integer integer;

    @Range(min = 1, max = 888, message = "范围为1到888")
    private Long range;

    @Email(message = "邮箱格式错误")
    private String mail;

    @Size(min = 20, max = 30, message = "字符串长度要求20到30之间")
    private String size;
}

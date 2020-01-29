package com.springboot.chapter10.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: jianglei
 * @date: 2020/1/29 21:57
 */
@Controller
@RequestMapping("/my")
public class MyController {
    @GetMapping("/no/annotation")
    @ResponseBody
    public Map<String, Object> noAnnotation(Integer intVal, Long longVal, String str) {
        Map<String, Object> paramsMap = new HashMap<>(3);
        paramsMap.put("intVal", intVal);
        paramsMap.put("longVal", longVal);
        paramsMap.put("str", str);
        return paramsMap;
    }

    @GetMapping("/annotation")
    @ResponseBody
    public Map<String, Object> requestParam(
            @RequestParam("int_val") Integer intVal,
            @RequestParam("long_val") Long longVal,
            @RequestParam("str_val") String strVal) {
        Map<String, Object> paramMap = new HashMap<>(3);
        paramMap.put("intVal", intVal);
        paramMap.put("longVal", longVal);
        paramMap.put("strVal", strVal);
        return paramMap;
    }

    @GetMapping("/requestArray")
    @ResponseBody
    public Map<String, Object> requestArray(Integer[] intArr, Long[] longArr, String[] strArr) {
        Map<String, Object> paramsMap = new HashMap<>(3);
        paramsMap.put("intArr", intArr);
        paramsMap.put("longArr", longArr);
        paramsMap.put("strArr", strArr);
        return paramsMap;
    }

    @GetMapping("/format/form")
    public String showFormat() {
        return "format/formatter";
    }

    @PostMapping("/format/commit")
    @ResponseBody
    public Map<String, Object> format(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
            @NumberFormat(pattern = "#,###,###.##",style = NumberFormat.Style.CURRENCY) Double number) {
        Map<String, Object> dataMap = new HashMap<>(2);
        dataMap.put("date", date);
        dataMap.put("number", number);
        return dataMap;
    }
}

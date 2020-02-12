package com.springboot.chapter10.controller.advice;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: jianglei
 * @date: 2020/1/30 23:39
 */
@ControllerAdvice(
        basePackages = {"com.springboot.chapter10.controller.advice.test.*"},
        annotations = Controller.class)
public class MyControllerAdvice {
    @InitBinder
    public void initDataBinder(WebDataBinder binder) {
        CustomDateEditor dateEditor =
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false);
        binder.registerCustomEditor(Date.class, dateEditor);
    }

    @ModelAttribute
    public void projectModel(Model model) {
        model.addAttribute("project_name", "chapter10");
    }

    @ExceptionHandler(value = Exception.class)
    public String exception(Model model, Exception ex) {
        model.addAttribute("exception_message", ex.getMessage());
        return "exception";
    }
}

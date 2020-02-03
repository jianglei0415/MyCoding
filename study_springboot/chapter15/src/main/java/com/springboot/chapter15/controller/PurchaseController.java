package com.springboot.chapter15.controller;

import com.springboot.chapter15.service.PurchaseService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: jianglei
 * @date: 2020/2/2 23:17
 */
@RestController
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/test")
    public ModelAndView testPage() {
        ModelAndView mv = new ModelAndView("test");
        return mv;
    }

    @PostMapping("/purchase")
    public Result purchase(Long userId, Long productId, Integer quantity) {
        boolean success = purchaseService.purchase(userId, productId, quantity);
        String message = success ? "抢购成功" : "抢购失败";
        Result result = new Result(success, message);
        return result;
    }


    class Result {
        @Getter
        @Setter
        private boolean success;
        @Getter
        @Setter
        private String message;

        public Result() {
        }

        public Result(boolean success, String message) {
            this.success = success;
            this.message = message;
        }
    }
}

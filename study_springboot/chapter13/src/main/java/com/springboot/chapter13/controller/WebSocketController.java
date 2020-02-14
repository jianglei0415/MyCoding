package com.springboot.chapter13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * @author: jianglei
 * @date: 2020/2/1 23:23
 */
@Controller
@RequestMapping("/websocket")
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping("/index")
    public String websocket() {
        return "websocket";
    }

    @GetMapping("/send")
    public String send() {
        return "send";
    }

    @GetMapping("/receive")
    public String receive() {
        return "receive";
    }

    @GetMapping("/sendUser")
    public String sendUser() {
        return "send-user";
    }

    @GetMapping("/receiveUser")
    public String receiveUser() {
        return "receive-user";
    }

    @MessageMapping("/send")
    @SendTo("/sub/chat")
    public String sendMsg(String value) {
        return value;
    }

    @MessageMapping("/sendUser")
    public void sendToUser(Principal principal, String body) {
        String srcUser = principal.getName();
        String[] args = body.split(",");
        String desUser = args[0];
        String message = "【" + srcUser + "】给你发来消息：" + args[1];
        simpMessagingTemplate.convertAndSendToUser(desUser, "/queue/customer", message);
    }
}

package com.example.bankdeposit.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Здесь можно вернуть страницу с сообщением об ошибке 404 или перенаправить на другую страницу
        return "error";
    }

    // Метод getErrorPath необходим для получения пути к странице ошибки
    public String getErrorPath() {
        return "/error";
    }
}

package com.example.bankdeposit.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        // Можно добавить данные в модель, которые будут переданы в HTML-шаблон
        model.addAttribute("pageTitle", "Домашняя страница");
        return "index"; // Возвращает имя HTML-файла без расширения
    }

    @GetMapping("/clients")
    public String clients() {
        return "clients"; // Возвращает имя HTML-файла без расширения
    }
}

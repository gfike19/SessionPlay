package com.gfike.SessionPlay;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("SessionPlay")
public class MainController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "SessionPlay/index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String indexPost (HttpServletRequest request, Model model) {
        String sumText = request.getParameter("sumText");
        model.addAttribute("words", sumText);
        return "redirect:";
    }

    @RequestMapping(value = "error")
    public String error() {
        return "error";
    }
}

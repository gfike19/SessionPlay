package com.gfike.SessionPlay;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
//@RequestMapping("SessionPlay")
public class MainController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, HttpSession session)
    {
        ArrayList<String> words = null;
        if (session.getAttribute("words") == null) {
            // where words is just a string
            //String words = session.getAttribute("words").toString();
            words = new ArrayList<String>();
        }
        else {
            words = (ArrayList<String>) session.getAttribute("words");
        }
        session.setAttribute("words", words);
        model.addAttribute("words", words);
        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String indexPost (HttpServletRequest request, Model model, HttpSession session) {
        String sumText = request.getParameter("sumText");
        ArrayList<String> words = (ArrayList<String>) session.getAttribute("words");
        words.add(sumText);
        // where words is just a string
//        session.setAttribute("words", sumText);
//
        model.addAttribute("words", words);
        return "redirect:";
    }

}

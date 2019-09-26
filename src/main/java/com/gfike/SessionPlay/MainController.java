package com.gfike.SessionPlay;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Random;

@Controller
public class MainController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, HttpSession session)
    {
        HashMap<Integer, String> hmap;

        if(session.getAttribute("hmap") != null){
            hmap = (HashMap<Integer, String>) session.getAttribute("hmap");
        }
        else{
            hmap = new HashMap<>();
        }

        model.addAttribute("hmap", hmap);
        session.setAttribute("hmap", hmap);

        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String indexPost (HttpServletRequest request, Model model, HttpSession session) {

        Random rand = new Random();
        int r = rand.nextInt(2147483647);

        HashMap<Integer, String> hmap = (HashMap<Integer, String>) session.getAttribute("hmap");
        String word = request.getParameter("sumText");
        hmap.put(r, word);

        model.addAttribute("hmap", hmap);
        return "redirect:";
    }

}

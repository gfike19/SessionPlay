package com.gfike.SessionPlay;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Random;

@Controller
//@RequestMapping("SessionPlay")
public class MainController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, HttpSession session)
    {
        Random rand = new Random();
        int rNum = rand.nextInt(2147483647);
        model.addAttribute("rNum", rNum);

        ArrayList<String> rList;

        if (session.getAttribute("rList") == null) {
             rList = new ArrayList<>();
        }
        else{
            rList = (ArrayList<String>)session.getAttribute("rList");
        }

        model.addAttribute("rList", rList);
        session.setAttribute("rList", rList);
        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String indexPost (HttpServletRequest request, Model model, HttpSession session) {

        String rNum = request.getParameter("rNum");

        ArrayList<String> rList;

        if (session.getAttribute("rList") == null) {
            rList = new ArrayList<>();
        }
        else{
            rList = (ArrayList<String>)session.getAttribute("rList");
        }

        rList.add(rNum);

        model.addAttribute("rList", rList);
        session.setAttribute("rList", rList);
        return "redirect:";
    }

}

package com.geekbrains.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormsController {
    @RequestMapping("showSimpleForm")
    public String showSimpleForm(){return "myform";}

    @RequestMapping(path = "/advProcessForm", method = RequestMethod.GET)
    public String advProcessForm(@RequestParam("studentName") String studName, Model model){
        studName="student"+studName;
        model.addAttribute("attrStudName", studName);
        return "myform-result-adv";
    }
}

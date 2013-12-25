package com.xgs.userManager.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xgs.userManager.domain.User;

@Controller
@RequestMapping("/userManager")
public class UserController {
    @RequestMapping("/create")
    public ModelAndView create(User user, HttpServletRequest request) {

        return null;

    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public ModelAndView delete(@PathVariable String id) {

        return null;

    }
}

//package com.myDepartment.controller;
//
//
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//@Controller
//public class CustomErrorController implements ErrorController {
//
//    @RequestMapping("/error")
//    public String handleError(HttpServletRequest request, Model model) {
//        Object status = request.getAttribute("jakarta.servlet.error.status_code");
//        model.addAttribute("errorCode", (status != null) ? String.valueOf(status) : "Unknown");
//        return "templates//includes/error/error.html";
//    }
//
//   
//    public String getErrorPath() {
//        return "templates//includes/error/error.html";
//    }
//}

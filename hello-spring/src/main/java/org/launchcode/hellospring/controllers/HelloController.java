package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    //handle request at path http://localhost:8080/hello

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //handle request at path //http://localhost:8080/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //handle requests of the form http://localhost:8080/hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")

    public String helloWithQueryParam(@RequestParam String name, Model model){
        String thegreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", thegreeting);
        return "hello";
    }

    //handle requests of the form http://localhost:8080/hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        String thegreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", thegreeting);
        return "hello";
    }

    @GetMapping("form")

    public String helloForm() {
      return "form";
    }
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Andrew");
        names.add("Joy");
        names.add("Ruby");
        names.add("Elio");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
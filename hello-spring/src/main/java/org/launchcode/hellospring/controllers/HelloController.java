package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {


    //lives at /hello/goodbye
    @GetMapping("goodbye")

    public String goodbye() {
        return "GoodBye, Spring!";
    }


    //lives at hello/hello
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})

    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")

    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")

    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action ='hello' method ='post' action = '/hello'>" +//submit a reqeust to /hello
                "<input type='text' name='name'>" +
                "<select name='language' id ='language-select'> <option value='english'>English</option>\n" +
                "                <option value='french'>French</option>\n" +
                "                <option value='spanish'>Spanish</option>\n" +
                "                <option value='swahili'>Swahili</option>\n" +
                "                <option value='german'>German</option>\n" +
                "                </select>"
                +

                "<input type='submit' value='Greet me!'" +
                "</form>" +
                "</body>" +
                "</html>";

    }
    @RequestMapping(value="hell0/form", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);

        // For a bonus mission, students can change this response text to look nicer.
        // This is subjective, but students should be modifying the HTML of the response string.
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour";
        }
        else if (l.equals("spanish")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("swahili")) {
            greeting = "Hola";
        }
        else if (l.equals("german")) {
            greeting = "Hallo";
        }

        return greeting + " " + n;
    }

}
//    @RequestMapping(method = RequestMethod.POST)
//        public static String createMessage (String name, String language) {
//        if () {
//            return "Hello" + name;
//        } ;
//        else{
//            return "Try Again!";
//        }
//    }
//   }


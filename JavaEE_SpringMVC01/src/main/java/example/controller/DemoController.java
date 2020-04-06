
package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class DemoController {

    @RequestMapping("/say")
    public String index(){
        return "say";
    }
}

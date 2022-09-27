package br.com.forum.forum.atualizado.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    @RequestMapping("/")
    public String hello(){
        return "helo word, spring atualizado 2.0";
    }

}

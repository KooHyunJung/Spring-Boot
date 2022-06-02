package spring.spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Spring!!");
        return "hello!!";
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
//    (value = "name", required = false) 이렇게 작성하면 내용을 안 넘겨도 서버에러가 나지 않지만
//    URL 넘길 때 HTTP GET 방식으로 파라미터 넘기기
//    locallhost:8080/hello-mvc?name=spring

    @GetMapping("hello-api")
    @ResponseBody
    public String helloApi(@RequestParam("name") String name) {
        return "hello api " + name;
    }
//    @ResponseBody
//    HTTP body 부분에 내용을 직접 넣어주겠다는 것
//    MVC와 다른 점은 view(template) 없이 바로 데이터를 내려 준다는 것이다

    @GetMapping("hello-api2")
    @ResponseBody
    public Hello helloApi2(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 문자가 아닌 객체 넘기기. hello-api 와 다르게 hello-api2에서는 json 방식으로 데이터를 내려준다
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

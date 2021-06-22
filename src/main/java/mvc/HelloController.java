package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public ModelAndView hello( @RequestParam(value="num1") String num1,
                        @RequestParam(value="num2") String num2, @RequestParam(value="op") String op) {
        double result=0;
        int a=Integer.valueOf(num1);
        int b=Integer.valueOf(num2);
//        Calculator calc = new Calculator();
        if(op.equals("+")){
            result = a+b;
        }
        else if(op.equals("*")){
            result = a*b;
        }
        else if(op.equals("-")){
            result =a-b;
        }
        else if(op.equals("/")){
            result = a/b;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("num1", num1);
        params.put("num2", num2);
        params.put("op", op);
        params.put("result", result);

        return new ModelAndView("hello",params);
    }
}


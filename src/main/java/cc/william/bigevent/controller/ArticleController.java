package cc.william.bigevent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.william.bigevent.pojo.rest.Result;
import cc.william.bigevent.util.JwtUtil;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    

    @GetMapping("/list")
    public Result<String> list(@RequestHeader(name = "Authorization") String token) {


        return Result.success("234");
    }

}

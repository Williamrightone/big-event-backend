package cc.william.bigevent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.william.bigevent.pojo.rest.Result;

@RestController
@RequestMapping("/article")
public class ArticleController {
    

@GetMapping("/list")
public Result list() {
    
    return Result.success();    
    }

}

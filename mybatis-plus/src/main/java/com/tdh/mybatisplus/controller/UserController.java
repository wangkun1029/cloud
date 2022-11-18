package com.tdh.mybatisplus.controller;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tdh.mybatisplus.config.R;
import com.tdh.mybatisplus.dto.UserQueryVo;
import com.tdh.mybatisplus.entity.User;
import com.tdh.mybatisplus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
@CrossOrigin
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public R<List<User>> list() {
        List<User> list = userService.list();
        return R.ok(list);
    }


    @PostMapping(value = "/listPage/{current}/{limit}")
    public R<Page<User>> listPage(@RequestParam("current") long current,
                                  @RequestParam ("limit") long limit,
                                  @RequestBody(required = false) UserQueryVo userQueryVo ) {
        Page<User> producePage = new Page<>(current,limit);
        Page<User> page = new LambdaQueryChainWrapper<>(userService.getBaseMapper())
                .page(producePage);
        return R.ok(page);
    }


    @GetMapping(value = "/deleted/{id}")
    public R<List<User>> deleted(@PathVariable("id") long id) {

        return R.ok();
    }

}

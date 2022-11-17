package com.tdh.mybatisplus.controller;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tdh.mybatisplus.config.R;
import com.tdh.mybatisplus.entity.User;
import com.tdh.mybatisplus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public R<List<User>> list() {
        List<User> list = userService.list();
        return R.ok(list);
    }


    @GetMapping(value = "/listPage")
    public R<Page<User>> listPage() {
        Page<User> producePage = new Page<>(1,2);
        Page<User> page = new LambdaQueryChainWrapper<>(userService.getBaseMapper())
                .page(producePage);
        return R.ok(page);
    }


}

package com.tdh.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tdh.mybatisplus.entity.User;
import com.tdh.mybatisplus.mapper.UserMapper;
import com.tdh.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

package com.tdh.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tdh.mybatisplus.entity.User;
import com.tdh.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserMapperTest {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    public void  findAll(){

       List<User>  list = userMapper.selectList(null);
        System.out.println("list = " + list);

    }


    @Test
    public void  add(){
       User user = new User();
       user.setAge(19);
       user.setEmail("18772115070@163.com");
       user.setName("坤哥22");
       userMapper.insert(user);

    }

    @Test
    public void  update(){
      User user = userMapper.selectById(1);
      user.setAge(23);
      userMapper.updateById(user);
    }


    /**
     * 分页查询
     */
    @Test
    public void  findPage(){
        Page<User> page = new Page<>(1,3);
        Page<User> pageList = userMapper.selectPage(page,null);
        System.out.println("pageList = " + pageList);
        List<User> list  = pageList.getRecords();
        System.out.println("list = " + list);

    }

    @Test
    public void  selectList(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //年纪筛选
//        queryWrapper.ge("age",20);
        //模糊查询
//        queryWrapper.like("name","kun");
        //排序
        queryWrapper.orderByDesc("id");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println("list = " + list);

    }

    @Test
    public void  selectLambdaList(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //排序
       lambdaQueryWrapper.ge(User::getAge,18);
        List<User> list = userMapper.selectList(lambdaQueryWrapper);
        System.out.println("list = " + list);

    }


    @Test
    public void  deleted(){
      userMapper.deleteById(1);
    }

    @Test
    public void list(){
      List<User> list =   userService.list();
        System.out.println("list = " + list);
    }


}
package com.SA.service;

import com.SA.dao.userMapper;
import com.SA.pojo.Result;
import com.SA.pojo.admin;
import com.SA.pojo.user;
import com.SA.pojo.vipUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class userService {
    @Autowired
    private userMapper userMapper;


    public int addUser(vipUser vipUser) {
        return userMapper.addUser(vipUser);
    }

    public List<vipUser> findAll() {

        return userMapper.findAllUser();
    }

    public Result<String> deleteUser(int id) {
        int hang = userMapper.deleteUser(id);
        return Result.success("已成功操作" + hang + "行数据");
    }


    public Result<String> ll(/*@Param("AdminID")*/ Integer AdminID, /*@Param("AdminPassWorld")*/ String AdminPassWorld) {
        List<admin> li = userMapper.ll(AdminID, AdminPassWorld);
        if (!li.isEmpty()) {
            return Result.success("登录成功");
        }
        return Result.fail("登陆失败");
    }


    //查找管理员用户
    public boolean findAdmin(String AdminId){
        Integer id = Integer.parseInt(AdminId);
        return userMapper.findAdmin(id) != null;
    }

    //查找用户
    public Result<user> edit(int id){

        if (userMapper.edit(id) != null){
            user user = userMapper.edit(id);
            return Result.success(user);
        }else {
            return Result.fail();
        }
    }



    public Result<Integer> allVipMount() {
        int mount = userMapper.allVipMount();
        return Result.success(mount);
    }
}

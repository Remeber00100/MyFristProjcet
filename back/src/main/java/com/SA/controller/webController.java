package com.SA.controller;

import com.SA.pojo.Result;
import com.SA.pojo.user;
import com.SA.pojo.vipUser;
import com.SA.service.userService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class webController {

    @Autowired
    private userService UserService;

    @PostMapping("/findAll")
    public Result<List> find() {
        return Result.success(UserService.findAll());
    }

    @PostMapping("/add")
    public Result<String> add(@RequestBody vipUser i) {
        int uu = UserService.addUser(i);
        return Result.success(String.valueOf(uu));
    }

    @DeleteMapping("/delete")
    public Result<String> delete(@RequestParam int id) {
        return UserService.deleteUser(id);
    }

    @PostMapping("/login")
    public Result<String> login(@RequestParam("AdminID") Integer adminID, @RequestParam("AdminPassWorld") String adminPassWorld, HttpServletResponse response) {
        return UserService.ll(adminID, adminPassWorld);
    }

    @GetMapping("/edit")
    public Result<user> edit(@RequestParam int id){
        return UserService.edit(id);
    }


    @GetMapping("/allVipMount")
    public Result<Integer> allVipMount(){
        return UserService.allVipMount();
    }
}

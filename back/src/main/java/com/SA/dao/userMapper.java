package com.SA.dao;

import com.SA.pojo.Result;
import com.SA.pojo.admin;
import com.SA.pojo.user;
import com.SA.pojo.vipUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface userMapper {
    //    @Select("select * from users")
    List<vipUser> findAllUser();


    //    @Insert("INSERT INTO `user`.`users` (`name`, `account`, `passworld`) VALUES (#{name}, #{account}, #{passworld});")
    int addUser(vipUser vipUser);

    //    @Delete("DELETE FROM `user`.`users` WHERE (`id` = #{id});")
    int deleteUser(int id);

    //    @Select("select * from `user`.`users` where AdminID = #{AdminID} and passworld = #{passworld}")
    List<admin> ll(@Param("AdminID") Integer AdminID, @Param("AdminPassWorld") String AdminPassWord);

    //查找管理员
    String findAdmin(Integer AdminID);


    //查找用户
    user edit(int id);


    int allVipMount();
}

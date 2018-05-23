package com.sx.annocation;

import com.sx.po.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    @Select("select * from user where id = #{id}")
    public User selectUserById(int id)throws Exception;

    @Insert("insert into user(username,sex,birthday,address) value(#{username},#{sex},#{birthday},#{address})")
    public void insertUser(User user)throws Exception;

    @Update("update user set username=#{username},sex=#{sex} where id=#{id}")
    public void updateUserById(User user)throws Exception;

    @Delete("delete from user where id=#{id}")
    public void delectUserById(int id)throws Exception;
}

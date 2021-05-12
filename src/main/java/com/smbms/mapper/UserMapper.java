package com.smbms.mapper;
import com.smbms.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface  UserMapper{
    List<User> getList();//全查询
    User getByid(@Param("id") Integer id);
    int addUser(User user);//添加
    int delUser(int id);//删除
    User login(@Param("userCode") String userCode,
               @Param("userPassword") String userPassword);
    User getByPassword(@Param("oldPassword") String oldPassword);
    Integer Mpdifypwd(@Param("rnewpassword") String rnewpassword, @Param("id") Integer id);
    User getByUserCode(@Param("userCode") String userCode);
    // 首先先查询总条数
    Integer  sumCount(@Param("userName") String userName,
                      @Param("RoleId") Integer RoleId);

    //然后按照limit分页查询
    List<Object> PageSize(@Param("userName") String UserName,
                          @Param("RoleId") Integer RoleId,
                          @Param("beginPage") Integer beginPage,
                          @Param("pageSize") Integer pageSize);

    Integer delectUser(@Param("userid") String userid);

    Integer modify(@Param("user") User user);
}

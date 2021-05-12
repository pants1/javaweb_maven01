package com.smbms.service;
import com.smbms.entity.Role;
import com.smbms.entity.User;
import com.smbms.until.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface userMapperService {
    List<User> getList();//全查询
    User getByid(Integer id);
    User getByuserCodeAnduserPassword(String userCode, String userPassword);
    User getBypasword(String oldPassword);
    Integer pswModify(String rnewpassword, Integer id);
    List<Role> getRoles();
    int addUser(User user);//添加
    User getByuserCode(String userCode);

    Page PageSize(String UserCode,
                  Integer RoleId,
                  Integer currPageNo,
                  Integer pageSize);


    Integer delectUser(String userid);

    Integer modify(User user);
}

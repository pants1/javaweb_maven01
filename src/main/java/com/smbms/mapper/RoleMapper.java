package com.smbms.mapper;

import com.smbms.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    Integer addRole(@Param("role") Role role);
    List<Role> getroles();
}

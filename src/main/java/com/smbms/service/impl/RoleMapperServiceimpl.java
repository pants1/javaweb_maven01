package com.smbms.service.impl;

import com.smbms.entity.Role;
import com.smbms.mapper.RoleMapper;
import com.smbms.service.RoleMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleMapperServiceimpl  implements RoleMapperService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public List<Role> getroles() {
        return roleMapper.getroles();
    }
}

package com.smbms.service.impl;

import com.smbms.entity.Provider;
import com.smbms.mapper.ProviderMapper;
import com.smbms.service.ProviderMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProviderMapperServiceimpl  implements ProviderMapperService {
    @Autowired
    ProviderMapper providerMapper;
    @Override
    public List<Provider> getList(){
        return providerMapper.getList();
    }

    @Override
    public Integer addProvider(Provider provider) {
        return providerMapper.addProvider(provider);
    }
    @Override
    public Provider queryBid(Integer id){
        return providerMapper.queryBid(id);
    }
    @Override
    public Provider getBYCode(String code) {
        return providerMapper.getBYCode(code);
    }
}

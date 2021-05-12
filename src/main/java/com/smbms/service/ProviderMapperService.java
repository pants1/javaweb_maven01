package com.smbms.service;

import com.smbms.entity.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderMapperService {
    List<Provider> getList();
    Integer addProvider(Provider provider);
    Provider queryBid(Integer id);
    Provider  getBYCode(String code);
}

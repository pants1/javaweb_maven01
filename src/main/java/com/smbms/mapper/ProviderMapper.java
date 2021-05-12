package com.smbms.mapper;

import com.smbms.entity.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderMapper {
    List<Provider> getList();
    Integer addProvider(Provider provider);
    Provider queryBid(@Param("id") Integer id);
    Provider  getBYCode(@Param("code") String code);

}

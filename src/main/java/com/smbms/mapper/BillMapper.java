package com.smbms.mapper;
import com.smbms.entity.Bill;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BillMapper {
    List<Bill> getList(Bill bill);
}

package com.joinutech.storage.mapper;

import com.joinutech.storage.entity.Supplier;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
/**
 * 供应商类
 * 
 * @author wangjw
 * @date 2021-07-06T10:30:35.737
 */
@Mapper
@Repository
public interface SupplierMapper extends BaseMapper<Supplier>  {

}

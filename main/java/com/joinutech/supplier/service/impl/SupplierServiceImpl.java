package com.joinutech.storage.service.impl;

import org.springframework.stereotype.Service;
import com.joinutech.storage.entity.Supplier;
import com.joinutech.storage.mapper.SupplierMapper;
import com.joinutech.storage.service.SupplierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper,Supplier> implements
    SupplierService {
}

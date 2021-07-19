package com.joinutech.storage.controller;

import com.joinutech.storage.entity.Supplier;
import com.joinutech.storage.service.SupplierService;
import com.joinutech.eshop.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joinutech.eshop.common.feign.IdServiceFeign;

/**
 * 供应商类
 *
 * @author wangjw
 * @date 2021-07-06T10:30:35.737
 */
@RestController
@RequestMapping("supplier")
@Api(tags = "Supplier相关接口")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private IdServiceFeign idServiceFeign;

    /**
     * 分页查询
     */
    @GetMapping("/list/{page}/{size}")
    @ApiOperation("分页查询")
    public Result list(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        IPage<Supplier> supplierPage = supplierService.page(new Page<Supplier>(page, size), new
            QueryWrapper<>());
        return Result.success(supplierPage);
    }

    /**
     * 根据id查找
     */
    @GetMapping("/info/{id}")
    @ApiOperation("根据id查找")
    public Result info(@PathVariable("id") String id){
        Supplier supplierInfo = supplierService.getById(id);
        return Result.success(supplierInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("保存")
    public Result save(@RequestBody Supplier supplier){
        long currentTimeMillis = System.currentTimeMillis();
        supplier.setCreateTime(currentTimeMillis);
        supplier.setUpdateTime(currentTimeMillis);
        supplier.setId(idServiceFeign.getId());
		supplierService.save(supplier);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation("修改")
    public Result update(@RequestBody Supplier supplier){
        long currentTimeMillis = System.currentTimeMillis();
        supplier.setUpdateTime(currentTimeMillis);
		supplierService.updateById(supplier);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    public Result delete(@PathVariable("id") String  id){
			supplierService.removeById(id);
        return Result.success();
    }

}

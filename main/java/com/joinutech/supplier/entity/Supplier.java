package com.joinutech.storage.entity;

import lombok.Data;
import lombok.Builder;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 供应商类
 *
 * @author wangjw
 * @date 2021-07-06T10:30:35.737
 */

@Data
@Builder
@ApiModel("供应商类实体类}")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;


			@ApiModelProperty(value = "供应商id")
	private String id;

		@ApiModelProperty(value = "供应商名称")
	private String supplierName;

		@ApiModelProperty(value = "供应商简称")
	private String supplierAlias;

		@ApiModelProperty(value = "供应商地址")
	private String supplierAddress;

		@ApiModelProperty(value = "经营方式：1 购销、2 联营、3 成本代销、4 租赁 、5 扣率代销；")
	private Integer businessWay;

		@ApiModelProperty(value = "结算方式：1 临时指定、2 指定账期、3 N天一结，当excel导入为空时，默认临时指定；")
	private Integer settlementWay;

		@ApiModelProperty(value = "联系人")
	private String contact;

		@ApiModelProperty(value = "手机号")
	private String mobile;

		@ApiModelProperty(value = "固定电话")
	private String telephone;

		@ApiModelProperty(value = "邮箱")
	private String email;

		@ApiModelProperty(value = "状态：1 正常、2 冻结业务、3 冻结账款、4 停用，当excel导入为空时，默认正常.")
	private Integer status;

		@ApiModelProperty(value = "营业执照")
	private String businessLicense;

		@ApiModelProperty(value = "食品生产，经营许可证")
	private String license;

		@ApiModelProperty(value = "检测报告")
	private String detectionReport;

		@ApiModelProperty(value = "代理证明")
	private String agentProve;

		@ApiModelProperty(value = "报关单")
	private String declareBill;

		@ApiModelProperty(value = "卫检单")
	private String healtehInspectionBill;

		@ApiModelProperty(value = "厂家宣传资料")
	private String supplierMaterials;

		@ApiModelProperty(value = "创建时间")
	private Long createTime;

		@ApiModelProperty(value = "更新时间")
	private Long updateTime;

		@ApiModelProperty(value = "逻辑删除：0，不删除；1，删除")
	private Integer isDelete;

}

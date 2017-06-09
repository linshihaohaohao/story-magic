package org.yoqu.common.entity.rule;

import org.hsweb.web.bean.po.GenericPo;

import java.util.Date;

/**
 * Created by Kai on 2017/6/9.
 *
 * @Email zack.zhong@qq.com
 */
public class BaseRulePo extends GenericPo<String> {

	private String createBy;

	private Date createDate;

	private String updateBy;

	private Date updateDate;

	private Boolean deleteFlag;

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Boolean getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public interface Property extends GenericPo.Property{

		String createBy = "createBy";

		String createDate = "createDate";

		String updateBy = "updateBy";

		String updateDate = "updateDate";

		String deleteFlag = "deleteFlag";
	}
}

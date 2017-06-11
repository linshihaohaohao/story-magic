package org.yoqu.story.dao.service.impl;

import org.hsweb.web.bean.po.GenericPo;
import org.hsweb.web.bean.po.user.User;
import org.hsweb.web.core.utils.WebUtil;
import org.hsweb.web.service.impl.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.yoqu.common.entity.rule.BaseRulePo;
import org.yoqu.story.dao.mappers.BaseMapper;
import org.yoqu.story.dao.service.BaseService;

import java.util.Date;

/**
 * Created by Kai on 2017/6/9.
 *
 * @Email zack.zhong@qq.com
 */
//@Service
public class BaseServiceImpl<T extends BaseRulePo,M extends BaseMapper> extends AbstractServiceImpl<T, String> implements BaseService<T,M> {

	@Autowired
	private M m;

	@Override
	protected BaseMapper<T> getMapper(){
		return m;
	}

	@Override
	public int saveOrUpdate(T t){
		User user = WebUtil.getLoginUser();
		T  old = selectByPk(t.getId());
		if (null != old){
			t.setUpdateBy(user.getUsername());
			t.setUpdateDate(new Date());
			return createUpdate(t)
					.fromBean()
					.where(BaseRulePo.Property.id)
					.exec();
		}else {
			t.setCreateBy(user.getUsername());
			t.setCreateDate(new Date());
			t.setId(GenericPo.createUID());
			insert(t);
		}
		return 1;
	}

}

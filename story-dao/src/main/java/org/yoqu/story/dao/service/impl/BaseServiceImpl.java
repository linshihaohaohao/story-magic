package org.yoqu.story.dao.service.impl;

import org.hsweb.web.service.impl.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yoqu.common.entity.rule.BaseRulePo;
import org.yoqu.story.dao.mappers.BaseMapper;
import org.yoqu.story.dao.service.BaseService;

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
		T  old = selectByPk(t.getId());
		if (null != old){
			return createUpdate(t)
					.fromBean()
					.where(BaseRulePo.Property.id)
					.exec();
		}else {
			insert(t);
		}
		return 1;
	}

}

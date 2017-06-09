package org.yoqu.story.dao.service.serviceImpl;

import org.hsweb.web.bean.po.GenericPo;
import org.hsweb.web.service.impl.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.yoqu.common.entity.rule.BaseRulePo;
import org.yoqu.story.dao.mappers.BaseMapper;
import org.yoqu.story.dao.service.BaseService;

/**
 * Created by Kai on 2017/6/9.
 *
 * @Email zack.zhong@qq.com
 */

public class BaseServiceImpl<T extends GenericPo<String>> extends AbstractServiceImpl<T, String> implements BaseService<T> {

	@Autowired
	private BaseMapper<T> baseMapper;

	@Override
	protected BaseMapper<T> getMapper(){
		return baseMapper;
	}

}

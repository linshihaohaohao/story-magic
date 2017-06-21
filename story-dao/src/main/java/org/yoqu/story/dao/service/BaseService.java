package org.yoqu.story.dao.service;

import org.hsweb.web.service.GenericService;
import org.yoqu.common.entity.rule.BaseRulePo;
import org.yoqu.story.dao.mappers.BaseMapper;

/**
 * Created by Kai on 2017/6/9.
 *
 * @Email zack.zhong@qq.com
 */

public interface BaseService<T extends BaseRulePo, M extends BaseMapper> extends GenericService<T, String> {
    String save(T po);
}

package cn.wizzer.app.mt.modules.services;

import cn.wizzer.app.mt.modules.models.Mt_unit;
import cn.wizzer.framework.base.service.BaseService;

/**
 * Created by wizzer on 2016/12/22.
 */
public interface MtUnitService extends BaseService<Mt_unit> {
    /**
     * 保存单位
     *
     * @param unit
     * @param pid
     */
    void save(Mt_unit unit, String pid);

    /**
     * 级联删除单位及单位下用户
     *
     * @param unit
     */
    void deleteAndChild(Mt_unit unit);

    /**
     * 清空缓存
     */
    void clearCache();
}

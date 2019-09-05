package cn.wizzer.app.mt.modules.services.impl;

import cn.wizzer.app.sys.modules.services.SysUnitService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

import com.alibaba.dubbo.config.annotation.Service;

import cn.wizzer.app.mt.modules.models.Mt_unit;
import cn.wizzer.app.mt.modules.services.MtUnitService;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import org.nutz.plugins.wkcache.annotation.CacheDefaults;

/**
 * Created by wizzer on 2018/3/19.
 */
@IocBean(args = {"refer:dao"})
@Service(interfaceClass= MtUnitService.class)
@CacheDefaults(cacheName = "mt_unit")
public class MtUnitServiceImpl extends BaseServiceImpl<Mt_unit> implements MtUnitService {

	public MtUnitServiceImpl(Dao dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Mt_unit unit, String pid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAndChild(Mt_unit unit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearCache() {
		// TODO Auto-generated method stub
		
	}

	
   
}

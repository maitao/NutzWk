package cn.wizzer.app.mt.commons.core;

import org.nutz.boot.NbApp;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.Modules;

import cn.wizzer.app.mt.modules.services.MtUnitService;

/**
 * Created by wizzer on 2018/3/19.
 */
@IocBean(create = "init", depose = "depose")
@Modules(packages = "cn.wizzer")
public class MtMainLauncher {
    private static final Log log = Logs.get();
    @Inject
    private MtUnitService mtUnitService;
    
    @Inject("refer:$ioc")
    private Ioc ioc;
    @Inject
    private Dao dao;

    public static void main(String[] args) throws Exception {
        NbApp nb = new NbApp().setArgs(args).setPrintProcDoc(true);
        nb.getAppContext().setMainPackage("cn.wizzer");
        nb.run();
    }

    public void init() {
    	 //通过POJO类创建表结构
        try {
            Daos.createTablesInPackage(dao, "cn.wizzer.app.mt", false);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        try {
            if (log.isDebugEnabled()) {
                //通过POJO类修改表结构
                Daos.migration(dao, "cn.wizzer.app.mt", true, false);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void depose() {
      
    }
}

package com.winermin.jarslink;

import com.alipay.jarslink.api.ModuleConfig;
import com.alipay.jarslink.api.impl.AbstractModuleRefreshScheduler;
import com.google.common.collect.ImmutableList;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by liumin on 2018/4/6.
 */
public class ModuleReforeshSchedulerImpl extends AbstractModuleRefreshScheduler {


    private static final String PATH = "/Users/liumin/IdeaProjects/JarsLinkDemo/";


    @Override
    public List<ModuleConfig> queryModuleConfigs() {
        return ImmutableList.of(buildServiceModuleConfig());
    }

    public static ModuleConfig buildServiceModuleConfig(){
        String version=JarVersion.getJarVersion().getVersion("JarService");
        return buildModuleConfig(new String[]{PATH + "JarService/target/JarService-"+version+".jar", "JarService", version});
    }


    private static ModuleConfig buildModuleConfig(String[] paras) {
        ModuleConfig moduleConfig = new ModuleConfig();
        try {
            URL demoModule = new URL("file", "", -1, paras[0]);
            moduleConfig.setName(paras[1]);
            moduleConfig.setEnabled(true);
            moduleConfig.setVersion(paras[2]);
            moduleConfig.setModuleUrl(ImmutableList.of(demoModule));
            return moduleConfig;
        } catch (MalformedURLException e) {

        }
        return moduleConfig;
    }


}

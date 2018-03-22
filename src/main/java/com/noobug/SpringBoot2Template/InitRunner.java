package com.noobug.SpringBoot2Template;

import com.noobug.SpringBoot2Template.domain.SystemConfig;
import com.noobug.SpringBoot2Template.repository.SystemConfigRepository;
import com.noobug.webtools.utils.ConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 初始化
 *
 * @author 小王子
 */
@Component
public class InitRunner implements ApplicationRunner {

    @Autowired
    SystemConfigRepository systemConfigRepository;

    /**
     * 初始化读取配置
     */
    private void initConfigUtil(){
        List<SystemConfig> configs = systemConfigRepository.getAllByDeleted(Boolean.FALSE);
        for (SystemConfig config : configs){
            ConfigUtil.getInstance().add(config.getKey(), config.getData());
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initConfigUtil();
    }
}

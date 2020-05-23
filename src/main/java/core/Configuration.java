package core;

import org.aeonbits.owner.ConfigFactory;

public class Configuration {
    public static CommonConfig getCommon() {
        return ConfigFactory.create(CommonConfig.class);
    }
}

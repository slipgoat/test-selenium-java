package core;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:common.properties"})
public interface CommonConfig extends Config {
    @Key("common.host")
    String host();

    @Key("common.browser")
    String browser();

    @Key("common.hub.url")
    String hubUrl();

    @Key("common.base.timeout.sec")
    Long baseTimeoutSec();

    @Key("common.base.timeout.mills")
    Long baseTimeoutMills();
}

package cn.felord.boot.config;

import cn.felord.boot.event.EatEvent;
import cn.felord.boot.event.EatEventListener;
import cn.felord.boot.event.EatEventPublisherAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这三个一定要配置成bean
 *
 * @author dax
 * @since 2019/7/8 22:16
 */
@Configuration
public class EventConfig {

    @Bean
    public ApplicationEvent eatEvent1() {
        return new EatEvent(false);
    }

    @Bean
    public ApplicationListener eatEventListener() {
        return new EatEventListener();
    }

    @Bean
    public ApplicationEventPublisherAware eatEventPublisherAware(ApplicationEvent eatEvent) {
        return new EatEventPublisherAware(eatEvent);
    }

}

package cn.felord.boot;

import cn.felord.boot.event.EatEvent;
import cn.felord.boot.event.EatEventPublisherAware;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventSpringApplicationTests {
    @Resource
    private EatEventPublisherAware eatEventPublisherAware;
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() {

        eatEventPublisherAware.refreshEvent();

        int i = 0;
        while(i++!=100){
            System.out.println(i);
            if(i==50){
                EatEvent bean = applicationContext.getBean("eatEvent1", EatEvent.class);
                bean.setEatFinished(true);
            }
            eatEventPublisherAware.refreshEvent();
        }
    }

}

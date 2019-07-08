package cn.felord.boot;

import cn.felord.boot.event.EatEventPublisherAware;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventSpringApplicationTests {
@Resource
private EatEventPublisherAware eatEventPublisherAware;
    @Test
    public void contextLoads() {

        eatEventPublisherAware.refreshEvent();
    }

}
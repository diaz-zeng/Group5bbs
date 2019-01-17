package com.soft863.group5.bbs.test;

import com.soft863.group5.bbs.entity.Resources;
import com.soft863.group5.bbs.service.ResourcesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * author zhaosl
 * date 2019/1/15 20:33
 *
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class ReourcesMapperTest {
    @Autowired
    public ResourcesService resourcesService;
    @Test
    public void queryResourcesById(){
        List<Resources> resources = resourcesService.queryAllResources();
        System.out.println(resources);
    }
}

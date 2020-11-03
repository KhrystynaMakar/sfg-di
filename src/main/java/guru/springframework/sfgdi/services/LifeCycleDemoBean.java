package guru.springframework.sfgdi.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    public LifeCycleDemoBean() {
        System.out.println("## I'm in LifeCycleDemoBean constructor");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## BeanFactory has been set");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("## Bean name: " + s);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## Destroy LifeCycleBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## Properties are set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## Application context has been set");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("## The Post Construct annotated method has been called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("## The Pre Destroy annotated method has been called");
    }

    public void beforeInit() {
        System.out.println("## BeanPostProcessor beforeInitialization");
    }

    public void afterInit() {
        System.out.println("## BeanPostProcessor afterInitialization");
    }
}

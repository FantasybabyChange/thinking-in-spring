package com.fantasybaby.spring.beans.overview.instantiation;

import com.fantasybaby.spring.beans.overview.instantiation.factory.DefaultMusicFactory;
import com.fantasybaby.spring.beans.overview.instantiation.factory.MusicFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.ServiceLoader;

/**
 * Api实例化Bean的方法
 * Created on 4/11/2023.
 * <ul>
 *     <li>{@link org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean ServiceLoaderFactoryBean} 创建Bean </li>
 *     <li>实例方法</li>
 *     <li>通过FactoryBean</li>
 * </ul>>
 *
 * @author Fantasy Baby
 */
public class BeanInstantiationSpecial {
    public static void main(String[] args) {

        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:/special-instantiation-bean.xml");

        springServiceFactoryBean(beanFactory);
        jdkDirectlyLoad();
        springAutowireCapableBeanFactory(beanFactory);

    }

    /**
     * 通过 {@link AutowireCapableBeanFactory} 创建bean
     *
     * @param beanFactory bean工厂
     */
    public static void springAutowireCapableBeanFactory(ApplicationContext beanFactory) {
        AutowireCapableBeanFactory autowireCapableBeanFactory = beanFactory.getAutowireCapableBeanFactory();
        MusicFactory musicFactory = autowireCapableBeanFactory.createBean(DefaultMusicFactory.class);
        Music music = musicFactory.createMusic();
        System.out.println(music);
    }

    public static void printAllLoaderFactory(ServiceLoader<MusicFactory> loader) {
        loader.stream().forEach(it ->
                System.out.println(it.get().createMusic())
        );
    }

    /**
     * 通过Java的 {@link ServiceLoader}加载Bean
     */
    public static void jdkDirectlyLoad() {
        ServiceLoader<MusicFactory> load = ServiceLoader.load(MusicFactory.class, Thread.currentThread().getContextClassLoader());
        printAllLoaderFactory(load);
    }

    public static void springServiceFactoryBean(ApplicationContext beanFactory) {
        ServiceLoader<MusicFactory> load = beanFactory.getBean("musicFactoryServiceLoader", ServiceLoader.class);
        printAllLoaderFactory(load);
    }
}

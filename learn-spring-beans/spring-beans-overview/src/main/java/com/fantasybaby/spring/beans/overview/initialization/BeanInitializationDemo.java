package com.fantasybaby.spring.beans.overview.initialization;

import com.fantasybaby.spring.beans.overview.instantiation.factory.DefaultMusicFactory;
import com.fantasybaby.spring.beans.overview.instantiation.factory.MusicFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;


/**
 *  initialization and destroy bean
 * Created on 4/13/2023.
 *
 * @author Fantasy Baby
 */
public class BeanInitializationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(BeanInitializationDemo.class);
        annotationConfigApplicationContext.refresh();
        System.out.println("after context refresh");
        MusicFactory bean = annotationConfigApplicationContext.getBean(MusicFactory.class);
        System.out.println("before context close");
        annotationConfigApplicationContext.close();
        System.out.println("context closed");
    }

    @Bean(initMethod = "customerInitMethod",destroyMethod = "customerDestroyMethod")
    @Lazy
    public MusicFactory createMusicFactory() {
        return new DefaultMusicFactory();
    }
}

package com.fantasybaby.spring.beans.overview;

import com.fantasybaby.spring.beans.overview.instantiation.Music;
import com.fantasybaby.spring.beans.overview.instantiation.factory.DefaultMusicFactory;
import com.fantasybaby.spring.beans.overview.instantiation.factory.MusicFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * register external single bean
 * <p>
 * Created on 4/4/2023.
 *
 * @author Fantasy Baby
 */
public class RegisterExternalSingleBeanDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        ConfigurableListableBeanFactory beanFactory = annotationConfigApplicationContext.getBeanFactory();
        //注册外部单例Bean
        beanFactory.registerSingleton("musicBeanFactory", new DefaultMusicFactory());
        annotationConfigApplicationContext.refresh();
        MusicFactory musicBeanFactory = annotationConfigApplicationContext.getBean("musicBeanFactory", MusicFactory.class);
        Music music = musicBeanFactory.createMusic();
        System.out.println(music);
        annotationConfigApplicationContext.close();
    }


}

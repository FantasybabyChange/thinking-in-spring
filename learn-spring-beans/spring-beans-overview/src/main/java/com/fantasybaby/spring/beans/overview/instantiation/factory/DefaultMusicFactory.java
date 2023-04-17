package com.fantasybaby.spring.beans.overview.instantiation.factory;

import com.fantasybaby.spring.beans.overview.instantiation.Music;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;

/**
 * Created on 4/11/2023.
 *
 * @author Fantasy Baby
 */
public class DefaultMusicFactory implements MusicFactory , InitializingBean, DisposableBean {
    @Override
    public Music createMusic() {
        Music music = new Music();
        music.setName("factory instance method");
        music.setType("java");
        music.setVolume(50);
        return music;
    }
    @PostConstruct
    public void init(){
        System.out.println(this.getClass().getName()+" start init method");
    }
    public void customerInitMethod(){
        System.out.println(this.getClass().getName()+" start customerInitMethod init method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getName()+" afterPropertiesSet");
    }
    @PreDestroy
    public void destroyPreMethod(){
        System.out.println(this.getClass().getName()+"  @PreDestroy");

    }
    public void customerDestroyMethod(){
        System.out.println(this.getClass().getName()+" customerDestroyMethod");

    }

    @Override
    public void destroy() {
        System.out.println(this.getClass().getName()+" DisposableBean");
    }

    @Override
    public void finalize() {
        System.out.println("DefaultMusicFactory  gc =============================");
        System.exit(0);

    }
}

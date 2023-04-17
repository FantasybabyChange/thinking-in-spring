package com.fantasybaby.spring.beans.overview.initialization;

import com.fantasybaby.spring.beans.overview.instantiation.Music;
import com.fantasybaby.spring.beans.overview.instantiation.factory.DefaultMusicFactory;
import com.fantasybaby.spring.beans.overview.instantiation.factory.MusicFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;


/**
 *   调整JVM 大小 -Xms10m -Xmx10m
 * initialization and destroy bean
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
        Music music = bean.createMusic();
        System.out.println(music);
        System.out.println("before context close");
        annotationConfigApplicationContext.close();
        annotationConfigApplicationContext = null;
        System.out.println("context closed");
        try {
            List<Music> musicList = new ArrayList<>();
            System.gc();
            /**
             * 在这里尝试gc 则可以每次重现gc
             */
            while (true) {
                Music music1 = new Music();
                music1.setName(" MusicFactory bean = annotationConfigApplicationContext.getBean(MusicFactory.class); MusicFactory bean = annotationConfigApplicationContext.getBean(MusicFactory.class); MusicFactory bean = annotationConfigApplicationContext.getBean(MusicFactory.class);");
                musicList.add(music1);

                System.out.println(musicList.size());

                if(musicList.size() % 10000 == 0){
                    System.out.println("gc start");

                    System.gc();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 尝试gc 如果抽离出方法 每次都会 堆溢出
     *
     * @param musicList 音乐列表
     */
    private static void tryToGc(List<Music> musicList) {

    }

    @Bean(initMethod = "customerInitMethod", destroyMethod = "customerDestroyMethod")
    @Lazy
    public MusicFactory createMusicFactory() {
        return new DefaultMusicFactory();
    }
}

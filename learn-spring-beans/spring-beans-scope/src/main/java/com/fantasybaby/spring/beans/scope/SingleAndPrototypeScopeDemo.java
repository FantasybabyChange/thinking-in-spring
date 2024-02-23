package com.fantasybaby.spring.beans.scope;

import com.fantasybaby.spring.beans.scope.beans.MusicDo;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Random;

/**
 * a demo for test singleton and prototype
 * Created on 2024/2/22.
 *
 * @author Fantasy Baby
 */
public class SingleAndPrototypeScopeDemo {
    //    @Autowired
//    private MusicDo musicDo;
//    @Autowired
//    private List<MusicDo> musicDos;
    @Bean(value = "protoMusic")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public MusicDo createProtoMusicDo() {
        MusicDo musicDo = new MusicDo();
        Random random = new Random();
        musicDo.setName("music" + random.nextInt());
        musicDo.setType("music");
        musicDo.setVolume(random.nextInt());
        System.out.printf("createProtoMusicDo %s- %s ", musicDo.getName(), musicDo.getVolume());
        return musicDo;
    }

    @Bean(value = "singleMusic")
    public MusicDo createSingleMusicDo() {
        System.out.println("createSingleMusicDo");
        MusicDo musicDo = new MusicDo();
        musicDo.setName("SingleMusic");
        musicDo.setType("SingleMusic");
        musicDo.setVolume(66);
        return musicDo;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(SingleAndPrototypeScopeDemo.class);

        annotationConfigApplicationContext.refresh();

        getManyBeans(annotationConfigApplicationContext);
    }

    private static void getManyBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        for (int i = 0; i < 10; i++) {
            MusicDo bean = annotationConfigApplicationContext.getBean("singleMusic",MusicDo.class);
            System.out.println("bean " + bean);
        }

        for (int i = 0; i < 10; i++) {
            MusicDo bean = annotationConfigApplicationContext.getBean("protoMusic",MusicDo.class);
            System.out.println("bean " + bean);
        }
    }
}

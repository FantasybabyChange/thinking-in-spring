package com.fantasybaby.spring.beans.scope;

import com.fantasybaby.spring.beans.scope.beans.MusicDo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * a demo for test singleton and prototype
 * Created on 2024/2/22.
 *
 * @author Fantasy Baby
 */
public class SingleAndPrototypeScopeDemo implements DisposableBean {
    @Autowired
    @Qualifier("singleMusic")
    private MusicDo singleMusic;

    @Autowired
    @Qualifier("singleMusic")
    private MusicDo singleMusic2;
    @Autowired
    @Qualifier("protoMusic")
    private MusicDo musicDo1;
    @Autowired
    @Qualifier("protoMusic")
    private MusicDo musicDo2;
    @Autowired
    @Qualifier("protoMusic")
    private MusicDo musicDo3;
    @Autowired
    private List<MusicDo> musicDos;
    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

    /**
     * 在collection中 所有的bean都会存在,无论是single 还是protoType的Beans,但只会存在一个
     * protoType Bean 会和其他依赖注入的Bean不同
     */
    @Autowired
    private Map<String, MusicDo> musicDoMap;

    @Bean(value = "protoMusic")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public MusicDo createProtoMusicDo() {
        MusicDo musicDo = new MusicDo();
        Random random = new Random();
        musicDo.setName("music" + random.nextInt());
        musicDo.setType("music");
        musicDo.setVolume(random.nextInt());
        System.out.printf("createProtoMusicDo %s- %s \n", musicDo.getName(), musicDo.getVolume());
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
        annotationConfigApplicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            // do something
            beanFactory.addBeanPostProcessor((new BeanPostProcessor() {
                @Override
                public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                    System.out.printf("beanName %s  after initial", beanName);
                    return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
                }
            }));
        });
        annotationConfigApplicationContext.register(SingleAndPrototypeScopeDemo.class);

        annotationConfigApplicationContext.refresh();

//        getBeanLookUp(annotationConfigApplicationContext);
//
//        getInjectBeans(annotationConfigApplicationContext);

//        getBeanCollection(annotationConfigApplicationContext);
        getBeanLifecycle(annotationConfigApplicationContext);
        annotationConfigApplicationContext.close();
    }

    /**
     * singleton bean 会init 也会 preDestroy
     * protoType则不会执行preDestroy
     *
     * @param annotationConfigApplicationContext
     */
    private static void getBeanLifecycle(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        SingleAndPrototypeScopeDemo bean = annotationConfigApplicationContext.getBean(SingleAndPrototypeScopeDemo.class);
        MusicDo musicDo1 = bean.musicDo1;
        MusicDo musicDo2 = bean.musicDo2;
    }

    private static void getBeanCollection(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        SingleAndPrototypeScopeDemo bean = annotationConfigApplicationContext.getBean(SingleAndPrototypeScopeDemo.class);
        Map<String, MusicDo> musicDoMap1 = bean.musicDoMap;
        System.out.printf("all bean in collection %s", musicDoMap1);
    }

    /**
     * dependency inject
     *
     * @param annotationConfigApplicationContext
     */
    private static void getInjectBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        SingleAndPrototypeScopeDemo bean = annotationConfigApplicationContext.getBean(SingleAndPrototypeScopeDemo.class);
        MusicDo musicDo1 = bean.musicDo1;
        MusicDo musicDo2 = bean.musicDo2;
        System.out.printf("proto bean %s equal %s ? %s  \n", musicDo1, musicDo2, musicDo2 == musicDo1);

        MusicDo singleMusic1 = bean.singleMusic;
        MusicDo singleMusic2 = bean.singleMusic2;
        System.out.printf("single bean %s equal %s ? %s  \n", singleMusic1, singleMusic2, singleMusic1 == singleMusic2);
    }

    /**
     * dependency look up
     *
     * @param annotationConfigApplicationContext
     */
    private static void getBeanLookUp(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        for (int i = 0; i < 10; i++) {
            MusicDo bean = annotationConfigApplicationContext.getBean("singleMusic", MusicDo.class);
            System.out.println("bean " + bean);

        }

        for (int i = 0; i < 10; i++) {
            MusicDo bean = annotationConfigApplicationContext.getBean("protoMusic", MusicDo.class);
            System.out.println("bean " + bean);
        }
    }

    @Override
    public void destroy() throws Exception {
        // 手动调用destory方法
        musicDo1.preDestroy();
        musicDos.forEach(MusicDo::preDestroy);
        for (Map.Entry<String, MusicDo> entry : musicDoMap.entrySet()) {
            String key = entry.getKey();
            if (beanFactory.isPrototype(key)) {
                entry.getValue().preDestroy();
            }
        }
    }
}

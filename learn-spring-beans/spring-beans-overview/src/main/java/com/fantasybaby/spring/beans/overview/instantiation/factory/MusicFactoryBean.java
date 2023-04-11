package com.fantasybaby.spring.beans.overview.instantiation.factory;

import com.fantasybaby.spring.beans.overview.instantiation.Music;
import org.springframework.beans.factory.FactoryBean;

/**
 * {@link org.springframework.beans.factory.FactoryBean }
 * Created on 4/11/2023.
 *
 * @author Fantasy Baby
 */
public class MusicFactoryBean implements FactoryBean<Music> {
    @Override
    public Music getObject() {
        Music music = new Music();
        music.setName("factoryBean instance ");
        music.setType("blues");
        music.setVolume(51);
        return music;
    }

    @Override
    public Class<?> getObjectType() {
        return Music.class;
    }
}

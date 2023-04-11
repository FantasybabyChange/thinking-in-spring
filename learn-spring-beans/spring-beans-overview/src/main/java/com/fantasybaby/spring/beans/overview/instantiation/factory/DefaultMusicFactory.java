package com.fantasybaby.spring.beans.overview.instantiation.factory;

import com.fantasybaby.spring.beans.overview.instantiation.Music;

/**
 * Created on 4/11/2023.
 *
 * @author Fantasy Baby
 */
public class DefaultMusicFactory implements MusicFactory {
    @Override
    public Music createMusic() {
        Music music = new Music();
        music.setName("factory instance method");
        music.setType("java");
        music.setVolume(50);
        return music;
    }
}

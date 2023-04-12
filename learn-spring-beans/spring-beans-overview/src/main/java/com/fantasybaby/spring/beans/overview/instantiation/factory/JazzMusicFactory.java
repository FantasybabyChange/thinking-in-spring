package com.fantasybaby.spring.beans.overview.instantiation.factory;

import com.fantasybaby.spring.beans.overview.instantiation.Music;

/**
 * Created on 4/11/2023.
 *
 * @author Fantasy Baby
 */
public class JazzMusicFactory implements MusicFactory {
    @Override
    public Music createMusic() {
        Music music = new Music();
        music.setName("jazz factory instance method");
        music.setType("jazz");
        music.setVolume(50);
        return music;
    }
}

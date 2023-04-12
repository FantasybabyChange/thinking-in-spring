package com.fantasybaby.spring.beans.overview.instantiation.factory;

import com.fantasybaby.spring.beans.overview.instantiation.Music;

/**
 * Created on 4/11/2023.
 *
 * @author Fantasy Baby
 */
public interface MusicFactory {
    /**
     * 创作音乐
     * create music
     *
     * @return {@link Music}
     */
    Music createMusic();
}

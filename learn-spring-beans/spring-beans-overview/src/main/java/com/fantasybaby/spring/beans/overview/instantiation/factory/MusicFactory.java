package com.fantasybaby.spring.beans.overview.instantiation.factory;

import com.fantasybaby.spring.beans.overview.instantiation.Music;

/**
 * Created on 4/11/2023.
 *
 * @author Fantasy Baby
 */
public interface MusicFactory {
    /**
     * create music
     *
     * @param name 名字
     * @return {@link Music}
     */
    Music createMusic();
}

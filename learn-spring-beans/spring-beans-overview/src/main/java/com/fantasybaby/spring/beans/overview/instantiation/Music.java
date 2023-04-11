package com.fantasybaby.spring.beans.overview.instantiation;

/**
 * Created on 4/11/2023.
 *
 * @author Fantasy Baby
 */
public class Music {
    public String name;
    public String type;

    public Integer volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Music{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", volume=" + volume +
                '}';
    }

    /**
     * 通过静态工厂创建类
     *
     * @return {@link Music}
     */
    public static Music createMusic() {
        Music music = new Music();
        music.setName("staticMethodMusic");
        music.setType("pop");
        music.setVolume(12);
        return music;
    }
}

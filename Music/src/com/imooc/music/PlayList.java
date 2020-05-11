package com.imooc.music;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayList implements Serializable {
    private String playListname;
    private ArrayList<Song> musicList;

    public PlayList(String playListname) {
        this.playListname = playListname;
        this.musicList=new ArrayList<Song>();
    }

    //将歌曲添加到播放列表
    public void addToPlayList(Song song) {
        musicList.add(song);
    }

    //显示播放列表中的所有歌曲
    public void displayAllSong() {
        Iterator<Song> iterator = musicList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //通过id查询歌曲
    public Song serchSongById(String id) {
        Iterator<Song> iterator = musicList.iterator();
        Song song = null;
        while (iterator.hasNext()) {
            if ((song = iterator.next()).getId().equals(id)) {
               // System.out.println(song);
                break;
            } else if (!iterator.hasNext()) {
                //System.out.println("没有此歌曲！");
                song=null;
            }
        }
        return song;
    }

    //通过名称查询歌曲
    public Song serchSongByName(String name) {
        Iterator<Song> iterator = musicList.iterator();
        Song song = null;
        while (iterator.hasNext()) {
            if ((song = iterator.next()).getName().equals(name)) {
                //System.out.println(song);
                break;
            } else if (!iterator.hasNext()) {
                //System.out.println("没有此歌曲！");
                song=null;
            }
        }

        return song;
    }

    //修改歌曲
    public void updateSong(String id, Song song) {
        Iterator<Song> iterator = musicList.iterator();
        Song song1 = null;
        int index = 0;
        while (iterator.hasNext()) {
            index++;
            if ((song1 = iterator.next()).getId().equals(id)) {
                musicList.remove(song1);
                musicList.add((index - 1), song);
                //System.out.println("修改成功");
                break;
            }
        }
    }

    //从播放列表删除歌曲
    public void deleteSong(String id) {
        Iterator<Song> iterator = musicList.iterator();
        Song song = null;
        while (iterator.hasNext()) {
            if ((song = iterator.next()).getId().equals(id)) {
                musicList.remove(song);
               // System.out.println("删除成功");
                break;
            }
        }
    }

    @Override
    public String toString() {
        return playListname;
    }

    public String getPlayListname() {
        return playListname;
    }

    public void setPlayListname(String playListname) {
        this.playListname = playListname;
    }

    public List<Song> getMusicList() {
        return musicList;
    }

    public void setMusicList(ArrayList<Song> musicList) {
        this.musicList = musicList;
    }
}

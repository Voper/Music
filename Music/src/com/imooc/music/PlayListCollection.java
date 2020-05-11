package com.imooc.music;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PlayListCollection {
    private Map<String,PlayList> playListMap;

    public PlayListCollection() {
        this.playListMap = new HashMap<String, PlayList>();
    }

    //添加播放列表
    public void addPlayList(PlayList playList){
        playListMap.put(playList.getPlayListname(),playList);
        System.out.println("添加成功");
    }
    //删除播放列表
    public void deletePlayList(PlayList playList){

        if ( (playListMap.remove(playList.getPlayListname()))!=null){
            System.out.println("删除成功");
        }



    }

    //通过名字查询
    public PlayList serchPlauListByName(String name){
        PlayList playList=null;
        playList= (PlayList) playListMap.get(name);
        if (playList!=null){
            System.out.println("找到了");
        }else {
            System.out.println("该列表不存在");
        }



        return playList;
    }
    //显示所有播放列表名称
    public void displayPlayListName(){
        Iterator<PlayList> iterator=playListMap.values().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public Map<String, PlayList> getPlayListMap() {
        return playListMap;
    }

    public void setPlayListMap(Map<String, PlayList> playListMap) {
        this.playListMap = playListMap;
    }
}

package com.imooc.music;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class TestDemo {

    public static void main(String[] args) {
        PlayListCollection playListCollection = new PlayListCollection();
        PlayList playListMain = new PlayList("主播放列表");
        playListCollection.addPlayList(playListMain);
        mainMenu();
        loop:
        while (true) {

            int n;
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();

            switch (n) {
                case 1: {
                    loop1:
                    while (true) {
                        playListCollectionMenu();
                        int plcm;
                        plcm = scanner.nextInt();
                        switch (plcm) {
                            case 1: {
                                //向播放器中添加播放列表
                                System.out.println("请输入播放列表名称");
                                String playListName = scanner.next();
                                PlayList playList = new PlayList(playListName);
                                playListCollection.addPlayList(playList);

                                continue loop1;
                            }
                            case 2: {
                                //从播放器中删除播放列表
                                System.out.println("请输入要删除的播放列表的名字");
                                String playListName = scanner.next();
                                PlayList playList = new PlayList(playListName);
                                playListCollection.deletePlayList(playList);
                                continue loop1;

                            }
                            case 3: {
                                //通过名字查询播放列表信息
                                System.out.println("请输入要查询的播放列表的名字");
                                String playListName = scanner.next();
                                PlayList playList =
                                        playListCollection.serchPlauListByName(playListName);

                                System.out.println("该列表名称为：" + playListName);
                                System.out.println("播放列表所有的歌曲为：");
                                playList.displayAllSong();

                                continue loop1;


                            }
                            case 4: {
                                //显示所有播放列表的名称
                                playListCollection.displayPlayListName();

                                continue loop1;
                            }
                            case 0:
                                mainMenu();
                                continue loop;
                        }

                    }
                }
                case 2: {
                    loop2:
                    while (true) {
                        playListMenu();
                        int plm;
                        plm = scanner.nextInt();
                        switch (plm) {
                            case 1: {
                                //将歌曲添加到主播放列表
                                String id;
                                String name;
                                String singer;
                                System.out.println("请输入要添加的歌曲数目：");
                                int count = scanner.nextInt();
                                for (int i = 0; i < count; i++) {
                                    System.out.println("开始录入第" + (i + 1) + "首歌曲");
                                    System.out.println("请输入歌曲id");
                                    id = scanner.next();
                                    System.out.println("请输入歌曲名称");
                                    name = scanner.next();
                                    System.out.println("请输入歌手");
                                    singer = scanner.next();
                                    Song song = new Song(id, name, singer);
                                    playListMain.addToPlayList(song);
                                    System.out.println("歌曲录入成功");
                                }
                                continue loop2;
                            }
                            case 2: {
                                //将歌曲添加到普通播放列表
                                System.out.println("将歌曲添加到普通播放列表\n请输入要添加的播放列表名称：");
                                String plName = scanner.next();
                                PlayList playList = playListCollection.serchPlauListByName(plName);
                                if (playList == null) {
                                    System.out.println("该播放列表不存在，请先创建该播放列表");
                                    continue loop2;
                                } else {
                                    String id;
                                    String name;
                                    String singer;
                                    System.out.println("请输入要添加的歌曲数目：");
                                    int count = scanner.nextInt();
                                    Song song = null;
                                    for (int i = 0; i < count; i++) {
                                        System.out.println("开始录入第" + (i + 1) + "首歌曲");
                                        System.out.println("请输入歌曲id");
                                        id = scanner.next();
                                        if ((song = playListMain.serchSongById(id)) != null) {
                                            playList.addToPlayList(song);
                                            System.out.println("录入成功\n" + song);
                                            continue;
                                        }
                                        System.out.println("请输入歌曲名称");
                                        name = scanner.next();

                                        System.out.println("请输入歌手");
                                        singer = scanner.next();
                                        song = new Song(id, name, singer);
                                        playListMain.addToPlayList(song);
                                        playList.addToPlayList(song);
                                        System.out.println("歌曲录入成功");
                                        System.out.println("主播放列表：");
                                        playListMain.displayAllSong();
                                        System.out.println("普通播放列表：");
                                        playList.displayAllSong();
                                    }
                                }
                                continue loop2;
                            }
                            case 3: {
                                //通过歌曲id查询播放列表中的歌
                                System.out.println("通过歌曲id查询播放列表中的歌\n请输入要查询的播放列表名称：");
                                String plName = scanner.next();
                                PlayList playList = playListCollection.serchPlauListByName(plName);
                                if (playList == null) {
                                    System.out.println("该播放列表不存在，请先创建该播放列表");
                                    continue loop2;
                                } else {
                                    System.out.println("请输入要查询的歌曲id：");
                                    String id = scanner.next();
                                    Song song = playList.serchSongById(id);
                                    if (song != null) {
                                        System.out.println("该歌曲的信息为：\n" + song);
                                    } else {
                                        System.out.println("该歌曲不存在！");
                                    }
                                }
                                continue loop2;
                            }
                            case 4: {
                                //通过歌曲名称查询播放列表中的歌
                                System.out.println("通过歌曲名称查询播放列表中的歌\n请输入要查询的播放列表名称：");
                                String plName = scanner.next();
                                PlayList playList = playListCollection.serchPlauListByName(plName);
                                if (playList == null) {
                                    System.out.println("该播放列表不存在，请先创建该播放列表");
                                    continue loop2;
                                } else {
                                    System.out.println("请输入要查询的歌曲名称：");
                                    String name = scanner.next();
                                    Song song = playList.serchSongByName(name);
                                    if (song != null) {
                                        System.out.println("该歌曲的信息为：\n" + song);
                                    } else {
                                        System.out.println("该歌曲不存在！");
                                    }
                                }
                                continue loop2;
                            }
                            case 5: {
                                //修改播放列表中的歌曲
                                System.out.println("修改播放列表中的歌曲\n请输入要修改的歌曲id：");
                                String id = scanner.next();
                                String name;
                                String singer;
                                Iterator<PlayList> iterator = playListCollection.getPlayListMap().values().iterator();
                                Song song = null;
                                PlayList playList = null;
                                Boolean flag = false;

                                while (iterator.hasNext()) {

                                    playList = iterator.next();
                                    song = playList.serchSongById(id);
                                    if (song != null) {
                                        if (flag) {
                                            playList.updateSong(id, song);
                                            continue;
                                        }
                                        System.out.println("请输入歌曲名称：");
                                        name = scanner.next();
                                        System.out.println("请输入歌手：");
                                        singer = scanner.next();
                                        song.setName(name);
                                        song.setSinger(singer);
                                        playList.updateSong(id, song);
                                        flag = true;

                                    }
                                }
                                if (song == null) {
                                    System.out.println("没有找到该歌曲");
                                } else {
                                    System.out.println("修改成功");
                                }
                                continue loop2;
                            }
                            case 6: {
                                //删除播放列表中的歌曲
                                System.out.println("删除播放列表中的歌曲\n请输入要删除的歌曲id：");
                                String id = scanner.next();

                                Iterator<PlayList> iterator = playListCollection.getPlayListMap().values().iterator();
                                Song song = null;
                                PlayList playList = null;
                                while (iterator.hasNext()) {
                                    playList = iterator.next();
                                    song = playList.serchSongById(id);
                                    if (song != null) {
                                        playList.deleteSong(id);
                                    }
                                }
                                if (song == null) {
                                    System.out.println("没有找到该歌曲");
                                } else {
                                    System.out.println("删除成功");
                                }
                                continue loop2;
                            }
                            case 7: {
                                //显示播放列表中的所有歌曲
                                System.out.println("显示播放列表中的所有歌曲\n请输入要显示的播放列表名称：");
                                String plName = scanner.next();
                                PlayList playList = playListCollection.serchPlauListByName(plName);
                                if (playList == null) {
                                    System.out.println("该播放列表不存在，请先创建该播放列表");
                                    continue loop2;
                                } else {
                                    playList.displayAllSong();
                                }
                                continue loop2;
                            }
                            case 8: {
                                //导出歌单
                                System.out.println("导出歌单\n请输入要导出的播放列表名称：");
                                String plName = scanner.next();
                                PlayList playList = playListCollection.serchPlauListByName(plName);
                                if (playList == null) {
                                    System.out.println("该播放列表不存在，请先创建该播放列表");
                                    continue loop2;
                                } else {
                                    //FileInputStream fileInputStream=new FileInputStream(plName);
                                    try {
                                        FileOutputStream fileOutputStream = new FileOutputStream(plName + "的歌单");
                                        // OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
                                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                                        objectOutputStream.writeObject(playList);
                                        objectOutputStream.flush();
                                        objectOutputStream.close();
                                        fileOutputStream.close();


                                    } catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }


                                }
                                continue loop2;


                            }
                            case 0: {
                                mainMenu();
                                continue loop;
                            }

                        }

                    }
                }
                case 0:
                    System.exit(0);
            }


        }


    }

    //主界面
    public static void mainMenu() {
        System.out.println(
                "           欢迎进入播放器\n" +
                        "         1.播放器管理\n" +
                        "         2.播放列表管理\n" +
                        "         0.退出播放器"
        );
    }

    //播放器管理菜单
    public static void playListCollectionMenu() {
        System.out.println(
                "             播放器管理\n" +
                        "       1.向播放器中添加播放列表\n" +
                        "       2.从播放器删除播放列表\n" +
                        "       3.通过名字查询播放列表信息\n" +
                        "       4.显示所有播放列表的名称\n" +
                        "       0.返回上一级菜单"
        );
    }

    //播放列表管理菜单
    public static void playListMenu() {
        System.out.println(
                "             播放列表管理\n" +
                        "         1.将歌曲添加到主播放列表\n" +
                        "         2.将歌曲添加到普通播放列表\n" +
                        "         3.通过歌曲id查询播放列表中的歌曲\n" +
                        "         4.通过歌曲名称查询播放列表中的歌曲\n" +
                        "         5.修改播放列表中的歌曲\n" +
                        "         6.删除播放列表中的歌曲\n" +
                        "         7.显示播放列表中的所有歌曲\n" +
                        "         8.导出歌单\n" +
                        "         0.返回上一级菜单"
        );
    }
}

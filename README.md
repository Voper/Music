# Music
控制台页面的音乐播放器  （imooc 上java就业班 工具类 综合项目）


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

package kcn.mvcmusicplayer.server;

import kcn.mvcmusicplayer.controller.ErrorController;
import kcn.mvcmusicplayer.view.IView;

import java.util.HashMap;
import java.util.Objects;

public class ViewNameServer
{

    public static HashMap<String, IView> views;


    public static HashMap<String, IView> viewMap()
    {
        if(Objects.isNull(views)){views = new HashMap<>();}
        return views;
    }

    public static void setViews(HashMap<String, IView> views)
    {
        ViewNameServer.views = views;
    }
}

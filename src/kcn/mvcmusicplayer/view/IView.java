package kcn.mvcmusicplayer.view;

import kcn.mvcmusicplayer.controller.IController;

public interface IView
{
    void show();
    void show(String string);
    IView injectController(IController controller);
}

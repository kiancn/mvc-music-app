package kcn.mvcmusicplayer.controller;

import kcn.mvcmusicplayer.view.Console;
import kcn.mvcmusicplayer.view.IPresent;
import kcn.mvcmusicplayer.view.IView;

import java.util.Objects;

public interface IErrorController
{
    static IPresent presenter = new Console(System.out);

    void setPresenter(IPresent output);

    void printError(Exception e, String message);

    //    IPresent presenter();
    IPresent presenter();
}


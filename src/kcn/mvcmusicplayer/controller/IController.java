package kcn.mvcmusicplayer.controller;

import kcn.mvcmusicplayer.repository.ITrackRepository;
import kcn.mvcmusicplayer.view.IPresent;
import kcn.mvcmusicplayer.view.IView;

public interface IController
{
    IView view(String viewName); // returns a
    ITrackRepository getRepository();
    IPresent output(); // the object responsible for presenting data from viewmodels

}

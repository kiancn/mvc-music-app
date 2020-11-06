package kcn.mvcmusicplayer;

import kcn.mvcmusicplayer.controller.IController;
import kcn.mvcmusicplayer.controller.MusicViewController;
import kcn.mvcmusicplayer.repository.ITrackRepository;
import kcn.mvcmusicplayer.repository.TrackListRepository;
import kcn.mvcmusicplayer.server.ViewNameServer;
import kcn.mvcmusicplayer.service.IPlaySound;
import kcn.mvcmusicplayer.service.SoundPlayer;
import kcn.mvcmusicplayer.view.*;

public class Main
{

    public static void main(String[] args)
    {
        /* using Singleton Instance as an in-memory name-server for views*/
        ViewNameServer.viewMap().put("main", new MainMenu());
        ViewNameServer.viewMap().put("searchView", new SearchView());
        ViewNameServer.viewMap().put("soundPlayer", new PlayView());
        ViewNameServer.viewMap().put("trackSelector", new TrackSelectorView());
        ViewNameServer.viewMap().put("createView", new CreateTrackView());


        ITrackRepository repository = new TrackListRepository(new DummyData().generateDummyTracks());
        IPresent consolePresenter = new Console(System.out);
        IController musicViewController = new MusicViewController(repository, consolePresenter);

        musicViewController.view("main").show();
    }
}

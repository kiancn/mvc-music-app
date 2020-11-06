package kcn.mvcmusicplayer.controller;

import kcn.mvcmusicplayer.repository.ITrackRepository;
import kcn.mvcmusicplayer.server.ViewNameServer;
import kcn.mvcmusicplayer.view.IPresent;
import kcn.mvcmusicplayer.view.IView;

public class MusicViewController implements IController
{

    ITrackRepository repository;
    IPresent output;

    public MusicViewController(ITrackRepository repository, IPresent outputFeed)
    {
        this.repository = repository;
        this.output = outputFeed;
    }

    @Override
    public IView view(String viewName)
    {
        if(ViewNameServer.viewMap().containsKey(viewName))
        {
            return ViewNameServer.viewMap().get(viewName).injectController(this);
        }
        return output; // in case of bad viewName, empty console is returned.
    }

    public ITrackRepository getRepository(){ return repository; }

    public void setRepository(ITrackRepository repository){ this.repository = repository; }

    @Override
    public IPresent output(){ return output; }

    public void setOutput(IPresent outputStream){ this.output = outputStream; }

}

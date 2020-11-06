package kcn.mvcmusicplayer.view;

import kcn.mvcmusicplayer.controller.IController;
import kcn.mvcmusicplayer.service.IPlaySound;
import kcn.mvcmusicplayer.service.SoundPlayer;

public class PlayView implements IView
{
    private IController controller;
    private IPlaySound player;

    public PlayView()
    {
        player = new SoundPlayer("src/kcn/mvcmusicplayer/data/error.mp3",true);
    }

    @Override
    public void show()
    {
        controller.output().show("Music Play View Responsive. No Song Selected");
    }

    @Override
    public void show(String string)
    {
        player.play(string);
    }

    @Override
    public IView injectController(IController controller)
    {
        this.controller = controller;
        return this;
    }
}

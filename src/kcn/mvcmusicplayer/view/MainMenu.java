package kcn.mvcmusicplayer.view;

import kcn.mvcmusicplayer.controller.IController;
import kcn.mvcmusicplayer.controller.MusicViewController;
import kcn.mvcmusicplayer.service.GET;


public class MainMenu implements IView
{
    private IController mvc;

    public MainMenu()    {    }


    public void show()
    {
        boolean continueLooping = true;

        do
        {

            mvc.output().show("\tWelcome to the MVC Music Player\n" +
                              "\tEnjoy the Speed of Console(TM)\n\n");

            mvc.view("soundPlayer").show("src/kcn/mvcmusicplayer/data/BattleIntro.mp3");

            mvc.output().show("\t1) Search and Listen"+
                              "\n\t2) Add to Collection" +
                              "\n\t3) Exit");

            switch(GET.getInteger("Make your choice:\t")){
                case 1: mvc.view("searchView").show();break;
                case 2: mvc.view("createView").show();break;
                case 3: continueLooping = false;break;
                default: break;
            }



        } while(continueLooping);

        mvc.output().show("MVC Music Player Shutting Down.");
    }

    @Override
    public void show(String string)    {        mvc.output().show(string);    }

    @Override
    public IView injectController(IController controller)
    {
        mvc = controller;
        return this;
    }

}

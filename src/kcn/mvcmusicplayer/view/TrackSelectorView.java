package kcn.mvcmusicplayer.view;

import kcn.mvcmusicplayer.controller.IController;
import kcn.mvcmusicplayer.model.Track;
import kcn.mvcmusicplayer.service.GET;

import java.util.List;

public class TrackSelectorView implements IView
{
    IController controller;

    @Override
    public void show()
    {

    }

    @Override
    public void show(String string)
    {

        controller.output().show("\n\tSong Selection:" +
                                 "\n Your search for  '" + string + "' found "
                                 + controller.getRepository().currentTrackList().size() + " tracks.\n");

        if(controller.getRepository().currentTrackList().size() > 0)
        {
            int count = 0;
            StringBuilder builder = new StringBuilder();

            for(Track track : controller.getRepository().currentTrackList())
            {
                builder.append("\n\t").append(count++).append(")\t").append(track.getTitle());
            }
            controller.output().show(builder.toString());

            int choice = GET.getInteger("\tPlease enter number of song. 0-n\t");

            if((choice > -1) && choice <= (controller.getRepository().currentTrackList().size() - 1))
            {
                Track chosenTrack = controller.getRepository().currentTrackList().get(choice);
                controller.output().show("You selected\t" + chosenTrack.getTitle() +
                                         "\tby\t " + chosenTrack.getBand().getBandName());
                /* play the song */
                controller.view("soundPlayer").show(chosenTrack.getPathToFile());
                System.out.println("Path to sound file: " + chosenTrack.getPathToFile());
            } else{ System.out.println("Something weird happened."); }
        }

    }

    @Override
    public IView injectController(IController controller)
    {
        this.controller = controller;
        return this;
    }
}

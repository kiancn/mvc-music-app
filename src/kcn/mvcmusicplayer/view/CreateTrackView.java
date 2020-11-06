package kcn.mvcmusicplayer.view;

import kcn.mvcmusicplayer.controller.IController;
import kcn.mvcmusicplayer.model.Band;
import kcn.mvcmusicplayer.model.Genre;
import kcn.mvcmusicplayer.model.Track;
import kcn.mvcmusicplayer.service.GET;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateTrackView implements IView
{
    private IController controller;

    @Override
    public void show()
    {
        Track newTrack = new Track(GET.getString("Enter title of track:\t"),
                                   selectDuration(),
                                   selectGenre(),
                                   createBand(),
                                   GET.getString("Please enter path to file now." +
                                                 "\n\t Example path ' C:\\music\\banginghit.mp3 '" +
                                                 "\n\tFile path:\t"));

        controller.getRepository().saveTrack(newTrack);

        controller.output().show("\n\tSong '" + newTrack.getTitle() +"' saved to collection.");
    }

    private Band chooseOrCreateBand()
    {
        switch(GET.getInteger("Enter \t' 1 ' to choose from existing bands\n" +
                              " or  \tany other number else to create a new band!"))
        {
            case 1:
                return chooseBand();
            default:
                return createBand();
        }
    }

    private Band chooseBand()
    {
        controller.output().show("Feature not implemented. Redirecting to create new band.");
        return createBand();
    }

    private Band createBand()
    {
        controller.output().show("You now get to create associated band.");

        String bandName = GET.getString("Enter name of band:\t");

        List<String> bandMembers = new ArrayList<>();
        boolean moreBandMembersToRegister;
        do
        {
            String bandMemberName = GET.getString("Enter name of band member:");
            bandMembers.add(bandMemberName);
            moreBandMembersToRegister = GET.getConfirmation("Register more band members? y / n", "y", "n");
        } while(moreBandMembersToRegister);

        Genre genre = selectGenre();



        int firstYear = GET.getInteger("Which year did the band appear? Enter year:\t");

        Band band = new Band(bandName, bandMembers, firstYear, Arrays.asList(genre));

        return band;
    }

    private float selectDuration()
    {
        float duration = 0f;
        int minutes = GET.getInteger("Track Duration\t(first minutes, then seconds)\n\tEnter number of WHOLE minutes:\t");
        int seconds = GET.getInteger("\tEnter number of seconds:\t");
        duration = ((float)(minutes)) + ((float)(seconds) / 100);
        controller.output().show("Song duration registered at " + duration + " minutes");

        return duration;
    }

    private Genre selectGenre()
    {
        Genre genre = Genre.CLASSICAL;// default
        boolean genreChosen = false;
        do
        {
            controller.output().show("Choose track genre from this list:" +
                                     "\n\t1) ROCK" +
                                     "\n\t2) FOLK" +
                                     "\n\t3) CLASSICAL" +
                                     "\n\t4) JAZZ" +
                                     "\n\t5) SEXYTIME"
                                    );

            switch(GET.getInteger("Enter a number on the list:\t"))
            {
                case 1:
                    genre = Genre.ROCK;
                    genreChosen = true;
                    break;
                case 2:
                    genre = Genre.FOLK;
                    genreChosen = true;
                    break;
                case 3:
                    genre = Genre.CLASSICAL;
                    genreChosen = true;
                    break;
                case 4:
                    genre = Genre.JAZZ;
                    genreChosen = true;
                    break;
                case 5:
                    genre = Genre.SEXYTIME;
                    genreChosen = true;
                    break;
                default:
                    break;
            }
        } while(!genreChosen);
        return genre;
    }

    @Override
    public void show(String string)
    {

    }

    @Override
    public IView injectController(IController controller)
    {
        this.controller = controller;
        return this;
    }
}

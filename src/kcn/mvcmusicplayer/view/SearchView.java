package kcn.mvcmusicplayer.view;

import kcn.mvcmusicplayer.controller.IController;
import kcn.mvcmusicplayer.model.Genre;
import kcn.mvcmusicplayer.model.Track;
import kcn.mvcmusicplayer.service.GET;

import java.util.ArrayList;
import java.util.List;

public class SearchView implements IView
{

    IController mvc;

    public SearchView()    {    }

    public void show()
    {
        mvc.output().show("Would you like to search songs by" +
                          "\n1) Title" +
                          "\n2) Band Name" +
                          "\n3) Genre"
                         );
        switch(GET.getInteger("Please enter a number 1-3 to make your choice: \t"))
        {
            case 1:
                showTitleSearch();
                break;
            case 2:
                showBandSearch();
                break;
            case 3:
                showGenreSearch();
                break;
            default:
                break;
        }
    }

    @Override
    public void show(String string)
    {
        mvc.output().show(string);
    }

    @Override
    public IView injectController(IController controller)
    {
        mvc = controller;
        return this;
    }

    public void showBandSearch()
    {
        String bandToSearch = GET.getString("Please enter the name of the band you want to search for:\t");

        mvc.getRepository().currentTrackList().clear();
        mvc.getRepository().currentTrackList().addAll( mvc.getRepository().findTracksByBandNameContaining(bandToSearch));

        mvc.output().show("Search for '" + bandToSearch + "' found\t" + mvc.getRepository().currentTrackList().size() + " results.\n");

        mvc.view("trackSelector").show(bandToSearch);

        mvc.output().show("End of list-ening.");
    }

    public void showTitleSearch()
    {
        String titleToSearch = GET.getString("Please enter the title you want to search for:\t");

        mvc.getRepository().currentTrackList().clear();
        mvc.getRepository().currentTrackList().addAll( mvc.getRepository().findTracksByName(titleToSearch));

        mvc.output().show("Search for '" + titleToSearch + "' found" + mvc.getRepository().currentTrackList().size());

        mvc.view("trackSelector").show(titleToSearch);

        mvc.output().show("End of list-ening.");
    }

    public void showGenreSearch()
    {

        String genreToSearch = GET.getString("Please enter the name of GENRE you want to search for:\t");

        List<Track> tracks = new ArrayList<>();

        switch(genreToSearch)
        {
            case "CLASSICAL, SEXYTIME":
                tracks = mvc.getRepository().findTracksByGenre(Genre.CLASSICAL);
                break;
            case "ROCK":
                tracks = mvc.getRepository().findTracksByGenre(Genre.ROCK);
                break;
            case "JAZZ":
                tracks = mvc.getRepository().findTracksByGenre(Genre.JAZZ);
                break;
            case "SEXYTIME":
                tracks = mvc.getRepository().findTracksByGenre(Genre.SEXYTIME);
                break;
        }

        mvc.output().show("Search for '" + genreToSearch + "' found" + tracks.size());

        mvc.getRepository().currentTrackList().clear();
        mvc.getRepository().currentTrackList().addAll(tracks);

        mvc.view("trackSelector").show(genreToSearch);

        mvc.output().show("End of list-ening.");
    }


}


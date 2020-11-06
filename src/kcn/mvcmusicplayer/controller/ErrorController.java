package kcn.mvcmusicplayer.controller;

import kcn.mvcmusicplayer.view.Console;
import kcn.mvcmusicplayer.view.IPresent;

import java.util.Objects;

public class ErrorController implements IErrorController
{
    private IPresent presenter;

    @Override
    public void setPresenter(IPresent output)
    {
        presenter = output;
    }

    @Override
    public void printError(Exception e, String message)
    {
        String builtMessage = "\n\tAn error occurred:" + e.getMessage() + "n";

        presenter().show(builtMessage);
    }

    public IPresent presenter()
    {
        if(Objects.isNull(presenter))
        {
            return new Console(System.out);
        } else{return presenter;}
    }
}

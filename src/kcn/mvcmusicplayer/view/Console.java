package kcn.mvcmusicplayer.view;

import kcn.mvcmusicplayer.controller.IController;

import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class Console implements IPresent
{
    PrintStream stream;

    private String topLine;
    private String mainField;
    private String bottomLine;

    public Console(PrintStream printStream)
    {
        stream = printStream;
    }

    @Override
    public void show()
    {
        stream.println("\n<>");
    }

    @Override
    public void show(String string)
    {
        stream.println(string);
    }

    /* method is useless in this implementing class, hinting that further interface segregation should happen */
    @Override
    public IView injectController(IController controller)
    {
        return this;
    }

    @Override
    public void setTopLine(String topLine)
    {

    }

    @Override
    public void setMainField(String mainField)
    {

    }

    @Override
    public void setBottomLine(String bottomLine)
    {

    }
}

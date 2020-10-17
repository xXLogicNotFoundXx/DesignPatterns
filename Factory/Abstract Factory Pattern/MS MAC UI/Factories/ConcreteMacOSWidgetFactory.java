public class ConcreteMacOSWidgetFactory implements AbstractWidgetFactory
{
    @Override
    public AbstractButton createButton()
    {
        AbstractButton button = new ConcreteMacOSButton();
        System.out.println("creation of "+button.printButtonType());
        return button;
    }

    @Override
    public AbstractMenu createMenu()
    {
        AbstractMenu menu = new ConcreteMacOSMenu();
        System.out.println("creation of "+menu.printMenuType());
        return menu;
    }
}

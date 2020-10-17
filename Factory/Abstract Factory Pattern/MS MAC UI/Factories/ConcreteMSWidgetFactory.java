public class ConcreteMSWidgetFactory implements AbstractWidgetFactory
{
    @Override
    public AbstractButton createButton()
    {
        AbstractButton button = new ConcreteMSButton();
        System.out.println("creation of "+button.printButtonType());
        return button;
    }

    @Override
    public AbstractMenu createMenu()
    {
        AbstractMenu menu = new ConcreteMSMenu();
        System.out.println("creation of "+menu.printMenuType());
        return menu;
    }
}

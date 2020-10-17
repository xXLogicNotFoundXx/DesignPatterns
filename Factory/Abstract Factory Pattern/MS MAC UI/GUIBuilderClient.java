public class GUIBuilderClient
{
    public void buildElements(AbstractWidgetFactory abstractWidgetFactory)
    {
        abstractWidgetFactory.createWindow();
        abstractWidgetFactory.createButton();
        abstractWidgetFactory.createMenu();
    }
}

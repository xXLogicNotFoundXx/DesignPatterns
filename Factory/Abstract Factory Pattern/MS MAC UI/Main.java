public class Main {

    public static void main(String[] args) {
	      GUIBuilderClient guiBuilder=new GUIBuilderClient();

	      System.out.println("abstractWidgetFactory becomes concreteMSWidgetFactory");
        AbstractWidgetFactory abstractWidgetFactory=new ConcreteMSWidgetFactory();
        guiBuilder.buildElements(abstractWidgetFactory);

        System.out.println("abstractWidgetFactory becomes concreteMacOSWidgetFactory");
        abstractWidgetFactory=new ConcreteMacOSWidgetFactory();
        guiBuilder.buildElements(abstractWidgetFactory);
    }
}

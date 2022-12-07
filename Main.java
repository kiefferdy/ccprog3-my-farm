import MyFarmController.Controller;
import MyFarmModel.Model;
import MyFarmView.MainView;

public class Main {
    public static void main(String[] args) {
        MainView view = new MainView();
        Model model = new Model();

        new Controller(view, model);
    }
}
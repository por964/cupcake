package CupcakeUtil;

import FunctionLayer.Bottom;
import FunctionLayer.LogicFacade;
import FunctionLayer.Topping;

import java.util.List;

//test

public class Initializer {

    private static List<Bottom> bottomList = null;
    private static List<Topping> topList = null;

    public static List<Bottom> getBottomList() {
        if (bottomList == null) {
            try {
                bottomList = LogicFacade.getBottoms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bottomList;
    }

    public static List<Topping> getTopList() {
        if (topList == null) {
            try {
                topList = LogicFacade.getTops();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return topList;
    }
}

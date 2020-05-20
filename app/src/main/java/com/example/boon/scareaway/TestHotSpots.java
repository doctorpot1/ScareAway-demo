package com.example.boon.scareaway;

import java.util.ArrayList;

public class TestHotSpots {
    private ArrayList<HotSpot> hotSpots;

    public TestHotSpots() {
        hotSpots = new ArrayList<>();
        hotSpots.add(new HotSpot(1.4287, 103.8361, 100, "Northpoint City", "18 cases", "r"));
        hotSpots.add(new HotSpot(1.4284, 103.8522, 100, "Melody Springs Construction Site", "70 cases", "r"));
        hotSpots.add(new HotSpot(1.4423, 103.8364, 50, "515 Yishun Industrial Park A", "14 cases", "o"));
        hotSpots.add(new HotSpot(1.4598, 103.8201, 50, "Cochrane Lodge I", "285 cases", "r"));
        hotSpots.add(new HotSpot(1.4614, 103.8180, 60, "Cochrane Lodge II", "387 cases", "r"));
        hotSpots.add(new HotSpot(1.4606, 103.8114, 30, "Acacia Home", "17 cases", "y"));
        hotSpots.add(new HotSpot(1.4615, 103.8095, 60, "Westlite Woodlands Dormitory", "153 cases", "r"));
        hotSpots.add(new HotSpot(1.4590, 103.8068, 60, "7 Senoko S Rd", "3 cases", "y"));
        hotSpots.add(new HotSpot(1.4664, 103.8126, 60, "13 Senoko Way", "143 cases", "o"));
    }

    public ArrayList<HotSpot> getHotSpots() {
        return hotSpots;
    }

    public void setHotSpots(ArrayList<HotSpot> hotSpots) {
        this.hotSpots = hotSpots;
    }

}

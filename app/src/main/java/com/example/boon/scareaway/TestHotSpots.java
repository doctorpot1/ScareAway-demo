package com.example.boon.scareaway;

import java.util.ArrayList;

public class TestHotSpots {
    private ArrayList<HotSpot> hotSpots;

    public TestHotSpots() {
        hotSpots = new ArrayList<>();
        hotSpots.add(new HotSpot(1.4287, 103.8361, 100, "Northpoint City (Very High Risk)", "18 cases", "r"));
        hotSpots.add(new HotSpot(1.4284, 103.8522, 100, "Melody Springs Construction Site (Very High Risk)", "70 cases", "r"));
        hotSpots.add(new HotSpot(1.4423, 103.8364, 50, "515 Yishun Industrial Park A (High Risk)", "14 cases", "o"));
        hotSpots.add(new HotSpot(1.4598, 103.8201, 50, "Cochrane Lodge I (Very High Risk)", "285 cases", "r"));
        hotSpots.add(new HotSpot(1.4614, 103.8180, 60, "Cochrane Lodge II (Very High Risk)", "387 cases", "r"));
        hotSpots.add(new HotSpot(1.4606, 103.8114, 30, "Acacia Home (Risky)", "17 cases", "y"));
        hotSpots.add(new HotSpot(1.4615, 103.8095, 60, "Westlite Woodlands Dormitory (Very High Risk)", "153 cases", "r"));
        hotSpots.add(new HotSpot(1.4590, 103.8068, 60, "7 Senoko S Rd (Risky)", "3 cases", "y"));
        hotSpots.add(new HotSpot(1.4664, 103.8126, 60, "13 Senoko Way (High Risk)", "143 cases", "o"));
    }

    public ArrayList<HotSpot> getHotSpots() {
        return hotSpots;
    }

    public void setHotSpots(ArrayList<HotSpot> hotSpots) {
        this.hotSpots = hotSpots;
    }

}

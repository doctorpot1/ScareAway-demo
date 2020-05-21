package com.example.boon.scareaway;

import java.util.ArrayList;

public class TestHotSpots {
    private ArrayList<HotSpot> hotSpots;

    public TestHotSpots() {
        hotSpots = new ArrayList<>();
        hotSpots.add(new HotSpot(1.4287, 103.8361, 100, "Northpoint City\n(Very High Risk)", "18 cases", "r"));
        hotSpots.add(new HotSpot(1.4284, 103.8522, 100, "Melody Springs Construction Site\n(Very High Risk)", "70 cases", "r"));
        hotSpots.add(new HotSpot(1.4423, 103.8364, 50, "515 Yishun Industrial Park A\n(High Risk)", "14 cases", "o"));
        hotSpots.add(new HotSpot(1.4598, 103.8201, 50, "Cochrane Lodge I\n(Very High Risk)", "285 cases", "r"));
        hotSpots.add(new HotSpot(1.4614, 103.8180, 60, "Cochrane Lodge II\n(Very High Risk)", "387 cases", "r"));
        hotSpots.add(new HotSpot(1.4606, 103.8114, 30, "Acacia Home\n(Risky)", "17 cases", "y"));
        hotSpots.add(new HotSpot(1.4615, 103.8095, 60, "Westlite Woodlands Dormitory\n(Very High Risk)", "153 cases", "r"));
        hotSpots.add(new HotSpot(1.4563, 103.7974, 60, "21B Senoko Loop\n(Very High Risk)", "177 cases", "r"));
        hotSpots.add(new HotSpot(1.4599, 103.8004, 100, "Hulett Dormitory\n(Very High Risk)", "464 cases", "r"));
        hotSpots.add(new HotSpot(1.4590, 103.8068, 60, "7 Senoko S Rd\n(Risky)", "3 cases", "y"));
        hotSpots.add(new HotSpot(1.4652, 103.8054, 60, "47 Senoko Dr\n(Risky)", "46 cases", "y"));
        hotSpots.add(new HotSpot(1.4664, 103.8126, 60, "13 Senoko Way\n(High Risk)", "143 cases", "o"));
        hotSpots.add(new HotSpot(1.4548, 103.8047, 60, "Woodlands Dormitory\n(High Risk)", "143 cases", "o"));
        hotSpots.add(new HotSpot(1.4664, 103.8078, 50, "61 Senoko Dr\n(High Risk)", "163 cases", "o"));
        hotSpots.add(new HotSpot(1.4545, 103.7973, 50, "36 Woodlands Industrial Park E1\n(High Risk)", "47 cases", "o"));
        hotSpots.add(new HotSpot(1.4547, 103.8046, 80, "Woodlands Dormitory\n(High Risk)", "146 cases", "o"));
        hotSpots.add(new HotSpot(1.4667, 103.8084, 40, "63 Senoko Dr\n(High Risk)", "64 cases", "o"));
        hotSpots.add(new HotSpot(1.4658, 103.8042, 40, "Proptech Pte Ltd\n(High Risk)", "59 cases", "o"));
        hotSpots.add(new HotSpot(1.4655, 103.8036, 30, "36 Senoko Rd\n(High Risk)", "40 cases", "o"));
        hotSpots.add(new HotSpot(1.4508, 103.8051, 60, "Lingjack Dormitory\n(High Risk)", "77 cases", "o"));
        hotSpots.add(new HotSpot(1.4509, 103.7994, 30, "64 Woodlands Industrial Park E9\n(Risky)", "40 cases", "y"));
        hotSpots.add(new HotSpot(1.4593, 103.7967, 30, "3 Senoko Link\n(Risky)", "46 cases", "y"));
        hotSpots.add(new HotSpot(1.4522, 103.7978, 30, "148 Woodlands Industrial Park E5\n(Risky)", "38 cases", "y"));
        hotSpots.add(new HotSpot(1.4548, 103.8027, 30, "29 Senoko S Rd\n(Risky)", "7 cases", "y"));
        hotSpots.add(new HotSpot(1.4534, 103.7952, 30, "7 Woodlands Industrial Park E1\n(Risky)", "13 cases", "y"));
        hotSpots.add(new HotSpot(1.4536, 103.7957, 30, "11 Woodlands Industrial Park E1\n(Risky)", "11 cases", "y"));
        hotSpots.add(new HotSpot(1.4535, 103.7954, 30, "9 Woodlands Industrial Park E1\n(High Risk)", "30 cases", "o"));
        hotSpots.add(new HotSpot(1.4533, 103.7950, 30, "5 Woodlands Industrial Park E1\n(Risky)", "16 cases", "y"));
        hotSpots.add(new HotSpot(1.4532, 103.7949, 30, "2 Woodlands Industrial Park E1\n(Risky)", "35 cases", "y"));
        hotSpots.add(new HotSpot(1.4566, 103.7932, 30, "1 North Coast Drive\n(Risky)", "11 cases", "y"));
        hotSpots.add(new HotSpot(1.4523, 103.7929, 80, "SJ Dormitory\n(Very High Risk)", "204 cases", "r"));
        hotSpots.add(new HotSpot(1.4609, 103.8245, 80, "Alaunia Lodge\n(Very High Risk)", "249 cases", "r"));
        hotSpots.add(new HotSpot(1.4517, 103.7930, 30, "182 Woodlands Industrial Park E5\n(High Risk)", "65 cases", "o"));
        hotSpots.add(new HotSpot(1.4510, 103.7927, 30, "212 Woodlands Industrial Park E5\n(High Risk)", "26 cases", "o"));
    }

    public ArrayList<HotSpot> getHotSpots() {
        return hotSpots;
    }

    public void setHotSpots(ArrayList<HotSpot> hotSpots) {
        this.hotSpots = hotSpots;
    }
}

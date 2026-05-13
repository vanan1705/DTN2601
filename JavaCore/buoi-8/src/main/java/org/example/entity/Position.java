package org.example.entity;


import org.example.enums.PositionEnum;

public class Position {
    private int positionID;
    private PositionEnum positionName;

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public PositionEnum getPositionName() {
        return positionName;
    }

    public void setPositionName(PositionEnum positionName) {
        this.positionName = positionName;
    }
    public Position() {
    }

    public Position(int positionID, PositionEnum positionName) {
        this.positionID = positionID;
        this.positionName = positionName;
    }
    @Override
    public String toString() {
        return String.valueOf( positionName);
    }
}

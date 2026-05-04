package entity;

import enums.TypeEnum;

public class TypeQuestion {
    private int typeID;
    private TypeEnum typeName;

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public TypeEnum getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeEnum typeName) {
        this.typeName = typeName;
    }

    public TypeQuestion(int typeID, TypeEnum typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }
}

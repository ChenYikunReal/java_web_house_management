package entity;

/**
 * 房屋类型实体类
 */
public class HouseType {

    private int typeId;

    private String typeName;

    public HouseType() {}

    public HouseType(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}

package lowlevelDesign;

public enum Money {
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100);

    public int value;

    Money(int value){
        this.value = value;
    }
}

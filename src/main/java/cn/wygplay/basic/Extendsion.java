package cn.wygplay.basic;

public class Extendsion {
    private String name = "wygplay";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class SubExtendsion extends Extendsion {
    public static void main(String[] args) {
        SubExtendsion subExtendsion = new SubExtendsion();
        System.out.println(subExtendsion.name);
    }
}

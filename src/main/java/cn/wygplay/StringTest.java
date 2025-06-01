package cn.wygplay;


public class StringTest {
    public static void main(String[] args) {
        String str = "play";
        System.out.println(str.toLowerCase());
        ClassLoader classLoader = StringTest.class.getClassLoader();
        String c = "play";
        System.out.println(str == c);
        test();
    }

    private static int test() {
        int temp = 1;
        try {
            System.out.println(temp);
            return ++temp;
        } catch (Exception e) {
            System.out.println(temp);
            return ++temp;
        } finally {
            ++temp;
            System.out.println(temp);
        }
    }
}

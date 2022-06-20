package cn.wygplay.java8feature.functions;

/**
 * 功能函数测试
 * @author wyg
 * @date 2022/6/19 17:48
 */
public class FunctionInterfaceTest {
    public static void main(String[] args) {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("456");
        System.out.println(converted);
    }
}


package lang;

import cn.wygplay.model.Person;
import cn.wygplay.model.Student;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author wyg
 * @date 2023/2/3 10:24
 */
public class ClassTest {

    @Test
    void getInterfaces() {
        Student student = new Student();
        List<Class<?>> interfaces = Arrays.asList(student.getClass().getInterfaces());
        assertTrue(interfaces.contains(Person.class));
    }

    @Test
    void leetCode() {
        System.out.println(lengthOfLongestSubstring("uqinntq"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int head = 0;
        int tail = 1;
        int max = 1;
        int tmp = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        while (tail < s.length()) {
            char headChar = s.charAt(head);
            char tailChar = s.charAt(tail);
            map.put(headChar, head);
            if (map.get(tailChar) != null && map.get(tailChar) >= head)  {
                head = map.get(tailChar) + 1;
                map.put(headChar, null);
                tmp = tail - head + 1;
            } else {
                tmp++;
            }
            map.put(tailChar, tail);
            tail++;
            max = max > tmp ? max : tmp;
        }
        return max;
    }

}

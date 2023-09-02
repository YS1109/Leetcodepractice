package question11_20;


import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 */
public class Q12 {

    /**
     * 直接构建字典
     * 用贪心算法倒着匹配也可以
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        Map<Integer, String> dict = new HashMap<>();
        dict.put(0,"");
        dict.put(1,"I");
        dict.put(2,"II");
        dict.put(3,"III");
        dict.put(4,"IV");
        dict.put(5,"V");
        dict.put(6,"VI");
        dict.put(7,"VII");
        dict.put(8,"VIII");
        dict.put(9,"IX");
        dict.put(10,"X");
        dict.put(20,"XX");
        dict.put(30,"XXX");
        dict.put(40,"XL");
        dict.put(50,"L");
        dict.put(60,"LX");
        dict.put(70,"LXX");
        dict.put(80,"LXXX");
        dict.put(90,"XC");
        dict.put(100,"C");
        dict.put(200,"CC");
        dict.put(300,"CCC");
        dict.put(400,"CD");
        dict.put(500,"D");
        dict.put(600,"DC");
        dict.put(700,"DCC");
        dict.put(800,"DCCC");
        dict.put(900,"CM");
        dict.put(1000,"M");
        dict.put(2000,"MM");
        dict.put(3000,"MMM");

        StringBuilder result = new StringBuilder();
        int base = 1000;
        while (base != 0) {
            result.append(dict.get((num / base) * base));
            num = num % base;
            base = base / 10;
        }
        return result.toString();
    }
}

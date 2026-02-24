public class SecondTest {
    static void main(String[] args) {
        String name = "Vladislav";
        String name2 = "Vladislav";
        String name3 = new String("Vladislav");
        String name4 = "Hello";
        String name5 = name + ", " + name4;

        System.out.println(name == name2);
        System.out.println(name2 == name3);
        System.out.println(name3.equals(name2));
        System.out.println(name.equals(name2));
        System.out.println(name5);
    }
}

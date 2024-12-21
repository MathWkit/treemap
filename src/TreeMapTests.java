public class TreeMapTests {
    public static void main(String...args) {
        testAddAndGetters();
    }

    public static void testAddAndGetters() {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.add(1, "Котенок");
        map.add(2, "Тигр");
        map.add(3, "Пингвин");
        map.add(4, "Тюлень");
        map.add(5, "Лев");
        map.add(6, "Волк");

        assert map.getValue(1) == "Котенок" : "jidsfi";

        assert Objects.equals(map.getValue(2), "Тигр");
        assert Objects.equals(map.getValue(3), "Пингвин");
        assert Objects.equals(map.getValue(4), "Тюлень");
        assert Objects.equals(map.getValue(5), "Лев");
        assert Objects.equals(map.getValue(6), "Волк");
    }
}

package Data_Structure.Tree.Binary;

public class Main {
    public static void main(String[] args) {
        BinarySearch bi = new BinarySearch();

        bi.add(55);
        bi.add(45);
        bi.add(47);
        bi.add(43);
        bi.add(54);
        bi.add(58);
        bi.add(76);
        bi.add(71);
        bi.add(50);
        bi.add(60);
        bi.add(68);
        bi.add(80);
        bi.add(91);

        System.out.println(bi.remove(91));
        System.out.println(bi.find(91));
        System.out.println(bi.contains(91));
        System.out.println("This should be greater than 50 " +bi.printGreater());


    }
}

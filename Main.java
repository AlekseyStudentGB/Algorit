public class Main {
    public static void main(String[] args) {

        Hash t = new Hash<>();
        System.out.println(t.getSize());
        System.out.println(t.getLength());
        t.add(1,1);
        t.add(5,5);
        t.add(4,4);
        t.add(2,2);

        System.out.println(t.getSize());
        System.out.println(t.getLength());
        t.print();

    }
}

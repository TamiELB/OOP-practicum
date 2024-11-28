package Prac1;

public class RandomNum {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++)
            System.out.println(Math.random());

        Zagen z = new Zagen();

        z.test = "test2";

        System.out.println(z.test);
    }
}

public class Main {
    public static void main(String[] args) {
        SinCounter count = new SinCounter();
        //float[] y = count.firstOrder();

        //float[] y = count.firstOrder();
        //float[] y = count.secondOrder();
        float[] y = count.fourthOrder();
        count.printY(y);


    }
}

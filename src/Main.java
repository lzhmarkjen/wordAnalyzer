public class Main {
    public static void main(String[] args) {
        // write your code here
        System.out.println("Start");

        try {
            Line string = new Line(Inputer.read("/home/lzhmark/桌面/test.txt"));
            string.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
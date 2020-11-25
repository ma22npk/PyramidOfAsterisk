
public class Main {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        int lineCount = 10; // 段数を指定


        for (int i = 0; i < lineCount; i++) {
            for (int j = 0; j < lineCount - (i + 1); j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < (i + 1) * 2 - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}

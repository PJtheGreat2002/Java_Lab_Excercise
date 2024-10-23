import java.util.Scanner;

public class AlphabetWarGame
{

    public AlphabetWarGame() {
    }
    public String AlphabetWar(String word) {
        int left_side = 0;
        int right_side = 0;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            left_side = left_side + getls(c);
            right_side = right_side + getrs(c);
        }
        return result(left_side, right_side);
    }

    public String AlphabetWar(String l_word, String r_word) {
        int left_side = 0;
        int right_side = 0;
        int rlen = r_word.length();
        int llen = l_word.length();
        for (int i = 0; i < llen; i++) {
            char c1 = l_word.charAt(i);
            left_side = left_side + getls(c1);
        }
        for (int i = 0; i < rlen; i++) {
            char c2 = r_word.charAt(i);
            right_side = right_side + getrs(c2);
        }
        return result(left_side, right_side);
    }

    int getls(char left) {
        return (left == 'w') ? 4 :
               (left == 'p') ? 3 :
               (left == 'b') ? 2 :
               (left == 's') ? 1 : 0;
    }

    int getrs(char right) {
        return (right == 'j') ? 4 :
               (right == 'a') ? 3 :
               (right == 'i') ? 2 :
               (right == 'n') ? 1 : 0;
    }

    public String result(int left_side, int right_side) {
        if (left_side > right_side) {
            return "Left side wins!";
        } else if (right_side > left_side) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word for Alphabet War:");
        String word = sc.nextLine();

        AlphabetWarGame obj = new AlphabetWarGame();
        System.out.println(obj.AlphabetWar(word));
        sc.close();
    }
}
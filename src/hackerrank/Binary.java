package hackerrank;

public class Binary {

    public static void main(String[] args) {
        int i = 6;

        int current = i;
        int counter = 0;
        int max = 0;
        while(current != 0){
            if(current %2 == 1) counter++;
            else {
                if(counter > max) max = counter;
                counter = 0;
            }
            System.out.println(current%2);
            current /=2;
        }
        if(counter > max) max = counter;
        System.out.println(max);
    }
}

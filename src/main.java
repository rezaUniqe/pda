import java.io.IOException;

public class main {



    public static void main(String[] args) {
        try {

            Input input = new Input();
            pda pda=new pda(input.getInput());
            System.out.println( pda.hasPdaPath());




        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

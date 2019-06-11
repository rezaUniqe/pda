import java.io.*;
import java.util.ArrayList;


/*this class is used for getting our input from the file and turn it to arraylist of strings in case each line of
our input i a node of our graph and it goes to our arraylist.
*/
class Input {

    private FileInputStream fis;
    private InputStreamReader isr;
    private BufferedReader br;

    Input() throws FileNotFoundException {
        fis = new FileInputStream("D:/class project/pda/dc.txt"); //used to read each byte;
        isr = new InputStreamReader(fis);//turn each byte to characters.
        br = new BufferedReader(isr);//turn characters in to string.
    }

    ArrayList<String> getInput() throws IOException {
        ArrayList<String> dataInput = new ArrayList<>();    //this arraylist used to save our node property that had been got from the each line of file.
        String temp = br.readLine();
        while (temp != null) {
            dataInput.add(temp);
            temp = br.readLine();

        }
        br.close();
        return dataInput;
    }


}

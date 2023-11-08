import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import javafx.scene.text.Text;

public class wordBank {
	private int wordSizeLower;
	private int wordSizeUpper;
	
	private ArrayList<String> list = new ArrayList<String>();
	private ArrayList<String> listFiltered = new ArrayList<String>();
	
	wordBank() {

	}
	
	public ArrayList<String> createWordBank(String givenFileName) throws FileNotFoundException {
	
        File wordBankFile = new File("WordList.txt");
        Scanner read = new Scanner(wordBankFile);
        String word;
        
        while (read.hasNextLine() == true) {
            
        	word = read.nextLine();
        	list.add(word);
        
        }
        
		
        read.close();
        return list;
      
	}

	
	public String randomWord(int givenWordSizeLower, int givenWordSizeUpper) {
		
		wordSizeLower = givenWordSizeLower;
		wordSizeUpper = givenWordSizeUpper;
		
		String randomWord = " ";
		
		for (int index = 0; index < list.size(); index++) {
			if ((list.get(index)).length() > wordSizeLower && (list.get(index)).length() < wordSizeUpper) {
				listFiltered.add(list.get(index));
			}

		}
		
    	
    		int index = (int)(Math.random() * listFiltered.size());
    		randomWord = listFiltered.get(index);
 

    	listFiltered.clear();
   
    	
		return randomWord;
		
		

	}
	
	
}

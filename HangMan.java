public class HangMan{
    private int tries;
    private String word;
    private String revealed;
    private String guessed;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public HangMan(String word,int tries){
        this.word = word;
        this.tries = tries;
        this.revealed = "";
        this.guessed = "";
        for(int i = 0; i < word.length(); i++){
        	if(ALPHABET.contains(word.substring(i,i+1).toLowerCase())) {
        		revealed = revealed + "_";
        	}
        	else {
        		revealed = revealed + word.substring(i,i+1);
        	}
        }
        for(int i = 0; i < ALPHABET.length();i++) {
        	guessed = guessed + " ";
        }
    }
    public void update(){
        System.out.println("Number of mis-guesses left: " + tries);
        System.out.println("What You Have Revealed So Far: " + revealed);
        System.out.println("Letters You Have Guessed: " + guessed);
    }
    public int isLetter(char guess){
        for(int i = 0; i < guessed.length();i++){
            if (guessed.charAt(i) == guess){
                return 0;
            }
        }
        for(int i = 0; i < ALPHABET.length(); i++) {
        	if(ALPHABET.charAt(i) == guess) {
        		 for(int k = 0; k < word.length(); k++){
        	         if(word.toLowerCase().charAt(k) == guess){
        	            return 2;
        	         }
        		 }
        		 return 1;
        	}
        }
       return 0;
        
    }
    public void updateLetter(char guess){
        for (int i = 0; i < word.length(); i++){
            if(word.toLowerCase().charAt(i) == guess){
                revealed = revealed.substring(0,i) + guess + revealed.substring(i+1,revealed.length());
            }
        }
        for(int i = 0; i < ALPHABET.length();i++) {
        	if(ALPHABET.charAt(i) == guess) {
        		guessed = guessed.substring(0,i) + guess + guessed.substring(i+1,guessed.length());
        	}
        }
    }
    public void subtractTries() {
    	tries--;
    }
    public int winCondition(){
        if (tries <= 0){
            return 0;
        }
        for(int i = 0; i < revealed.length();i++){
            if(revealed.charAt(i) == '_'){
                return 1;
            }
        }
        return 2;
    }
}


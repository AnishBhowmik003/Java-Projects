
public class Word {
	String mword;
	public Word() {
		mword = "";
	}
	
	public Word(String w) {
		mword = w;
	}
	
	private boolean isVowel(char c) {
		char cc = Character.toLowerCase(c);
		if(cc == 'a' || cc == 'e' || cc == 'i' || cc == 'o' || cc == 'u' || cc == 'y') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getSyllables() {
		int s = 0;
		for(int i = 0; i < mword.length(); i++) {
			if((isVowel(mword.toCharArray()[i]) == true)) {
				s++;
				if(i != mword.length() - 1 && isVowel(mword.toCharArray()[i+1])) {
					i++;
				}
			}
			
			if(i == mword.length() - 1 && mword.toCharArray()[i] == 'e') {
				s = s - 1;
			}
			
		}
		if(s <= 0) {
			s = 1;
		}
		return s;
	}
	
	public char[] getArrChars() {
		char[] cs = new char[mword.length()];
		cs = mword.toCharArray();
		return cs;
	}
	
	public String output() {
		return mword;
	}
}
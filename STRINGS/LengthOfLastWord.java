public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] words=s.trim().split("\\s+");
        String lastWord=words[words.length-1];
        return lastWord.length();
    }
}

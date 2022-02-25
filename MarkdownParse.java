// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            //if [ open bracket is not found, there are no links thus return.
            if (nextOpenBracket == -1){
                return toReturn;
            }
            if (markdown.indexOf("!") == nextOpenBracket-1){
                return toReturn;
            }
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            if (nextCloseBracket == -1){
                return toReturn;
            }
            int openParen = markdown.indexOf("(", nextCloseBracket);
            //if ( open parenthesis is not found, there are no links thus return.
            if (openParen == -1){
                return toReturn;
            }
            if (openParen != nextCloseBracket+1){
                return toReturn;
            }
            int closeParen = markdown.indexOf(")", openParen);
            if (closeParen == -1){
                return toReturn;
            }
            if (markdown.indexOf("`") < nextOpenBracket && markdown.indexOf("`") != -1){
                return toReturn;
            }
            if (markdown.contains("`")){
                currentIndex = closeParen + 1;
                String MDsubstring = markdown.substring(openParen + 1, closeParen);
                String fix = MDsubstring.replace("`", "%60");
                toReturn.add(fix);
                continue;
            }
            currentIndex = closeParen + 1;
            toReturn.add(markdown.substring(openParen + 1, closeParen));
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}
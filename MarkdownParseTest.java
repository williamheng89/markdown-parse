import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void subtraction(){
        assertEquals(4, 5 - 1);
    }

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    @Test
    public void testFile2() throws IOException {
        String contents= Files.readString(Path.of("./test-file2.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    @Test
    public void testFile3() throws IOException {
        String contents= Files.readString(Path.of("./test-file3.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    @Test
    public void testFile4() throws IOException {
        String contents= Files.readString(Path.of("./test-file4.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    @Test
    public void testFile5() throws IOException {
        String contents= Files.readString(Path.of("./test-file5.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    @Test
    public void testFile6() throws IOException {
        String contents= Files.readString(Path.of("./test-file6.md"));
        List<String> expect = List.of();
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
    @Test
    public void testFile7() throws IOException {
        String contents= Files.readString(Path.of("./test-file7.md"));
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    @Test 
    public void snippet1() throws IOException{
        String contents= Files.readString(Path.of("./snippet-1.md"));
        List<String> expect = List.of("%60google.com", "google.com", "ucsd.edu");
        assertEquals(MarkdownParse.getLinks(contents), expect);    
    }
    @Test 
    public void snippet2() throws IOException{
        String contents= Files.readString(Path.of("./snippet-2.md"));
        List<String> expect = List.of("a.com", "a.com(())", "example.com");
        assertEquals(MarkdownParse.getLinks(contents), expect);    
    }
    @Test 
    public void snippet3() throws IOException{
        String contents= Files.readString(Path.of("./snippet-3.md"));
        List<String> expect = List.of("https://ucsd-cse15l-w22.github.io/");
        assertEquals(MarkdownParse.getLinks(contents), expect);    
    }


//     @Test
//     public void testFile8() throws IOException {
//         String contents= Files.readString(Path.of("./test-file8.md"));
//         List<String> expect = List.of("a link on the first line");
//         assertEquals(MarkdownParse.getLinks(contents), expect);
//     }
    //some random edit
    
}

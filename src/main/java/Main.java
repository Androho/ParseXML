import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

import java.io.*;
import java.nio.charset.Charset;


public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        File file = new File("/Users/Piter/IdeaProjects/ParseXML/src/main/resources/cat.xml");
        String url="https://s2.ho.ua/fm.cgi?action=view&file=htdocs/pics_silv/";
        String newUrl;
        try {
             fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Document doc = Jsoup.parse(fis, "CP1251", "", Parser.xmlParser());
        for(Element e: doc.getElementsByTag("image")){
            e.html(e.html().replace(e.text(),url+e.text()));
        }
        System.out.println(doc.toString());
        FileWriter fileWriter =new FileWriter("/Users/Piter/IdeaProjects/ParseXML/src/main/resources/newCat.xml", Charset.forName("UTF-8"));
        fileWriter.write(doc.toString());
    }
}
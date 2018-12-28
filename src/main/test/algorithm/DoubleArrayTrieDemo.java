package algorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liujun
 *双数组trie树Demo
 */
public class DoubleArrayTrieDemo {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("F:/small.dic");
        BufferedReader bf = new BufferedReader(fr);
        List<String> word = new ArrayList<>();
        Set<Character> characters = new HashSet<>();
        String line = "";
        while ((line = bf.readLine())!=null) {
            word.add(line);
            for (Character c: line.toCharArray()) {
                characters.add(c);
            }
        }
        String infoCharacterValue = "";
        String infoCharacterCode = "";
        for (Character character : characters) {
            infoCharacterValue += character.charValue() + " ";
            infoCharacterCode += (int)character.charValue() + "  ";
        }
        infoCharacterValue += "\n";
        infoCharacterCode += "\n";
        System.out.print(infoCharacterValue);
        System.out.print(infoCharacterCode);
        DoubleArrayTrie doubleArrayTrie = new DoubleArrayTrie();
        System.out.println("是否错误：" + doubleArrayTrie.build(word));
        System.out.println(doubleArrayTrie);
        List<Integer> integerList = doubleArrayTrie.commonPrefixSearch("一举成名天下知");
        for (Integer index : integerList) {
            System.out.println(word.get(index));
        }
        bf.close();
        fr.close();
    }

}

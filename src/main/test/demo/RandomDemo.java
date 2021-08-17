package demo;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class RandomDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String random = StringUtils.lowerCase(RandomStringUtils.randomAlphabetic(16));
            System.out.println("project-" + random);
        }

    }

}

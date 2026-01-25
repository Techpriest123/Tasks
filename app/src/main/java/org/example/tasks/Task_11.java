package org.example.tasks;

import org.example.util.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class Task_11 implements Task {
    @Override
    public void run(Scanner scan) {
        System.out.print("Текст: ");
        String text = scan.nextLine();

        String longest = findLongest(text);
        System.out.println("Самое длинное предложение: " + longest);
    }

    private static String findLongest(String text) {
        if (text == null || text.trim().isEmpty()) {
            return "";
        }

        List<String> sent = split(text);
        String longest = "";
        int maxCnt = 0;

        for (String sentence : sent) {
            int wordCnt = countWords(sentence);
            if (wordCnt > maxCnt) {
                maxCnt = wordCnt;
                longest = sentence;
            }
        }

        return longest;
    }

    private static List<String> split(String text) {
        List<String> sent = new ArrayList<>();

        Pattern reg = Pattern.compile("(?<=[.!?])(?=\\s+|$)");
        String[] parts = reg.split(text);

        for (String part : parts) {
            String trimmed = part.trim();
            if (!trimmed.isEmpty()) {
                sent.add(trimmed);
            }
        }

        return sent;
    }

    private static int countWords(String sentence) {
        Pattern reg = Pattern.compile("[А-Яа-яA-Za-z0-9]+");
        Matcher matcher = reg.matcher(sentence);

        int cnt = 0;
        while (matcher.find()) {
            cnt++;
        }

        return cnt;
    }

    @Override
    public String getTitle() {
        return "Выбрать из текста самое длинное предложение";
    }

    @Override
    public String getDescription() {
        return """
                Выбирает из текста самое длинное предложение. Если в тексте несколько предложений
                одинаковой длины – выбирает самое первое. Длина предложения считается по количеству
                слов. Словом считается непрерывная последовательность символов (строчных и
                прописных) А-Я, A-Z и цифр. Концом предложения считаются символы точка, '!' и '?'.
                Началом предложения – любой символ, отличный от данных трех и пробела, первый
                после конца предыдущего предложения (или вообще первый в тексте)""";
    }

    @Override
    public String getTaskIndex() {
        return "11";
    }
}

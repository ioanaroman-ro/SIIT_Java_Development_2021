import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathMain {
    public static void main(String[] args) {
        BufferedReader bf;
        String initialInput = redFromFile("src/file.txt");

        // se ignora spatiile
        String input = initialInput.replaceAll(" ", "");

        // se verifica ultimul caracter
        char last = input.charAt(input.length() - 1);
        Boolean parantheses = Character.toString(last).matches("\\)");
        if (!Character.isDigit(last) && (!parantheses)) {
            throw new ValidationException("Incorrect number of tokens!");
        }

        // se transforma input in char pentru a usura verificarile
        char[] ch = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            ch[i] = input.charAt(i);
        }

        // se verifica daca toate parantezele se inchid
        int open = 0;
        int close = 0;
        for (char c : ch) {
            if (c == '(') {
                open += 1;
            } else {
                if (c == ')') {
                    close += 1;
                }
            }
        }
        if (open != close) {
            throw new ValidationException("Incorrect parenthesis!");
        }

        // se verifica sa fie numar corect de operanzi
        List<String> operators = new ArrayList<>();
        operators.addAll(Arrays.asList("+", "-", "/", "*"));

        for (int i = 0; i < ch.length - 1; i++) {
            if (operators.contains(Character.toString(ch[i])) && operators.contains(Character.toString(ch[i + 1]))) {
                throw new ValidationException("Incorrect number of operands");
            }
        }

        // Am folosit libraria exp4j-0.4.8.jar disponibila la https://www.objecthunter.net/exp4j/download.html
        Expression e = new ExpressionBuilder(input)
                .build();
        double result = e.evaluate();
        System.out.println(result);

    }


    public static String redFromFile(String path) {
        String result = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            result = br.readLine();
        } catch (FileNotFoundException | ArithmeticException e) {
            System.out.println("Nu se poate deschide fisierul..");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }


}

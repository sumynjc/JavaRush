package com.javarush.test.level04.lesson16.home02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *JavaRush.ru
 *Level 04, Lesson 16, Home 02
 *
 * Ввести с клавиатуры три числа, вывести на экран среднее из них. Т. е. не самое большое и
 * не самое маленькое.
 *
 * Date: 20.01.13 
 * @author Sergey Kandalintsev
 */
public class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sFirst = br.readLine();
        String sSecond = br.readLine();
        String sThird = br.readLine();
        int nFirst = Integer.parseInt(sFirst);
        int nSecond = Integer.parseInt(sSecond);
        int nThird = Integer.parseInt(sThird);
        System.out.println(middleNumber(nFirst, nSecond, nThird));

    }
    public static int middleNumber(int a, int b, int c) {
        int tmp;
        if (a > b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        if (b > c) {
            b = c;
        }
        if (a > b) {
            b = a;
        }
        return b;
    }
}

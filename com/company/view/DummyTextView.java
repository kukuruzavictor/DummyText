package com.company.view;

import java.util.Scanner;

public class DummyTextView {

    private Scanner sc = new Scanner (System.in);

    public void wordCounter3 (int counter){
        System.out.println("      слів з 3 символів: "+counter);
    }

    public void wordCounter5 (int counter){
        System.out.println("      слів з 5 символів: "+counter);
    }

    public void wordCounter7 (int counter){
        System.out.println("      слів з 7 символів: "+counter);
    }

    public void sentenceCounter (int counter){
        System.out.println("                 речень: "+counter);
    }

    public void sumDates (int i){
        System.out.println("                    дат: "+i);
    }

    public void numbers (int i){
        System.out.println("        сума всіх чисел: "+i);
    }

    public void sentence (String text, int index){
        System.out.println("            речення #"+index+": "+text);
    }

    public void sentenceReverse (String text, int index){
        System.out.println("  речення #"+index+" навиворіт: "+text);
    }

    public void transformation (){
        System.out.println("\nНатисніть ENTER щоб:");
        System.out.println("- кожне ДРУГЕ речення перевести до верхнього регістру");
        System.out.println("- в кожному ТРЕТЬОМУ реченні замінити голосні літери на символ *");
        System.out.println("- останні 3 речення об'єднати в одне, використовуючи коми");
        sc.nextLine();
    }

    public void printText (String text){
        System.out.println(text);
    }

}

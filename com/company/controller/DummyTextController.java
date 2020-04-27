package com.company.controller;

import com.company.model.DummyText;
import com.company.view.DummyTextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DummyTextController {
    private DummyTextView view = new DummyTextView();

    public void wordCounter3(DummyText text){
        int counter = 0;
        String regex = "\\b[a-zA-Z-']{3}\\b";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text.getText());
        while (m.find()){
            counter++;
        }
        view.wordCounter3(counter);
    }

    public void wordCounter5(DummyText text){
        int counter = 0;
        String regex = "\\b[a-zA-Z-']{5}\\b";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text.getText());
        while (m.find()){
            counter++;
        }
        view.wordCounter5(counter);
    }

    public void wordCounter7(DummyText text){
        int counter = 0;
        String regex = "\\b[a-zA-Z-']{7}\\b";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text.getText());
        while (m.find()){
            counter++;
        }
        view.wordCounter7(counter);
    }

    public void sentenceCounter(DummyText text){
        view.sentenceCounter(text.getTextArray().length);
    }

    public void sumDates (DummyText text){
        view.sumDates(date1(text)+date2(text));
    }

    public int date1(DummyText text){
        int counter = 0;
        String regex = "\\b[0-9]{2,}[0-9]+до н[.]е[.]\\B";       // '10000до н.е.'
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text.getText());
        while (m.find()){
            counter++;
        }
        return counter;
    }

    public int date2(DummyText text){
        int counter = 0;
        String regex = "\\b[12][0-9]{3}(-[01][1-9]-[0-3][0-9])?\\b"; // '1998' OR '2303-12-31'
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text.getText());
        while (m.find()){
            counter++;
        }
        return counter;
    }

    public void numbers(DummyText text){
        int result = 0;
        String regex = "\\b[0-9]{2,}\\b";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text.getText());
        String textnumber = "";
        while (m.find()){
            textnumber = text.getText().substring(m.start(),m.end());
            result+=Integer.parseInt(textnumber);
        }
        view.numbers(result);
    }

    public void sentence(DummyText text, int index){
        String sentence = text.getTextArray()[index-1].trim();
        view.sentence(sentence.substring(0,sentence.length()-1), index); ;
    }

    public void sentenceReverse(DummyText text, int index){
        String [] seventeen = text.getTextArray()[index-1].split("[ ]");
        String reverse = "";
        String buffer;
        for (int i =0; i<seventeen.length/2; i++ ){
            buffer = seventeen[i];
            seventeen[i]=seventeen[seventeen.length-1-i];
            seventeen[seventeen.length-1-i]=buffer;
        }
        for (int i=0; i<seventeen.length; i++){
            reverse+=seventeen[i]+" ";
        }
        view.sentenceReverse(reverse.substring(0,reverse.length()-1), index);
    }

    public void transformation (DummyText text){
        view.transformation();
        view.printText(lastThreeSentenceMerge(toConsonant(toUpperCase(text.getTextArray()))));

    }

    public String lastThreeSentenceMerge(String[] text){
        String result = "";
        for (int i=0; i<text.length; i++){
            if (i==text.length-2 || i==text.length-3){
                result+=text[i].substring(0, text[i].length()-2)+", ";
            } else {
                result+=text[i];
            }
        }
        return result;
    }

    public String[] toConsonant (String[] text){
        Pattern p = Pattern.compile("[aeiouyAEIOUY]");
        for (int i=2; i<text.length; i+=3){
            Matcher m = p.matcher(text[i]);
            StringBuffer sb = new StringBuffer();
            while (m.find()) {
                m.appendReplacement(sb, "*");
            }
            m.appendTail(sb);
            text[i]=sb.toString();
        }
        return text;
    }

    public String[] toUpperCase(String[] text){
        for (int i=1; i<text.length; i+=2){
            text[i]=text[i].toUpperCase();
        }
        return text;
    }
}

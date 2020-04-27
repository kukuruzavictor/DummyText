package com.company;

import com.company.controller.DummyTextController;
import com.company.model.DummyText;

public class Main {

    public static void main(String[] args) {
        DummyText text = new DummyText();
        DummyTextController controller = new DummyTextController();
        System.out.println("      У ТЕКСТІ ЗНАЙДЕНО:");
        controller.wordCounter3(text);
        controller.wordCounter5(text);
        controller.wordCounter7(text);
        controller.sentenceCounter(text);
        controller.sumDates(text);
        controller.numbers(text);
        controller.sentence(text, 17);
        controller.sentenceReverse(text,17);
        controller.transformation(text);
    }
}

package org.upper_lower_case.utils;

import java.util.logging.Logger;

public class InfoPrinter {
    private static final  String START_INFO = "Вітаю я переведу кожну парну літеру вашого рядка у верхній регістр, " +
            "а кожну непарну в нижній. Для виходу введіть \"exit\"";

    private static final String INPUT_STRING_PREFIX = "Ви ввели: ";
    private static final String OUTPUT_STRING_PREFIX = "Після перетворення: ";
    private final Logger logger;

    public InfoPrinter (){
        LoggerForConsoleOutput consoleOutput = LoggerForConsoleOutput.getInstance();
        logger = consoleOutput.getLogger(false);
    }

    public void getStartInfo(){
        logger.info(START_INFO);
    }

    public void getInputString(String input){
        logger.info(INPUT_STRING_PREFIX + input);
    }

    public void getOutputString(String output){
        logger.info(OUTPUT_STRING_PREFIX + output);
    }
}

package org.upper_lower_case.aspect;

import org.aspectj.lang.annotation.*;
import org.upper_lower_case.utils.InfoPrinter;

@Aspect
public class LogAspect {
    @Pointcut("execution(* org.upper_lower_case.CaseConvertor.getMessageFromUser())")
    public void inputLogging() {
    }
    @Pointcut("execution(* org.upper_lower_case.CaseConvertor.getStringFromSymbolsArray(String[]))")
    public void outputLogging() {
    }

    @AfterReturning(value = "inputLogging()", returning = "returningValue")
    public void beforeAdvice(String returningValue) {
        new InfoPrinter().getInputString(returningValue);
    }

    @AfterReturning(value = "outputLogging()", returning = "returningValue")
    public void beforeAdvice1(String returningValue) {
        new InfoPrinter().getOutputString(returningValue);
    }


}

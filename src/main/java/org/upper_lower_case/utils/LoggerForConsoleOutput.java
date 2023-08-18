package org.upper_lower_case.utils;

import java.util.logging.*;

public class LoggerForConsoleOutput {
    private Logger logger;
    private final static LoggerForConsoleOutput INSTANCE = new LoggerForConsoleOutput();

    private LoggerForConsoleOutput (){

    }

    public static LoggerForConsoleOutput getInstance (){
        return INSTANCE;
    }
    private void initLogger(){
        if (logger == null){
        logger = Logger.getLogger(this.getClass().getName());
        }
    }

    private Handler [] getLoggerHandlers(){
        return logger.getHandlers();

    }

    private void setupLoggingWithoutPrefix(){
        initLogger();

        if (getLoggerHandlers().length != 0) return;
        logger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter() {
            @Override
            public synchronized String format(LogRecord rec) {
                return rec.getMessage() + "\n";
            }
        });
        logger.addHandler(handler);
    }

    private void setupLoggingWithPrefix(){
        initLogger();
        Handler[] handlers = getLoggerHandlers();
        for (Handler handler : handlers) {
            logger.removeHandler(handler);
        }
        logger.setUseParentHandlers(true);

    }

    public Logger getLogger(boolean needPrefix){
        if (needPrefix){
            setupLoggingWithPrefix();
        }
        else {
            setupLoggingWithoutPrefix();
        }
        return logger;
    }
}

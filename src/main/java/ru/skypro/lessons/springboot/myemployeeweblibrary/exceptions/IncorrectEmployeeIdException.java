package ru.skypro.lessons.springboot.myemployeeweblibrary.exceptions;

public class IncorrectEmployeeIdException extends Exception{


    public IncorrectEmployeeIdException(String message) {
        super(message);
    }

    public IncorrectEmployeeIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectEmployeeIdException(Throwable cause) {
        super(cause);
    }

    public IncorrectEmployeeIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public IncorrectEmployeeIdException() {

    }
}

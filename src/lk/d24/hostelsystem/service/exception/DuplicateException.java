package lk.d24.hostelsystem.service.exception;

import javafx.scene.control.Alert;
import lk.d24.hostelsystem.service.custom.StudentService;
import lk.d24.hostelsystem.service.custom.impl.StudentServiceImpl;

import javax.swing.*;

public class DuplicateException extends RuntimeException{
    public DuplicateException(){
        System.out.println("Duplicate Entry ");
        JOptionPane.showMessageDialog(null, "", "Duplicate Entry", JOptionPane.ERROR_MESSAGE);
        Thread.currentThread().stop();  //stop exception thread after thrown
    }

    public DuplicateException(String message) {
        super(message);
        System.out.println("Duplicate Entry "+message);
        JOptionPane.showMessageDialog(null, message, "Duplicate Entry", JOptionPane.ERROR_MESSAGE);
        Thread.currentThread().stop();  //stop exception thread after thrown
    }

    public DuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateException(Throwable cause) {
        super(cause);
    }

    public DuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package edu.logos.exception;

public class StudentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -828690882803556686L;

    public StudentNotFoundException(String message) {
        super(message);
    }
}

package eu.ntig;

/** Invoke a HTTP return with a given code and message. */
public class ParamException extends Exception {

    private static final long serialVersionUID = 1L;

    /** HTTP return code, like 401. */
    public int httpCode;

    public ParamException(int httpCode, String message) {
        super(message);
        this.httpCode = httpCode;
    }
}


/* vim: set expandtab ts=4 sw=4: */

package rs.rmt.notes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class FileLengthException extends Exception {

    public FileLengthException(String s) {
        super(s);
    }
}

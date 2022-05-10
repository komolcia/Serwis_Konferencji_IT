package serwis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Specialization in database")
public class UzytkownikNotFoundException extends RuntimeException{
}

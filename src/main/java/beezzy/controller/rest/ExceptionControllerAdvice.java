package beezzy.controller.rest;

import beezzy.domain.response.Error;
import beezzy.domain.response.Response;
import beezzy.exceptions.ForbiddenException;
import beezzy.exceptions.WrongEmailException;
import beezzy.exceptions.WrongPasswordException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by oleh on 18.04.2016.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ForbiddenException.class)
    public @ResponseBody Response exception(ForbiddenException e){
        Response response = new Response();
        response.setError(buildError(
                HttpServletResponse.SC_UNAUTHORIZED,
                "You should authorize before request this resources"
        ));
        return response;
    }

    @ExceptionHandler(WrongEmailException.class)
    public @ResponseBody Response exception(WrongEmailException e){
        Response response = new Response();
        response.setError(buildError(
                HttpServletResponse.SC_BAD_REQUEST,
                "You send incorrect email"
        ));
        return response;
    }

    @ExceptionHandler(WrongPasswordException.class)
    public @ResponseBody Response exception(WrongPasswordException e){
        Response response = new Response();
        response.setError(buildError(
                HttpServletResponse.SC_BAD_REQUEST,
                "You send incorrect password"
        ));
        return response;
    }

    private Error buildError(int code, String message){
        Error error = new Error();
        error.setCode(code);
        error.setMessage(message);

        return error;
    }

}

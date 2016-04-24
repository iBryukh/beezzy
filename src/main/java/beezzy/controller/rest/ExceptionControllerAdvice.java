package beezzy.controller.rest;

import beezzy.domain.response.Error;
import beezzy.domain.response.Response;
import beezzy.exceptions.*;
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
                "You sent incorrect password"
        ));
        return response;
    }

    @ExceptionHandler(NoSuchUserException.class)
    public @ResponseBody Response exception(NoSuchUserException e){
        Response response = new Response();
        response.setError(buildError(
                HttpServletResponse.SC_BAD_REQUEST,
                e.getMessage()
        ));
        return response;
    }

    @ExceptionHandler(PasswordsDoNotMatchException.class)
    public @ResponseBody Response exception(PasswordsDoNotMatchException e){
        Response response = new Response();
        response.setError(buildError(
                HttpServletResponse.SC_BAD_REQUEST,
                e.getMessage()
        ));
        return response;
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public @ResponseBody Response exception(UserAlreadyExistException e){
        Response response = new Response();
        response.setError(buildError(
                HttpServletResponse.SC_BAD_REQUEST,
                e.getMessage()
        ));
        return response;
    }

    private Error buildError(int code, String message){
        Error error = new Error();
        error.setCode(code);
        error.setMessage(message);

        return error;
    }

    @ExceptionHandler(NoSuchShopException.class)
    public @ResponseBody Response exception(NoSuchShopException e){
        Response response = new Response();
        response.setError(buildError(
                HttpServletResponse.SC_BAD_REQUEST,
                e.getMessage()
        ));
        return response;
    }

}

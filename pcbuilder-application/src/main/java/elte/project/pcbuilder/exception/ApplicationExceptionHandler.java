package elte.project.pcbuilder.exception;

import elte.project.pcbuilder.controller.DetailsController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = {DetailsController.class})
public class ApplicationExceptionHandler {
    @ExceptionHandler(InvalidPathException.class)
    public String handleInvalidPathException(Exception e, Model model){
        model.addAttribute("errorMessage",e.getMessage());
        return "error";
    }
}

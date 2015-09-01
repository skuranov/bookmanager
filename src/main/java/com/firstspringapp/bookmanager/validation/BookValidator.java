package com.firstspringapp.bookmanager.validation;

import com.firstspringapp.bookmanager.domain.Book;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by zivert on 01.09.2015.
 */
@Component
public class BookValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object model, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","required.name","Name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"genre","required.genre","Genre is required.");
    }
}

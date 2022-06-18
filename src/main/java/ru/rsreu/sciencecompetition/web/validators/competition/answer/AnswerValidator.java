package ru.rsreu.sciencecompetition.web.validators.competition.answer;

import ru.rsreu.sciencecompetition.web.validators.NormalValidationResultable;
import ru.rsreu.sciencecompetition.web.validators.ValidationResultClasses;
import ru.rsreu.sciencecompetition.web.validators.ValidationResultable;
import ru.rsreu.sciencecompetition.web.validators.Validator;

public class AnswerValidator implements Validator<String> {

    @Override
    public ValidationResultable validate(String valueToValidate) {
        if ("".equals(valueToValidate.trim())) {
            return new ValidationResultable() {
                @Override
                public ValidationResultClasses getValidationClass() {
                    return ValidationResultClasses.ERROR;
                }

                @Override
                public String getDescription() {
                    return "Нельзя передавать пустое значение";
                }
            };
        }
        return new NormalValidationResultable();
    }
}

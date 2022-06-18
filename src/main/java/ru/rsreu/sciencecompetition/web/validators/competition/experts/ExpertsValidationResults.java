package ru.rsreu.sciencecompetition.web.validators.competition.experts;

import ru.rsreu.sciencecompetition.web.validators.ValidationResultClasses;
import ru.rsreu.sciencecompetition.web.validators.ValidationResultable;

public enum ExpertsValidationResults implements ValidationResultable {
    NO_EXPERTS{
        @Override
        public ValidationResultClasses getValidationClass() {
            return ValidationResultClasses.ERROR;
        }

        @Override
        public String getDescription() {
            return "Должен быть выбран как минимум 1 эксперт";
        }
    };
}

package ru.rsreu.sciencecompetition.web.validators.competition.strategy;

import ru.rsreu.sciencecompetition.web.validators.ValidationResultClasses;
import ru.rsreu.sciencecompetition.web.validators.ValidationResultable;

public enum StrategyValidatorResults implements ValidationResultable {
    VALUE_MUST_BE_EMPTY {
        @Override
        public ValidationResultClasses getValidationClass() {
            return ValidationResultClasses.ERROR;
        }

        @Override
        public String getDescription() {
            return "Значение должно быть пустым";
        }
    },
    VALUE_MUST_BE_INTEGER {
        @Override
        public ValidationResultClasses getValidationClass() {
            return ValidationResultClasses.ERROR;
        }

        @Override
        public String getDescription() {
            return "Значение должно быть положительным целым числом";
        }
    },
    VALUE_MUST_BE_FLOAT {
        @Override
        public ValidationResultClasses getValidationClass() {
            return ValidationResultClasses.ERROR;
        }

        @Override
        public String getDescription() {
            return "Значение должно быть положительным целым или вещественным числом";
        }
    }

}

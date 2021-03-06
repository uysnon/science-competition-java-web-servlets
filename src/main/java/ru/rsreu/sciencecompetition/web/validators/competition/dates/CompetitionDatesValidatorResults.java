package ru.rsreu.sciencecompetition.web.validators.competition.dates;

import ru.rsreu.sciencecompetition.web.validators.ValidationResultClasses;
import ru.rsreu.sciencecompetition.web.validators.ValidationResultable;

public enum CompetitionDatesValidatorResults implements ValidationResultable {
    DATE_IS_NOT_IN_FUTURE {
        @Override
        public ValidationResultClasses getValidationClass() {
            return ValidationResultClasses.ERROR;
        }

        @Override
        public String getDescription() {
            return "Дата должна быть позже текущей";
        }
    },
    DATE_MUST_BE_AFTER_END_REGISTRATION {
        @Override
        public ValidationResultClasses getValidationClass() {
            return ValidationResultClasses.ERROR;
        }

        @Override
        public String getDescription() {
            return "Дата должна быть после даты регистрации";
        }
    },
    INVALID_FORMAT{
        @Override
        public ValidationResultClasses getValidationClass() {
            return ValidationResultClasses.ERROR;
        }

        @Override
        public String getDescription() {
            return "Неправильный формат";
        }
    };
}

package ru.rsreu.sciencecompetition.web.validators.competition.dates;

import ru.rsreu.sciencecompetition.web.validators.NormalValidationResultable;
import ru.rsreu.sciencecompetition.web.validators.ValidationResultable;
import ru.rsreu.sciencecompetition.web.validators.Validator;
import ru.rsreu.sciencecompetition.web.validators.user.password.Pair;

import java.time.Instant;

public class DateSendingAnswersValidator implements Validator<Pair<Instant, Instant>> {
    @Override
    public ValidationResultable validate(Pair<Instant, Instant> valueToValidate) {
        if (!valueToValidate.fst.isAfter(valueToValidate.snd)) {
            return new NormalValidationResultable();
        } else {
            return CompetitionDatesValidatorResults.DATE_MUST_BE_AFTER_END_REGISTRATION;
        }
    }
}

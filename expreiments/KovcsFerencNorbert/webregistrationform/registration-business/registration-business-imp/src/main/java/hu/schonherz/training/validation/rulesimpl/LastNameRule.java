package hu.schonherz.training.validation.rulesimpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import hu.schonherz.training.exception.Violation;
import hu.schonherz.training.exception.ViolationException;
import hu.schonherz.training.registration.PersonRegistrationRequest;
import hu.schonherz.training.validation.Validator;

public class LastNameRule implements Validator<PersonRegistrationRequest> {

	public LastNameRule() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Violation> validate(PersonRegistrationRequest object) throws ViolationException {
		return StringUtils.isBlank(object.getLastName())
				? Arrays.asList(new Violation("lastname", "The first name field must be filled"))
				: Collections.emptyList();
	}

}

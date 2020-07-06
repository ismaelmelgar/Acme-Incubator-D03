
package acme.features.administrator.inquirie;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.inquiries.Inquirie;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorInquirieCreateService implements AbstractCreateService<Administrator, Inquirie> {

	// Internal state ------------------------------------------------

	@Autowired
	AdministratorInquirieRepository repository;


	// AbstractCreateService<Administrator, Inquirie> interface ------------------------------

	@Override
	public boolean authorise(final Request<Inquirie> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Inquirie> request, final Inquirie entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationMoment");
	}

	@Override
	public void unbind(final Request<Inquirie> request, final Inquirie entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "deadline", "description", "minMoney", "maxMoney", "email");

	}

	@Override
	public Inquirie instantiate(final Request<Inquirie> request) {
		Inquirie result;

		result = new Inquirie();
		result.setCreationMoment(new Date());

		return result;
	}

	@Override
	public void validate(final Request<Inquirie> request, final Inquirie entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Inquirie> request, final Inquirie entity) {
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationMoment(moment);
		this.repository.save(entity);

	}

}

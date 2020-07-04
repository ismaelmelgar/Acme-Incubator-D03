
package acme.entities.challenges;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Challenge extends DomainEntity {

	//Serialisation identifier ---------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes -----------------------------------------------------

	@Length(min = 1, max = 50)
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date				deadline;

	@Column(length = 500)
	@Length(min = 1, max = 500)
	private String				description;

	@Length(min = 1, max = 200)
	private String				rookieGoal;

	@Valid
	@NotNull
	private Money				rookieReward;

	@Length(min = 1, max = 200)
	private String				averageGoal;

	@Valid
	@NotNull
	private Money				averageReward;

	@Length(min = 1, max = 200)
	private String				expertGoal;

	@Valid
	@NotNull
	private Money				expertReward;

}

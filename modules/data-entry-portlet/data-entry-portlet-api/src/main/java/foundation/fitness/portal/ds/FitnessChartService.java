package foundation.fitness.portal.ds;

import foundation.fitness.portal.service.model.FitnessRecord;

import java.util.List;

/**
 * @author Eric Chin
 */
public interface FitnessChartService {

	public String generateSeries(
		String name, List<FitnessRecord> fitnessRecords);

}

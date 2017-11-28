package foundation.fitness.portal.ds.impl;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import foundation.fitness.portal.ds.FitnessChartService;
import foundation.fitness.portal.service.model.FitnessRecord;
import org.osgi.service.component.annotations.Component;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = FitnessChartService.class)
public class FitnessChartServiceImpl implements FitnessChartService {

	@Override
	public String generateSeries(
		String name, List<FitnessRecord> fitnessRecords) {

		StringBundler jsonObject = new StringBundler();

		jsonObject.append(StringPool.OPEN_CURLY_BRACE);

		jsonObject.append(StringPool.QUOTE);
		jsonObject.append("name");
		jsonObject.append(StringPool.QUOTE);
		jsonObject.append(StringPool.COLON);
		jsonObject.append(StringPool.QUOTE);
		jsonObject.append(name);
		jsonObject.append(StringPool.QUOTE);
		jsonObject.append(StringPool.COMMA);

		JSONArray dataJSONArray = JSONFactoryUtil.createJSONArray();

		Calendar calendar = CalendarFactoryUtil.getCalendar();

		calendar.setTimeZone(TimeZone.getTimeZone("UTC"));

		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.YEAR, 1970);

		StringBundler sb = new StringBundler();

		sb.append(StringPool.OPEN_BRACKET);

		for (FitnessRecord fitnessRecord : fitnessRecords) {
			int minutes = fitnessRecord.getMileRunMinutes();
			int seconds = fitnessRecord.getMileRunSeconds();

			calendar.set(Calendar.MINUTE, minutes);
			calendar.set(Calendar.SECOND, seconds);

			dataJSONArray.put(calendar.getTimeInMillis());

			sb.append(calendar.getTimeInMillis());
			sb.append(StringPool.COMMA);
		}

		sb.setIndex(sb.index() - 1);

		sb.append(StringPool.CLOSE_BRACKET);

		jsonObject.append(StringPool.QUOTE);
		jsonObject.append("data");
		jsonObject.append(StringPool.QUOTE);
		jsonObject.append(StringPool.COLON);
		jsonObject.append(sb.toString());

		jsonObject.append(StringPool.CLOSE_CURLY_BRACE);

		return jsonObject.toString();
	}

}

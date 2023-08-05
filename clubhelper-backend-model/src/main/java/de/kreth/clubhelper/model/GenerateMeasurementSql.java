package de.kreth.clubhelper.model;

import java.util.ArrayList;
import java.util.List;

import de.kreth.clubhelper.data.MeasurementType;

public class GenerateMeasurementSql {

	public static void main(String[] args) {
		new GenerateMeasurementSql().start();
	}

	List<String> sql = new ArrayList<String>();

	private void start() {

		List<List<String>> values = parse();
		List<String> dates = values.remove(0);

		for (List<String> list : values) {
			String classification = list.get(0);
			for (int index = 1; index < list.size(); index++) {
				String date = dates.get(index);
				String value = list.get(index);
				if (!value.isBlank()) {
					date = formatDate(date);
					value = value.replace(',', '.');
					String sql = createSql(1, MeasurementType.JumpHeightSeconds.name(), date, value, classification);
					this.sql.add(sql);
				}
			}
		}
		sql.forEach(l -> System.out.println(l));
	}

	private String formatDate(String date) {
		String[] values = date.split("\\.");
		StringBuilder result = new StringBuilder();
		result.append(values[2]).append("-").append(values[1]).append("-").append(values[0]).append(" 00:00:00");
		return result.toString();
	}

	private List<List<String>> parse() {
		List<List<String>> values = new ArrayList<>();
		String text = getText();
		String[] lines = text.split("\\n");
		for (String line : lines) {
			values.add(toValues(line));
		}
		return values;
	}

	private List<String> toValues(String line) {
		List<String> values = new ArrayList<String>();
		int startIndex = 0;
		int endIndex = line.indexOf('\t');
		while (endIndex >= 0) {
			values.add(line.substring(startIndex, endIndex));
			startIndex = endIndex + 1;
			endIndex = line.indexOf('\t', startIndex);
		}
		return values;
	}

	private String createSql(long personId, String measurementType, String date, String value, String classification) {
		return "INSERT INTO `measurement` (`person_id`, `measurement_type`, `on_time`, `measured`, `classification`) VALUES ('"
				+ personId + "', '" + measurementType + "', '" + date + "', '" + value + "', '" + classification
				+ "');";
	}

	String getInsertTemplate() {
		return "INSERT INTO `measurement` (`person_id`, `measurement_type`, `on_time`, `measured`, `classification`) VALUES ('', '', '', '', '');";
	}

	String getText() {
		return "Datum	11.05.2015	25.04.2016	30.05.2016	28.01.2013	06.03.2017	20.10.2014	20.10.2014	26.01.2015	22.03.2015	04.02.2015	30.01.2016	30.05.2016	05.11.2017	11.12.2017\n"
				+ "10Sprünge	13,76	13,28	14,60	14,76	14,97	15.84	16.21	16.02	16.14	15.7	16.52	16,69		16,33\n"
				+ "10Hocken				13,99	14,85	15					14.69		17.3	15,44\n"
				+ "P3		12,3	13,49	14,2		14.7								\n"
				+ "P4														\n"
				+ "P5														\n"
				+ "P6							14.44	14.27	14.33	15.59		14,49		\n"
				+ "Kür P6 m. Salto Sitz								14.29		13.7				";
	}
}

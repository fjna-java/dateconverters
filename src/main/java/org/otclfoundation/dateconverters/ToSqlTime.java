/**
*
* @author  Franklin Abel (Joshua), 
* @version 1.0
* @since   2020-09-10 
*/
package org.otclfoundation.dateconverters;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import org.otclfoundation.dateconverters.exception.DateConverterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.sisyphsu.dateparser.DateParserUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class ToSqlTime.
 */
class ToSqlTime extends AbstractDateConversions {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ToSqlTime.class);

	/**
	 * To sql time.
	 *
	 * @param <F> the generic type
	 * @param date the date
	 * @return the time
	 */
	public static <F> Time toSqlTime(F date) {
		if (date == null) {
			return null;
		}
		if (date instanceof String) {
			Date utilDate = DateParserUtils.parseDate((String) date);
			return new Time(utilDate.getTime());
		} 
		if (date instanceof Date) {
			return new Time(((java.util.Date) date).getTime());
		}
		if (date instanceof Timestamp) {
			return new Time(((Timestamp) date).getTime());
		}
		if (date instanceof Time) {
			return (Time) date;
		}
		if (date instanceof Calendar) {
			return new Time(((Calendar) date).getTimeInMillis());
		}
		if (date instanceof XMLGregorianCalendar) {
			return new Time(((XMLGregorianCalendar) date).toGregorianCalendar().getTimeInMillis());
		}
		if (date instanceof Instant) {
			return new Time(((Instant) date).toEpochMilli());
		}
		if (date instanceof LocalDate) {
			return new Time(((LocalDate) date).atStartOfDay(DEFAULT_ZONE_ID).toInstant().toEpochMilli());
		}
		if (date instanceof LocalTime) {
			return Time.valueOf((LocalTime) date);
		}
		if (date instanceof LocalDateTime) {
			return new Time(((LocalDateTime) date).atZone(DEFAULT_ZONE_ID).toInstant().toEpochMilli());
		}
		if (date instanceof ZonedDateTime) {
			return new Time(((ZonedDateTime) date).toInstant().toEpochMilli());
		}
		if (date instanceof OffsetDateTime) {
			return new Time(((OffsetDateTime) date).toInstant().toEpochMilli());
		}
		if (date instanceof org.joda.time.Instant) {
			return new Time(((org.joda.time.Instant) date).toDate().getTime());
		}
		if (date instanceof org.joda.time.DateTime) {
			return new Time(((org.joda.time.DateTime) date).toDate().getTime());
		}
		if (date instanceof org.joda.time.LocalDate) {
			return new Time(((org.joda.time.LocalDate) date).toDate().getTime()); 
		}
		if (date instanceof org.joda.time.LocalTime) {
			org.joda.time.LocalTime localTime = (org.joda.time.LocalTime) date;
			return new Time(localTime.getHourOfDay(), localTime.getMinuteOfHour(), localTime.getSecondOfMinute());
		}
		if (date instanceof org.joda.time.LocalDateTime) {
			return new Time(((org.joda.time.LocalDateTime) date).toDate().getTime()); 
		}
		throw new DateConverterException("",
				"Date conversion error! Unable to convert " + date.getClass().getName() + " to java.sql.Time");
	}

	/**
	 * To sql time.
	 *
	 * @param dateString the date string
	 * @param format the format
	 * @return the time
	 */
	public static Time toSqlTime(String dateString, String format) {
		if (dateString == null) {
			return null;
		}
		try {
			Date date = new SimpleDateFormat(format).parse((String) dateString);
			return new Time(date.getTime());
		} catch (ParseException e) {
			throw new DateConverterException("",
					"Date conversion error! Unable to convert " + dateString + " to java.sql.Time", e);
		}
	}

}
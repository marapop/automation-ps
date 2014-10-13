package a.tools.alfresco;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Assert;

public class DateUtils {

    public static Date getNow() {
        return Calendar.getInstance().getTime();
    }

    public static String getSiteDay(String timeZone) {
        return String.format(
                "%d",
                Calendar.getInstance(TimeZone.getTimeZone(timeZone)).get(
                        Calendar.DAY_OF_MONTH));
    }

    public static String getSiteMonth(String timeZone) {
        return new DateFormatSymbols().getMonths()[Calendar.getInstance(
                TimeZone.getTimeZone(timeZone)).get(Calendar.MONTH)];
    }

    public static String getSiteYear(String timeZone) {
        return String.format(
                "%d",
                Calendar.getInstance(TimeZone.getTimeZone(timeZone)).get(
                        Calendar.YEAR));
    }

    public static String getSiteHour(String timeZone) {
        return String.format(
                "%d",
                Calendar.getInstance(TimeZone.getTimeZone(timeZone)).get(
                        Calendar.HOUR));
    }

    public static String getSiteMinute(String timeZone) {
        return String.format(
                "%d",
                Calendar.getInstance(TimeZone.getTimeZone(timeZone)).get(
                        Calendar.MINUTE));
    }

    public static String getSiteSecond(String timeZone) {
        return String.format(
                "%d",
                Calendar.getInstance(TimeZone.getTimeZone(timeZone)).get(
                        Calendar.SECOND));
    }

    public static String getSiteAmPm(String timeZone) {
        String AM_PM = String.format(
                "%d",
                Calendar.getInstance(TimeZone.getTimeZone(timeZone)).get(
                        Calendar.AM_PM));
        if (AM_PM.equals("0"))
            return "AM";
        return "PM";
    }

    public static String getSiteDay(Date date, String timeZone) {
        Calendar calendar = Calendar
                .getInstance(TimeZone.getTimeZone(timeZone));
        calendar.setTime(date);
        return String.format("%d", calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static String getSiteMonth(Date date, String timeZone) {
        Calendar calendar = Calendar
                .getInstance(TimeZone.getTimeZone(timeZone));
        calendar.setTime(date);
        return new DateFormatSymbols().getMonths()[calendar.get(Calendar.MONTH)];
    }

    public static String getSiteYear(Date date, String timeZone) {
        Calendar calendar = Calendar
                .getInstance(TimeZone.getTimeZone(timeZone));
        calendar.setTime(date);
        return String.format("%d", calendar.get(Calendar.YEAR));
    }

    public static String getSiteHour(Date date, String timeZone) {
        Calendar calendar = Calendar
                .getInstance(TimeZone.getTimeZone(timeZone));
        calendar.setTime(date);
        return String.format("%d", calendar.get(Calendar.HOUR));
    }

    public static String getSiteMinute(Date date, String timeZone) {
        Calendar calendar = Calendar
                .getInstance(TimeZone.getTimeZone(timeZone));
        calendar.setTime(date);
        return String.format("%d", calendar.get(Calendar.MINUTE));
    }

    public static String getSiteSecond(Date date, String timeZone) {
        Calendar calendar = Calendar
                .getInstance(TimeZone.getTimeZone(timeZone));
        calendar.setTime(date);
        return String.format("%d", calendar.get(Calendar.SECOND));
    }

    public static String getSiteAmPm(Date date, String timeZone) {
        Calendar calendar = Calendar
                .getInstance(TimeZone.getTimeZone(timeZone));
        calendar.setTime(date);
        String AM_PM = String.format("%d", calendar.get(Calendar.AM_PM));
        if (AM_PM.equals("0"))
            return "AM";
        return "PM";
    }

    public static Date getSiteNow(String timeZone) throws ParseException {
        String siteNowString = String.format("%s-%s-%s %s:%s:%s %s",
                getSiteDay(timeZone), getSiteMonth(timeZone),
                getSiteYear(timeZone), getSiteHour(timeZone),
                getSiteMinute(timeZone), getSiteSecond(timeZone),
                getSiteAmPm(timeZone));
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!! " + siteNowString);
        String dateFormat = "d-MMM-yyyy h:mm:ss aa";
        return new SimpleDateFormat(dateFormat).parse(siteNowString);
    }

    public static Date getSiteCurrentTime(String timeZone) {
        Date currentDate = null;
        try {
            currentDate = getSiteNow(timeZone);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return currentDate;
    }

    public static String getTimeFromDifferentTimeZone(Date date,
            String timeZone, String dateFormat) {
        String stringDateFromDifferentTimeZone = String.format(
                "%s-%s-%s %s:%s:%s %s %s", getSiteDay(date, timeZone),
                getSiteMonth(date, timeZone), getSiteYear(date, timeZone),
                getSiteHour(date, timeZone), getSiteMinute(date, timeZone),
                getSiteSecond(date, timeZone), getSiteAmPm(date, timeZone),
                timeZone);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "d-MMM-yyyy hh:mm:ss aa zzz");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        Date dateFromDifferentTimeZone = null;
        try {
            dateFromDifferentTimeZone = simpleDateFormat
                    .parse(stringDateFromDifferentTimeZone);
        } catch (ParseException e) {
            e.printStackTrace();
            Assert.fail(String
                    .format("The '%s' date could not be parsed according to the '%s' date format!",
                            stringDateFromDifferentTimeZone, dateFormat));
        }
        stringDateFromDifferentTimeZone = toString(dateFromDifferentTimeZone,
                dateFormat);
        return stringDateFromDifferentTimeZone;
    }

    public static String getSiteCurrentTimeAsString(String timeZone,
            String dateFormat) {
        Date currentDate = null;
        try {
            currentDate = getSiteNow(timeZone);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return toString(currentDate, dateFormat);
    }

    public static Date getYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static Date addMinutes(Date date, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }

    public static Date addHours(Date date, int hours) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hours);
        return cal.getTime();
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    public static Date addTime(Date date, int time, int timeUnit) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(timeUnit, time);
        return cal.getTime();
    }

    /**
     * Returns a list of the dates that are situated in different days between the given dates. The hour and minute of the days in the list are the same as the @initialDate
     * 
     * @param initialDate
     * @param finalDate
     * @return
     */
    public static List<Date> getListOfDatesBetweenDates(Date initialDate,
            Date finalDate) {
        List<Date> dates = new ArrayList<Date>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(initialDate);
        while (calendar.getTime().before(finalDate)) {
            Date currentDate = calendar.getTime();
            dates.add(currentDate);
            calendar.add(Calendar.DATE, 1);
        }
        return dates;
    }

    /**
     * Returns a random date that is situated between the given dates
     * 
     * @param initialDate
     * @param finalDate
     * @return
     */
    public static Date getRandomDateBetweenDates(Date initialDate,
            Date finalDate) {
        List<Date> dates = getListOfDatesBetweenDates(initialDate, finalDate);
        return StringUtils.getRandomItemFromList(dates);
    }

    public static String toString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("d-MMM-yyyy",
                Locale.US);
        String desiredDate = formatter.format(date);
        return desiredDate;
    }

    public static String toString(Date date, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.US);
        String desiredDate = formatter.format(date);
        return desiredDate;
    }

    /**
     * This method format is : dd-MMM-yyyy HH:mm a (eg: 6-Oct-2012 03:18:33)
     */
    public static String toStringTime(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "d-MMM-yyyy hh:mm:ss", Locale.US);
        String desiredDate = formatter.format(date);
        return desiredDate;
    }

    public static Date fromStringTime(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "d-MMM-yyyy hh:mm:ss", Locale.US);
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            Assert.fail(String.format(
                    "The '%s' date was not parsed successfully!", dateString));
        }
        return date;
    }

    public static Date fromStringTime(String dateString, String formatType) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType, Locale.US);
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            Assert.fail(String.format(
                    "The '%s' date was not parsed successfully!", dateString));
        }
        return date;
    }

    // public static Date fromStringTime(String dateString, String formatType,
    // String timeZone) {
    // return getTimeFromDifferentTimeZone(
    // fromStringTime(dateString, formatType), timeZone);
    // }

    // public static Date fromStringTime(String dateString, String formatType,
    // String timeZone) {
    // SimpleDateFormat formatter = new SimpleDateFormat(formatType, Locale.US);
    // Date date = null;
    // try {
    // date = formatter.parse(dateString);
    // } catch (ParseException e) {
    // e.printStackTrace();
    // Assert.fail(String.format(
    // "The '%s' date was not parsed successfully!", dateString));
    // }
    // Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZone));
    // calendar.setTime(date);
    // return calendar.getTime();
    // }

    // public static Date fromStringTime(String dateString, String formatType,
    // String timeZone) {
    // SimpleDateFormat formatter = new SimpleDateFormat(formatType, Locale.US);
    // Calendar calendar = Calendar
    // .getInstance(TimeZone.getTimeZone(timeZone));
    // formatter.setCalendar(calendar);
    // Date date = null;
    // try {
    // date = formatter.parse(dateString);
    // } catch (ParseException e) {
    // e.printStackTrace();
    // Assert.fail(String.format(
    // "The '%s' date was not parsed successfully!", dateString));
    // }
    // // Calendar calendar =
    // // Calendar.getInstance(TimeZone.getTimeZone(timeZone));
    // // calendar.setTime(date);
    // return date;
    // }

    // public static void checkDatesWithErrorMargin(String
    // approximateDateString,
    // String approximateDateFormatType, String actualDateString,
    // String actualDateFormatType, int errorMargin, int timeUnit) {
    // Date approximateDate = fromStringTime(approximateDateString,
    // approximateDateFormatType);
    // System.out.println("1 " + approximateDate.toString());
    // Date actualDate = fromStringTime(actualDateString, actualDateFormatType);
    // System.out.println("2 " + actualDate.toString());
    // Date dateWithAddedErrorMargin = addTime(approximateDate, errorMargin,
    // timeUnit);
    // System.out.println("3 " + dateWithAddedErrorMargin.toString());
    // Assert.assertTrue(String.format("The '%s' date should be before '%s'!",
    // actualDateString,
    // toString(dateWithAddedErrorMargin, actualDateFormatType)),
    // actualDate.compareTo(dateWithAddedErrorMargin) < 0);
    // Date dateWithSubtractedErrorMargin = addTime(approximateDate,
    // -errorMargin, timeUnit);
    // System.out.println("4 " + dateWithSubtractedErrorMargin.toString());
    // Assert.assertTrue(String.format("The '%s' date should be after '%s'!",
    // actualDateString,
    // toString(dateWithSubtractedErrorMargin, actualDateFormatType)),
    // actualDate.compareTo(dateWithSubtractedErrorMargin) > 0);
    // }

    public static void checkDatesWithErrorMargin(String approximateDateString,
            String approximateDateFormatType, String actualDateString,
            String actualDateFormatType, int errorMargin, int timeUnit) {
        // Date approximateDate = fromStringTime(approximateDateString,
        // approximateDateFormatType);
        System.out.println(":");
        @SuppressWarnings("deprecation")
        Date approximateDate = new Date(approximateDateString);
        System.out.println("1 " + approximateDate.toString());
        Date actualDate = fromStringTime(actualDateString, actualDateFormatType);
        System.out.println("2 " + actualDate.toString());
        Date dateWithAddedErrorMargin = addTime(approximateDate, errorMargin,
                timeUnit);
        System.out.println("3 " + dateWithAddedErrorMargin.toString());
        Assert.assertTrue(String.format("The '%s' date should be before '%s'!",
                actualDateString,
                toString(dateWithAddedErrorMargin, actualDateFormatType)),
                actualDate.compareTo(dateWithAddedErrorMargin) < 0);
        Date dateWithSubtractedErrorMargin = addTime(approximateDate,
                -errorMargin, timeUnit);
        System.out.println("4 " + dateWithSubtractedErrorMargin.toString());
        Assert.assertTrue(String.format("The '%s' date should be after '%s'!",
                actualDateString,
                toString(dateWithSubtractedErrorMargin, actualDateFormatType)),
                actualDate.compareTo(dateWithSubtractedErrorMargin) > 0);
    }

    public static void checkDatesWithErrorMargin(Date approximateDate,
            Date actualDate, String dateFormatType, int errorMargin,
            int timeUnit) {
        Date dateWithAddedErrorMargin = addTime(approximateDate, errorMargin,
                timeUnit);
        Assert.assertTrue(
                String.format("The '%s' date should be before '%s'!",
                        toString(actualDate, dateFormatType),
                        toString(dateWithAddedErrorMargin, dateFormatType)),
                actualDate.compareTo(dateWithAddedErrorMargin) < 0);
        Date dateWithSubtractedErrorMargin = addTime(approximateDate,
                -errorMargin, timeUnit);
        Assert.assertTrue(String.format("The '%s' date should be after '%s'!",
                toString(actualDate, dateFormatType),
                toString(dateWithSubtractedErrorMargin, dateFormatType)),
                actualDate.compareTo(dateWithSubtractedErrorMargin) > 0);
    }

    public static Date fromString(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("d-MMM-yyyy",
                Locale.US);
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            Assert.fail(String.format(
                    "The '%s' date was not parsed successfully!", dateString));
        }
        return date;
    }

    public static Date getDate(int daysDeviation) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, daysDeviation);
        return cal.getTime();
    }

    public static String getMonthName(Date date) {
        return new SimpleDateFormat("MMMMM").format(date);
    }

    public static String getShortMonthName(Date date) {
        return new SimpleDateFormat("MMM").format(date);
    }

    public static String getDayName(Date date) {
        return new SimpleDateFormat("EEEEE", new Locale("en", "US"))
                .format(date);
    }

    public static Integer getDateYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    public static int getDateMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    public static Integer getDateDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DATE);
    }

    public static String getDateDayToString(Date date) {
        return new SimpleDateFormat("dd").format(date);
    }

    public static String getDateMonthToStringWithZeroPadding(Date date) {
        return new SimpleDateFormat("MM").format(date);
    }

    public static String getDateMonthToString(Date date) {
        return new SimpleDateFormat("M").format(date);
    }

    public static String getDateHourAndMinute(Date date) {
        return new SimpleDateFormat("hh:mm aa").format(date);
    }

    public static String toStringForTagsWithDecimalPoint(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM.-yyyy",
                Locale.US);
        String desiredDate = formatter.format(date);
        return desiredDate;
    }

    public static String getMonthNumberFromString(String monthName) {
        Date date = null;
        try {
            date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(monthName);
        } catch (ParseException e) {
            e.printStackTrace();
            Assert.fail(String.format(
                    "The '%s' month name was not parsed successfully!",
                    monthName));
        }
        SimpleDateFormat formatter = new SimpleDateFormat("MM", Locale.US);
        String desiredDate = formatter.format(date);
        return desiredDate;
    }

    public static String formatStringDate(String date,
            String initialDateFormat, String finalDateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(finalDateFormat,
                Locale.US);
        String desiredDate = formatter.format(fromStringTime(date,
                initialDateFormat));
        return desiredDate;
    }

    //	public static void main(String[] args) {
    //	}
}

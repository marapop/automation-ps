package a.tools.alfresco;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathUtils {

    /**
     * subtracts the percentage form a whole
     * 
     * @param x
     * @param percentage
     * @return
     */
    public static Double subtractPercentageFromWhole(double x, double percentage) {
        return x * (1 - percentage / 100);
    }

    /**
     * Returns the first integer value contained in a given string
     * 
     * @param text
     * @return
     */
    public static String getIntegerValue(String text) {
        String intValue = null;
        Pattern p = Pattern.compile("(^|\\s)([0-9]+)($|\\s)");
        Matcher m = p.matcher(text);
        if (m.find()) {
            intValue = m.group(2);
        }
        return intValue;
    }

    public static String getPriceWithPercentageIncluded(String price,
            String percentage) {
        Double dblPrice = Double.valueOf(price);
        Double dblPercentage = Double.valueOf(percentage);
        Double finalPrice = dblPrice * (100 + dblPercentage) / 100;
        return getDoubleValueWithTwoDigits(finalPrice);
    }

    public static String getPercentageValue(String price, String percentage) {
        Double dblPrice = Double.valueOf(price);
        Double dblPercentage = Double.valueOf(percentage);
        Double finalPrice = dblPrice * dblPercentage / 100;
        return getDoubleValueWithTwoDigits(finalPrice);
    }

    public static Double getPercentage(Double price, Double percentage) {
        Double finalPrice = price * percentage / 100;
        return getDoubleWithTwoDigits(finalPrice);
    }

    public static double extractDoubleFromString(String str) {
        double finalDouble = 0;
        Pattern p = Pattern
                .compile("[^\\d]*([0-9]+[\\s]*[.,]{0,2}[\\s]*[0-9]*).?$");
        Matcher m = p.matcher(str);
        if (m.find()) {
            finalDouble = Double.parseDouble(m.group(1));

        }
        return finalDouble;
    }

    public static Double getAverageValueAsDouble(String... terms) {
        Double sum = 0.0;
        for (String term : terms)
            sum += Double.valueOf(term);
        return sum / terms.length;
    }

    public static Double getSumValueAsDouble(String... terms) {
        Double sum = 0.0;
        for (String term : terms)
            sum += Double.valueOf(term);
        return sum;
    }

    public static Double getAverageAsDouble(int... terms) {
        Double sum = 0.0;
        for (int term : terms)
            sum += Double.valueOf(term);
        return sum / terms.length;
    }

    public static String getIntegerFormatPercentageValue(String price,
            String percentage) {
        String doubleFormat = getPercentageValue(price, percentage);
        Double doubleValue = Double.parseDouble(doubleFormat);
        Integer intValue = (int)Math.round(doubleValue);
        return Integer.toString(intValue);
    }

    public static Double roundDoubleToTwoDigits(Double number) {
        BigDecimal bdNumber = new BigDecimal(number);
        return getDoubleWithTwoDigits(bdNumber.setScale(2,
                BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    public static Double roundDouble(Double number, int newScale,
            int roundRule) {
        BigDecimal bdNumber = new BigDecimal(number);
        return getDoubleWithSpecifiedNoOfDigits(bdNumber.setScale(newScale, roundRule)
                .doubleValue(), newScale);
    }

    public static String roundDoubleToTwoDigits(String number) {
        BigDecimal bdNumber = new BigDecimal(number);
        return getDoubleValueWithTwoDigits(bdNumber.setScale(2,
                BigDecimal.ROUND_HALF_UP).toString());
    }

    public static String roundDoubleToOneDigit(String number, int roundRule) {
        BigDecimal bdNumber = new BigDecimal(number);
        return getDoubleValueWithOneDigit(bdNumber.setScale(1, roundRule)
                .toString());
    }

    public static Double getDoubleWithTwoDigits(Double number) {
        DecimalFormat twoFiguresFormat = new DecimalFormat("####0.00");
        return Double.valueOf(twoFiguresFormat.format(number));
    }

    public static Double getDoubleWithSpecifiedNoOfDigits(Double number, int noOfDigits) {
        String format = "####0.";
        for (int i = 0; i < noOfDigits; i++)
            format += "0";
        DecimalFormat twoFiguresFormat = new DecimalFormat(format);
        return Double.valueOf(twoFiguresFormat.format(number));
    }

    public static String getDoubleValueWithTwoDigits(String number) {
        DecimalFormat twoFiguresFormat = new DecimalFormat("#####0.00");
        return twoFiguresFormat.format(Double.valueOf(number));
    }

    public static String getDoubleValueWithOneDigit(String number) {
        DecimalFormat twoFiguresFormat = new DecimalFormat("#####0.0");
        return twoFiguresFormat.format(Double.valueOf(number));
    }

    public static String getDoubleValueWithTwoDigits(Double number) {
        DecimalFormat twoFiguresFormat = new DecimalFormat("#####0.00");
        return twoFiguresFormat.format(number);
    }

    public static String getIntegerPartOfDouble(Double number) {
        DecimalFormat integerFormat = new DecimalFormat("#####0");
        return integerFormat.format(number);
    }
}

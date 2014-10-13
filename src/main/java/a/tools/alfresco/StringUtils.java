package a.tools.alfresco;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class StringUtils {

    /**
     * 
     * @param <T>
     * @param list
     * @return
     */
    public static <T> T getRandomItemFromList(List<T> list) {
        SecureRandom random = new SecureRandom();
        return list.get(random.nextInt(list.size()));
    }

    /**
     * This method returns list of url's found in a string
     * 
     * @param str
     * @return
     */
    public static List<String> extractUrlsFromString(String str) {
        int matchStart = 0;
        int matchEnd = 0;
        List<String> urlList = new ArrayList<String>();
        Pattern urlPattern = Pattern
                .compile(
                        "(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?",
                        Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                                | Pattern.DOTALL);
        Matcher matcher = urlPattern.matcher(str);
        while (matcher.find()) {
            matchStart = matcher.start(1);
            matchEnd = matcher.end();
            // now you have the offsets of a URL match
            String linkI = (str.substring(matchStart, matchEnd));
            urlList.add(linkI);
        }

        return urlList;
    }

    /**
     * extracts substring from another string
     * 
     * @param text
     *            - string to search from
     * @param key
     *            substr to search
     * @return
     */
    public static String extractSubstringAfterKey(String text, String key) {
        int beginIndex = text.indexOf(key);
        Assert.assertFalse("The given key '" + key
                + "' was not found in the given text '" + text + "'!",
                beginIndex == -1);
        int startPos = key.length() + beginIndex;
        return text.substring(startPos);
    }

    /**
     * Extracts the substring from the given text that starts form the last index of the given key
     * 
     * @param text
     * @param key
     * @return
     */
    public static String extractLastSubstringFromAnotherString(String text,
            String key) {
        int beginIndex = text.lastIndexOf(key);
        Assert.assertFalse("The given key '" + key
                + "' was not found in the given text '" + text + "'!",
                beginIndex == -1);
        int startPos = key.length() + beginIndex;
        return text.substring(startPos);
    }

    /**
     * Retrieves an array of strings composed of substrings of the given text that are found between every occurrence of the key in the given text
     * 
     * @param text
     * @param key
     * @return
     */
    public static String[] getSubstringsSplitByKey(String text, String key) {
        String[] substrings = null;
        substrings = text.split(key);
        for (int i = 0; i < substrings.length; i++) {
            substrings[i] = substrings[i].trim();
        }
        return substrings;
    }

    /**
     * Returns an array of items composed of the elements of @initialArray and the elements of @values inserted at the @index position in @initialArray
     * 
     * @param initialArray
     * @param index
     * @param values
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] insertValuesInArray(Class<T> c, T[] initialArray,
            int index, T... values) {
        Assert.assertTrue(
                "The size of the array in which the values should be inserted is "
                        + initialArray.length
                        + " and the index of the position where the values should be inserted is "
                        + index
                        + ". The index should be less than or equal to the size of the array.",
                index <= initialArray.length);
        T[] resultArray = (T[])Array.newInstance(c, initialArray.length
                + values.length);
        for (int i = 0; i < resultArray.length; i++) {
            if (i < index)
                resultArray[i] = initialArray[i];
            else if (i >= index && i < index + values.length)
                resultArray[i] = values[i - index];
            else
                resultArray[i] = initialArray[i - values.length];
        }
        return resultArray;
    }

    /**
     * Returns an list of items composed of the elements of @listInWhichToInsert and the elements of @listOfElementsToBeInserted inserted at @index position in @listInWhichToInsert
     * list
     * 
     * @param <T>
     * @param listInWhichToInsert
     * @param index
     * @param listOfElementsToBeInserted
     * @return
     */
    public static <T> List<T> insertListElementsInList(
            List<T> listInWhichToInsert, int index,
            List<T> listOfElementsToBeInserted) {
        Assert.assertTrue(
                "The size of the list in which the elements should be inserted is "
                        + listInWhichToInsert.size()
                        + " and the index of the position where the values should be inserted is "
                        + index
                        + ". The index should be less than or equal with the size of the array.",
                index <= listInWhichToInsert.size());
        List<T> resultList = new ArrayList<T>(listInWhichToInsert.size()
                + listOfElementsToBeInserted.size());
        for (int i = 0; i < resultList.size(); i++) {
            if (i < index)
                resultList.add(listInWhichToInsert.get(i));
            else if (i >= index
                    && i < index + listOfElementsToBeInserted.size())
                resultList.add(listInWhichToInsert.get(i - index));
            else
                resultList.add(listInWhichToInsert.get(i
                        - listOfElementsToBeInserted.size()));
        }
        return resultList;
    }

    /**
     * Returns an array of items composed of the elements of @initialArray and the elements of @values inserted at the @index position in @initialArray
     * 
     * Returns an array of strings formed by replacing the element found at @index position in @strings with the elements of @values
     * 
     * @param strings
     * @param index
     * @param values
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] replaceArrayElementsWithValues(Class<T> c,
            T[] initialArray, int startIndex, int endIndex, T... values) {
        Assert.assertTrue(
                "The starting index in where the values should be inserted is "
                        + startIndex
                        + " and the ending index where the values should be inserted is "
                        + endIndex
                        + ". The starting index should be less than or equal to the ending index.",
                startIndex <= endIndex);
        Assert.assertTrue(
                "The size of the array in which the values should be inserted is "
                        + initialArray.length
                        + " and the index of the position where the values should be inserted is "
                        + startIndex
                        + ". The index should be less than or equal to the size of the array.",
                startIndex <= initialArray.length);
        T[] resultArray = (T[])Array.newInstance(c, initialArray.length
                + values.length - endIndex + startIndex - 1);
        for (int i = 0; i < resultArray.length; i++) {
            if (i < startIndex)
                resultArray[i] = initialArray[i];
            else if (i >= startIndex && i < startIndex + values.length)
                resultArray[i] = values[i - startIndex];
            else
                resultArray[i] = initialArray[i - startIndex - values.length
                        + endIndex + 1];
        }
        return resultArray;
    }

    /**
     * Retrieves a substring of the given text starting after the @startKey and ending before the @endKey
     * 
     * @param text
     * @param startKey
     * @param endKey
     * @return
     */
    public static String extractSubstringFoundBetweenKeys(String text,
            String startKey, String endKey) {
        int startIndex = text.indexOf(startKey);
        int endIndex = text.indexOf(endKey);
        Assert.assertTrue("Searched starting key: " + startKey
                + " couldn't be found!", startIndex != -1);
        Assert.assertTrue("Searched ending key: " + endKey
                + " couldn't be found!", endIndex != -1);
        Assert.assertTrue(
                "Searched ending key is situated before the searched starting key!",
                endIndex > startIndex);
        startIndex += startKey.length();
        return text.substring(startIndex, endIndex);
    }

    /**
     * Extracts the substring that starts with @startKey and ends with @endKey (includes searched keys)
     * 
     * @param text
     * @param startKey
     * @param endKey
     * @return
     */
    public static String extractSubstringThatIncludesSearchedKeys(String text,
            String startKey, String endKey) {
        int startIndex = text.indexOf(startKey);
        int endIndex = text.indexOf(endKey);
        Assert.assertTrue("Searched starting key: " + startKey
                + " couldn't be found!", startIndex != -1);
        Assert.assertTrue("Searched ending key: " + endKey
                + " couldn't be found!", endIndex != -1);
        Assert.assertTrue(
                "Searched ending key is situated before the searched starting key!",
                endIndex > startIndex);
        endIndex += endKey.length();
        return text.substring(startIndex, endIndex);
    }

    /**
     * This method insert @insertString at specified @index in @body
     * 
     * @param body
     * @param insertString
     * @param index
     * @return
     */
    public static String insertStringAtIndex(String body, String insertString,
            int index) {
        StringBuilder returnString = new StringBuilder(body);
        returnString = returnString.insert(index, insertString);
        return returnString.toString();
    }

    /**
     * This method inserts the @textToBeInserted string in the @body after the first occurrence of @searchedKey
     * 
     * @param body
     * @param searchedKey
     * @param textToBeInserted
     * @return
     */
    public static String insertStringAfterKey(String body, String searchedKey,
            String textToBeInserted) {
        StringBuilder returnString = new StringBuilder(body);
        try {
            int indexOfTextToBeInserted = returnString.toString().toLowerCase()
                    .indexOf(searchedKey.toLowerCase());
            if (indexOfTextToBeInserted == -1) {
                return body;
            }
            indexOfTextToBeInserted += searchedKey.length();
            returnString = returnString.insert(indexOfTextToBeInserted,
                    textToBeInserted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnString.toString();
    }

    /**
     * This method inserts the @textToBeInserted string in the @body before the first occurrence of @searchedKey
     * 
     * @param body
     * @param searchedKey
     * @param textToBeInserted
     * @return
     */
    public static String insertStringBeforeKey(String body, String searchedKey,
            String textToBeInserted) {
        StringBuilder returnString = new StringBuilder(body);
        try {
            int indexOfTextToBeInserted = returnString.indexOf(searchedKey);
            if (indexOfTextToBeInserted == -1) {
                return body;
            }
            returnString = returnString.insert(indexOfTextToBeInserted,
                    textToBeInserted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnString.toString();
    }

    /**
     * This method replaces a substring of @body which begin from @startIndex and ends at @endIndex with @replaceWith
     * 
     * @param body
     * @param replaceWith
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static String replaceSubString(String body, String replaceWith,
            int startIndex, int endIndex) {
        // this method is called within a try-catch block and the test fails if
        // the assertion fails
        // Assert.assertTrue("Ending index '" + endIndex
        // + "' is situated before the starting index '" + startIndex
        // + "'!", endIndex > startIndex);
        StringBuilder returnString = new StringBuilder(body);
        returnString = returnString.replace(startIndex, endIndex, replaceWith);
        return returnString.toString();
    }

    /**
     * Retrieves the first sequence of digits from a string
     * 
     * @param text
     * @return
     */
    public static Integer getFirstIntegerNumberFromString(String text) {
        String intNumber = "";
        char[] characters = text.toCharArray();
        boolean foundDigit = false;
        for (char ch : characters) {
            if (Character.isDigit(ch)) {
                foundDigit = true;
                intNumber += ch;
            } else {
                if (foundDigit) {
                    break;
                }
            }
        }
        Assert.assertTrue(
                "No matching integer was found in the provided string!",
                intNumber != "");
        return Integer.valueOf(intNumber);
    }

    /**
     * Retrieves the first sequence of digits from a string
     * 
     * @param text
     * @return
     */
    public static String getFirstIntegerNumberFromStringInStringFormat(
            String text) {
        String intNumber = "";
        char[] characters = text.toCharArray();
        boolean foundDigit = false;
        for (char ch : characters) {
            if (Character.isDigit(ch)) {
                foundDigit = true;
                intNumber += ch;
            } else {
                if (foundDigit) {
                    break;
                }
            }
        }
        Assert.assertTrue(
                "No matching integer was found in the provided string!",
                intNumber != "");
        return intNumber;
    }

    /**
     * Retrieves the last sequence of digits from a string
     * 
     * @param text
     * @return
     */
    public static Integer getLastIntegerNumberFromString(String text) {
        String intNumber = "";
        char[] characters = text.toCharArray();
        boolean foundDigit = false;
        for (int i = characters.length - 1; i >= 0; i--) {
            char ch = characters[i];
            if (Character.isDigit(ch)) {
                foundDigit = true;
                intNumber += ch;
            } else {
                if (foundDigit) {
                    break;
                }
            }
        }
        Assert.assertTrue(
                "No matching integer was found in the provided string!",
                intNumber != "");
        return Integer
                .valueOf(new StringBuffer(intNumber).reverse().toString());
    }

    /**
     * Retrieves the first sequence of digits that follow after a given key from a string
     * 
     * @param text
     * @param key
     * @return
     */
    public static Integer getFirstIntegerNumberAfterKeyFromString(String text,
            String key) {
        text = text.substring(text.indexOf(key) + key.length());
        return getFirstIntegerNumberFromString(text);
    }

    public static List<Integer> getAllIntegerNumbersFromString(String text) {
        List<Integer> listOfIntegers = new ArrayList<Integer>();
        String intNumber = "";
        char[] characters = text.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            char ch = characters[i];
            if (Character.isDigit(ch)) {
                intNumber += ch;
                if (i == characters.length - 1) {
                    listOfIntegers.add(Integer.parseInt(intNumber));
                }
            } else {
                if (intNumber != "") {
                    listOfIntegers.add(Integer.parseInt(intNumber));
                    intNumber = "";
                }
            }
        }
        Assert.assertTrue(
                "No matching integer was found in the provided string!",
                listOfIntegers.size() > 0);
        return listOfIntegers;
    }

    public static List<Integer> getAllIntegerNumbersAfterKeyFromString(
            String text, String key) {
        text = text.substring(text.indexOf(key) + key.length());
        return getAllIntegerNumbersFromString(text);
    }

    /**
     * Retrieves the first double from a given string
     * 
     * @param text
     * @return
     */
    public static Double getFirstDoubleNumberFromString(String text) {
        String dblNumber = getFirstAnyRationalNumberFormatStringFromString(text);
        int indexOfComma = dblNumber.indexOf(',');
        int indexOfPoint = dblNumber.indexOf('.');
        if (indexOfComma > indexOfPoint) {
            dblNumber = dblNumber.replace(".", "");
            dblNumber = dblNumber.replace(",", ".");
        } else if (indexOfComma < indexOfPoint)
            dblNumber = dblNumber.replace(",", "");
        Double result = null;
        try {
            result = Double.valueOf(dblNumber);
        } catch (NumberFormatException e) {
            Assert.fail("Found double value doesn't match any double format standard!");
        }
        return result;
    }

    /**
     * Retrieves the first double from a given string
     * 
     * @param text
     * @return
     */
    public static String getFirstDoubleNumberValueFromString(String text) {
        return MathUtils
                .getDoubleValueWithTwoDigits(getFirstDoubleNumberFromString(text));
    }

    /**
     * Retrieves the first substring of the given string that has the format of European (with comma decimal separator) or international (with point decimal
     * separator) decimal number
     * 
     * @param text
     * @return
     */
    public static String getFirstAnyRationalNumberFormatStringFromString(
            String text) {
        String rationalNumber = "";
        char[] characters = text.toCharArray();
        boolean foundDigit = false;
        for (char ch : characters) {
            if (Character.isDigit(ch)) {
                foundDigit = true;
                rationalNumber += ch;
            } else if (foundDigit && ch == '.' || ch == ',') {
                rationalNumber += ch;
            } else {
                if (foundDigit) {
                    break;
                }
            }
        }
        int indexOfLastCharacter = rationalNumber.length() - 1;
        if (rationalNumber.charAt(indexOfLastCharacter) == ','
                || rationalNumber.charAt(indexOfLastCharacter) == '.') {
            rationalNumber = rationalNumber.substring(0, indexOfLastCharacter);
        }
        return rationalNumber;
    }

    /**
     * Returns the last price contained in a given string
     * 
     * @param priceString
     * @return
     */
    public static String getPriceValue(String priceString) {
        Scanner scanner = new Scanner(priceString);
        scanner.useDelimiter("[^\\p{Alnum},\\.-]");
        String priceValue = "";
        while (true) {
            if (scanner.hasNextInt())
                priceValue = String.valueOf(scanner.nextInt());
            else if (scanner.hasNextDouble())
                priceValue = String.valueOf(scanner.nextDouble());
            else if (scanner.hasNext())
                priceValue = String.valueOf(scanner.next());
            else
                break;
        }
        if (priceValue.contains(",")) {
            priceValue = priceValue.replace(".", "");
        }
        scanner.close();
        Assert.assertTrue(
                "No matching price value was found in the provided string!",
                priceValue != "");
        return priceValue;
    }

    public static String getCountryCode(String countryName) {
        return getCountryLocale(countryName).getCountry();
    }

    public static String getLanguageCode(String countryName) {
        return getCountryLocale(countryName).getDisplayLanguage();
    }

    private static Locale getCountryLocale(String countryName) {
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            if (countryName.compareToIgnoreCase(locale.getDisplayCountry()) == 0) {
                return locale;
            }
        }
        Assert.fail("The country locale of the provided country couldn't be computed!");
        return null;
    }

    public static String getCurrencySymbol(String countryName) {
        Currency currency = Currency.getInstance(getCountryLocale(countryName));
        return currency.getSymbol();
    }

    public static String removeBlanks(String body) {
        return body.replaceAll("[\0\t]", "");
    }

    public static String removeNewLinesMultipleSpacesAndTabs(String body) {
        body = body.replaceAll("[\0\t\n\r]", " ");
        body = body.replaceAll("&nbsp;", " ");
        while (body.indexOf("  ") != -1) {
            body = body.replaceAll("  ", " ");
        }
        return body;
    }

    public static String getValueForKey(Map<String, String> map, String key) {
        for (Entry<String, String> entrySet : map.entrySet()) {
            if (entrySet.getKey().contentEquals(key))
                return entrySet.getValue();
        }
        Assert.fail("The key '" + key + "' was not found!");
        return null;
    }

    @SafeVarargs
	@SuppressWarnings("unused")
    public static <V> boolean checkIfAllTheValuesAreEqual(V... values) {
        V firstValue = values[1];
        boolean result = true;
        for (int i = 1; i < values.length; i++) {
            V value = values[i];
            result = (true ? value.equals(firstValue) : false);
        }
        return result;
    }

    /**
     * Sorting order enum, specifying request result sort behavior.
     */
    public static enum SortingOrder {
        /**
         * Resulting sort will be from smallest to biggest.
         */
        ASCENDING,
        /**
         * Resulting sort will be from biggest to smallest.
         */
        DESCENDING
    }

    /**
     * Sort a map by it's keys.
     * 
     * @param sortingOrder
     *            {@link SortingOrder} enum specifying requested sorting order.
     * @return new instance of {@link LinkedHashMap} contained sorted entries of supplied map.
     */
    public static <K, V> LinkedHashMap<K, V> sortMapByKey(final Map<K, V> map,
            final SortingOrder sortingOrder) {
        Comparator<Map.Entry<K, V>> comparator = new Comparator<Entry<K, V>>() {
            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
                return comparableCompare(o1.getKey(), o2.getKey(), sortingOrder);
            }
        };
        return sortMap(map, comparator);
    }

    /**
     * Sort a map by it's values.
     * 
     * @param sortingOrder
     *            {@link SortingOrder} enum specifying requested sorting order.
     * @return new instance of {@link LinkedHashMap} contained sorted entries of supplied map.
     */
    public static <K, V> LinkedHashMap<K, V> sortMapByValue(
            final Map<K, V> map, final SortingOrder sortingOrder) {
        Comparator<Map.Entry<K, V>> comparator = new Comparator<Entry<K, V>>() {
            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
                return comparableCompare(o1.getValue(), o2.getValue(),
                        sortingOrder);
            }
        };
        return sortMap(map, comparator);
    }

    @SuppressWarnings("unchecked")
    private static <T> int comparableCompare(T o1, T o2,
            SortingOrder sortingOrder) {
        int compare = ((Comparable<T>)o1).compareTo(o2);
        switch (sortingOrder) {
        case ASCENDING:
            return compare;
        case DESCENDING:
            return -compare;
        }
        return 0;
    }

    /**
     * Sort a map by supplied comparator logic.
     * 
     * @return new instance of {@link LinkedHashMap} contained sorted entries of supplied map.
     */
    public static <K, V> LinkedHashMap<K, V> sortMap(final Map<K, V> map,
            final Comparator<Map.Entry<K, V>> comparator) {
        // Convert the map into a list of key-value pairs.
        List<Map.Entry<K, V>> mapEntries = new LinkedList<Map.Entry<K, V>>(
                map.entrySet());
        // Sort the converted list according to supplied comparator.
        Collections.sort(mapEntries, comparator);
        // Build a new ordered map, containing the same entries as the old map.
        LinkedHashMap<K, V> result = new LinkedHashMap<K, V>(map.size());
        for (Map.Entry<K, V> entry : mapEntries) {
            // We iterate on the mapEntries list which is sorted by the
            // comparator
            // putting new entries into
            // the targeted result which is a sorted map.
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    /**
     * Retrieves a sub-map of the given map having different values
     * 
     * @param map
     * @return
     */
    public static <K, V> LinkedHashMap<K, V> getSubMapWithDifferentValues(
            final Map<K, V> map) {
        List<Map.Entry<K, V>> entriesList = new LinkedList<Map.Entry<K, V>>(
                map.entrySet());
        LinkedHashMap<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : entriesList) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (!result.values().contains(value)) {
                result.put(key, value);
            }
        }
        return result;
    }

    /**
     * Retrieves a sub-map of the given map with entries having the given value
     */
    public static <K, V> LinkedHashMap<K, V> getSubMapWithGivenValue(
            final Map<K, V> map, V desiredValue) {
        LinkedHashMap<K, V> result = new LinkedHashMap<K, V>();
        List<Map.Entry<K, V>> entriesList = new LinkedList<Map.Entry<K, V>>(
                map.entrySet());
        for (Map.Entry<K, V> entry : entriesList) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (value.equals(desiredValue)) {
                result.put(key, value);
            }
        }
        return result;
    }

    /**
     * Returns the given map having the entries sorted first by value and then by key for the entries with the same value
     */
    public static <K, V> LinkedHashMap<K, V> sortMapEntriesByValueAndByKey(
            final Map<K, V> map) {
        LinkedHashMap<K, V> result = new LinkedHashMap<K, V>(map.size());
        LinkedHashMap<K, V> orderedSubMapWithDifferentValues = sortMapByValue(
                getSubMapWithDifferentValues(map), SortingOrder.ASCENDING);
        List<Map.Entry<K, V>> subSetWithDifferentValues = new LinkedList<Map.Entry<K, V>>(
                orderedSubMapWithDifferentValues.entrySet());
        for (Map.Entry<K, V> entry : subSetWithDifferentValues) {
            V value = entry.getValue();
            LinkedHashMap<K, V> orderedSubMapWithGivenValue = sortMapByKey(
                    getSubMapWithGivenValue(map, value), SortingOrder.ASCENDING);
            List<Map.Entry<K, V>> subSetWithGivenValue = new LinkedList<Map.Entry<K, V>>(
                    orderedSubMapWithGivenValue.entrySet());
            for (Map.Entry<K, V> orderedEntry : subSetWithGivenValue) {
                K orderedEntryKey = orderedEntry.getKey();
                V orderedEntryValue = orderedEntry.getValue();
                result.put(orderedEntryKey, orderedEntryValue);
            }
        }
        return result;
    }

    public static Double getValueOfEntryWithGreatestKeyLessThanGivenKey(
            Map<Double, Double> map, Double givenKey) {
        Map<Double, Double> sortedMap = sortMapByKey(map,
                SortingOrder.DESCENDING);
        List<Map.Entry<Double, Double>> entriesList = new LinkedList<Map.Entry<Double, Double>>(
                sortedMap.entrySet());
        Double result = 0.0;
        for (Map.Entry<Double, Double> entry : entriesList) {
            Double key = entry.getKey();
            Double value = entry.getValue();
            if (givenKey >= key) {
                result = value;
                break;
            }
        }
        return result;
    }

    public static Double getNextKeyGreaterThanGivenKey(Map<Double, Double> map,
            Double givenKey) {
        Map<Double, Double> sortedMap = sortMapByKey(map,
                SortingOrder.ASCENDING);
        List<Double> keysList = new LinkedList<Double>(sortedMap.keySet());
        List<Double> valuesList = new LinkedList<Double>(sortedMap.values());
        int givenKeyFloor = valuesList
                .indexOf(getValueOfEntryWithGreatestKeyLessThanGivenKey(map,
                        givenKey));
        if (givenKeyFloor == keysList.size() - 1)
            Assert.fail("The given key has no greater key!");
        return keysList.get(givenKeyFloor + 1);
    }

    /**
     * Returns a LinkedHashMap composed of the @keysList elements as keys and the @valuesList elements as values
     * 
     * @param <K>
     * @param <V>
     * @param keysList
     * @param valuesList
     * @return
     */
    public static <K, V> LinkedHashMap<K, V> getLinkedHashMapFromLists(
            List<K> keysList, List<V> valuesList) {
        Assert.assertTrue("The keys list size is '" + keysList.size()
                + "' and the values list size is '" + valuesList.size()
                + "'. The size of the two lists should match!",
                keysList.size() == valuesList.size());
        LinkedHashMap<K, V> result = new LinkedHashMap<K, V>(keysList.size());
        for (int i = 0; i < keysList.size(); i++) {
            K key = keysList.get(i);
            V value = valuesList.get(i);
            result.put(key, value);
        }
        return result;
    }

    @SafeVarargs
	public static <T> boolean checkIfAllItemsExistInTheList(List<T> itemsList,
            T... items) {
        for (T item : items) {
            if (!itemsList.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> getListWithIndexesOfFalseValues(
            boolean... booleanList) {
        List<Integer> falseValuesIndexes = new ArrayList<Integer>();
        for (int i = 0; i < booleanList.length; i++) {
            boolean b = booleanList[i];
            if (!b)
                falseValuesIndexes.add(i);
        }
        return falseValuesIndexes;
    }

    public static boolean checkIfThereIsAtLeastOneFalseValue(
            boolean... booleanList) {
        for (boolean b : booleanList) {
            if (!b)
                return true;
        }
        return false;
    }

    public static void verifyThatAllStringsExistInTheList(
            List<String> itemsList, String... items) {
        boolean[] itemsPresenceArray = new boolean[items.length];
        for (int i = 0; i < items.length; i++) {
            String s = items[i];
            for (String item : itemsList) {
                if (item.contains(s)) {
                    itemsPresenceArray[i] = true;
                    break;
                }

            }
        }
        if (getListWithIndexesOfFalseValues(itemsPresenceArray).size() > 0)
            Assert.assertTrue(String.format(
                    "The '%s' item was not found in the list!",
                    items[getListWithIndexesOfFalseValues(itemsPresenceArray)
                            .get(0)]),
                    checkIfThereIsAtLeastOneFalseValue(itemsPresenceArray));
    }

    @SafeVarargs
	public static <T> void verifyThatAllItemsExistInTheList(List<T> itemsList,
            T... items) {
        for (T item : items)
            Assert.assertTrue(
                    String.format("The '%s' item was not found in the list!",
                            item.toString()), itemsList.contains(item));
    }

    public static Integer getIndexOfItemFromListThatContainsTerms(
            List<String> itemsList, boolean ignoreCase, boolean shouldExist,
            String... strTerms) {
        for (int i = 0; i < itemsList.size(); i++) {
            String item = itemsList.get(i);
            if (checkIfTextContainsTerms(item, ignoreCase, strTerms)) {
                return i;
            }
        }
        if (shouldExist)
            Assert.fail(String
                    .format("No item containing these terms '%s' was found in the list!",
                            getConcatenatedStringRepresentationOfTheElementsOfAnArray(
                                    ",", strTerms)));
        return null;
    }

    public static void verifyTextContainsTerms(String text, boolean ignoreCase,
            String... strTerms) {
        text = StringUtils.removeNewLinesMultipleSpacesAndTabs(text);
        if (ignoreCase)
            text = text.toLowerCase();
        for (String term : strTerms) {
            if (ignoreCase)
                term = term.toLowerCase();
            Assert.assertTrue("The following term couldn't be found: " + term,
                    text.contains(term));
        }
    }

    public static boolean checkIfTextContainsTerms(String text,
            boolean ignoreCase, String... strTerms) {
        text = StringUtils.removeNewLinesMultipleSpacesAndTabs(text);
        if (ignoreCase)
            text = text.toLowerCase();
        for (String term : strTerms) {
            if (ignoreCase)
                term = term.toLowerCase();
            if (!text.contains(term))
                return false;
        }
        return true;
    }

    // @SafeVarargs
    @SafeVarargs
	public static <T> String getConcatenatedStringRepresentationOfTheElementsOfAnArray(
            String separator, T... itemsList) {
        String resultString = "";
        for (T item : itemsList) {
            Assert.assertTrue("Item to be concatenated should not be null!",
                    item != null);
            resultString += separator + item.toString();
        }
        resultString = resultString.substring(separator.length());
        return resultString;
    }
}

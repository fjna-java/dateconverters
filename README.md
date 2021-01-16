# dateConverters library


This is a small date-converter library wherein it converts a date of any date-types mutually between various below date APIs without any need to write any date-conversion code to convert dates between these date API libraries. 

1. Old-school jdk date API

2. Java8 time API

3. Joda date API.

4. Also converts from date-string to date (date-format string not required).

If a date-string is provided for conversion, there is absolutely no need to specify any date-format string. By using this library, a developer does neither have to  write any boilerplate code nor even have to be concerned about date-patterns for any of the date-string conversions. Just a single line of code is all what is required - 

      'DateConverterFacade.convert(<date object or date-string>, <target-date-class-type>);'

which returns the converted date object.

As already mentioned, for converting date-strings, there is no specify the date-format. The date-format is automatically determined from the given date-string by another library contributed by https://github.com/sisyphsu/dateparser. The rest of the mutual date-type conversions is done by the "dateconverter" library.

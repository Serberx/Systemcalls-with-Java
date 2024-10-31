package domain;

import at.spengergasse.systemcalls.domain.DateTimeCall;
import at.spengergasse.systemcalls.exception.DateTimeCallException;
import org.testng.annotations.Test;

import java.util.Properties;


public class DateTimeCallTest{


    @Test
    public void getDate(){
        boolean fail = false;
        try{
            //            DateTimeCall dateTimeCall = new DateTimeCall(LocalDateTime.now(),
            //                                                         ZonedDateTime.now(),
            //                                                         Locale.getDefault());

            DateTimeCall dateTimeCall2 = new DateTimeCall();
            System.out.println();
            System.out.println("Local date: "+dateTimeCall2.getLocDate());
            System.out.println("Local time: "+dateTimeCall2.getLocTime());
            System.out.println("Geodata:------------------------ "+dateTimeCall2.getGeoData());
            System.out.println("Language: "+dateTimeCall2.getLanguage());
            System.out.println();

            Properties property = System.getProperties();
            System.out.println(property);
            System.out.println();
            String property1 = System.getProperty("os.name");
            System.out.println(property1);

          /*  System.out.println();

            System.out.println(dateTimeCall.getDate());
            System.out.println(dateTimeCall.getDay());
            System.out.println(dateTimeCall.getMonth());
            System.out.println(dateTimeCall.getYear());

            System.out.println();


            System.out.println();

            System.out.println(dateTimeCall.getTime());
            System.out.println(dateTimeCall.getHour());
            System.out.println(dateTimeCall.getMin());
            System.out.println(dateTimeCall.getSec());

            System.out.println();

            System.out.println(dateTimeCall.getGeoData());

            //    #########################

            DateTimeCall zoneA = new DateTimeCall(ZonedDateTime.now(),
                                                  Locale.getDefault());

            System.out.println("Local date: \t"+zoneA.getDate());
            System.out.println("Local time: \t"+zoneA.getTime());
            System.out.println("Calendar type: \t"+ZonedDateTime.now()
                                                                .getChronology()
                                                                .getCalendarType());
            System.out.println("Geo data: \t\t%s".formatted(zoneA.getGeoData()));
            System.out.println(zoneA.getLanguage()); //todo

          */


        }catch(DateTimeCallException e){
            throw new DateTimeCallException("Fail"+e.getMessage(),
                                            e);
        }

    }
}
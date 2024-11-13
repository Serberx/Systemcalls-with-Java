package at.spengergasse.systemcalls.domain;


import at.spengergasse.systemcalls.exception.DateTimeCallException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Locale;

public class DateTimeCall{

    boolean unix = false;

    //    #########################
    private String date;
    private String locDate;

    private String day;
    private String month;
    private String year;
    //    #########################
    private String time;
    private String locTime;
    private String hour;
    private String min;
    private String sec;
    //    #########################

    private String geoData;
    private String language;


    public DateTimeCall(){
        getOs();
        setLocDate();
        setLocTime();
        setGeoData();
        setLanguage();
    }

    public DateTimeCall(LocalDateTime date,
                        ZonedDateTime zone,
                        Locale loc){
        getOs();
        setLocDate();
        setLocTime();
        setGeoData();
        setLanguage();

        //        setDate(date);
        //        setDay(date);
        //        setMonth(date);
        //        setYear(date);


        //        setTime(date);
        //        setHour(date);
        //        setMin(date);
        //        setSec(date);


    }

    public DateTimeCall(ZonedDateTime zone,
                        Locale loc){
        getOs();
        setLocDate();
        setLocTime();
        setGeoData();
        setLanguage();

        //        setDate(zone.toLocalDateTime());
        //        setDay(zone.toLocalDateTime());
        //        setMonth(zone.toLocalDateTime());
        //        setYear(zone.toLocalDateTime());


        //        setTime(zone.toLocalDateTime());
        //        setHour(zone.toLocalDateTime());
        //        setMin(zone.toLocalDateTime());
        //        setSec(zone.toLocalDateTime());


    }

    private void getOs(){
        if(System.getProperty("os.name").toLowerCase().contains("lin")){
            this.unix = true;
        }

    }

    public String getLocDate(){
        if(this.locDate != null){
            return this.locDate;
        }else{
            throw new DateTimeCallException("Null value getLocDate!");
        }

    }

    public void setLocDate(){
        String[] tempDate;
        if(!unix){
            tempDate = new String[]{"cmd", "/c", "date", "/T"};
        }else{
            tempDate = new String[]{"bash", "-c", "date"};
        }
        try{
            Process process6 = Runtime.getRuntime()
                                      .exec(tempDate);


            BufferedReader br6 = new BufferedReader(new InputStreamReader(process6.getInputStream()));

            String line6;
            while((line6 = br6.readLine()) != null){
                System.out.println(line6);
                this.locDate = line6;
            }
        }catch(IOException e){
            System.out.println(e.getStackTrace());
        }

    }

 /*   public String getDate(){
        if(this.date != null){
            return date;
        }else{
            throw new DateTimeCallException("Null value getDay!");
        }

    }

    public void setDate(LocalDateTime date){
        if(date != null){
            this.date = String.valueOf(date.now()
                                           .getDayOfMonth())+"/"+String.valueOf(date.now()
                                                                                    .getMonthValue())+"/"+String.valueOf(date.now()
                                                                                                                             .getYear());
        }else{
            throw new DateTimeCallException("Null value at setDate!!");

        }
    }


    public String getDay(){
        if(this.day != null){
            return this.day;
        }else{
            throw new DateTimeCallException("Null value getDay!");
        }
    }

    public void setDay(LocalDateTime day){
        if(day != null){
            this.day = String.valueOf(day.now()
                                         .getDayOfMonth());
        }else{
            throw new DateTimeCallException("Null value at setDay!!");
        }
    }

    public String getMonth(){
        if(this.month != null){
            return this.month;
        }else{
            throw new DateTimeCallException("Null value getMonth!");
        }
    }

    public void setMonth(LocalDateTime month){
        if(month != null){
            this.month = String.valueOf(month.now()
                                             .getMonthValue());
        }else{
            throw new DateTimeCallException("Null value at setMonth!!");
        }
    }

    public String getYear(){
        if(this.year != null){
            return this.year;
        }else{
            throw new DateTimeCallException("Null value getMonth!");
        }
    }

    public void setYear(LocalDateTime year){
        if(year != null){
            this.year = String.valueOf(year.now()
                                           .getYear());
        }else{
            throw new DateTimeCallException("Null value at setYear!!");
        }
    }*/
    //##############################


    public String getLocTime(){
        if(this.locTime != null){
            return this.locTime;
        }else{
            throw new DateTimeCallException("Null value getLocTime!");
        }

    }

    public void setLocTime(){
//        String[] tempTime2 = {"cmd", "/c", "date",  "%Y-%m-%d %H:%M:%S"};
        String[] temTime;
        if(!unix){
            temTime = new String[]{"cmd", "/c", "time", "/T"};
        }else{
            temTime = new String[]{"bash", "-c", "date +%T"};
        }
        try{
//            Process process = Runtime.getRuntime()
//                                     .exec(temTime);
            ProcessBuilder process2         = new ProcessBuilder(temTime);  //ProcessBuilder ist auch eine Möglichkeit einen Prozess zu staarten
            Process        tempProcessStart = process2.start();
//            BufferedReader br2              = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader br3              = new BufferedReader(new InputStreamReader(tempProcessStart.getInputStream()));

//            String line2;
//            while((line2 = br2.readLine()) != null){
//                System.out.println(line2);
//                this.locTime = line2;
//            }

            String line3;
            while((line3 = br3.readLine()) != null){
                System.out.println(line3);
                this.locTime = line3;
            }

        }catch(IOException e){
            throw new RuntimeException(e);
        }

    }

/*    public String getTime(){
        if(this.time != null){
            return this.time;
        }else{
            throw new DateTimeCallException("Null value getTime!");
        }
    }

    public void setTime(LocalDateTime time){
        if(time != null){
            this.time = String.valueOf(time.toLocalTime()
                                           .getHour()+":"+time.toLocalTime()
                                                              .getMinute()+":"+time.toLocalTime()
                                                                                   .getSecond());
        }else{
            throw new DateTimeCallException("Null value at setTime!!");
        }
    }

    public String getHour(){
        if(this.hour != null){
            return this.hour;
        }else{
            throw new DateTimeCallException("Null value getHour!");
        }
    }

    public void setHour(LocalDateTime hour){
        if(hour != null){
            this.hour = String.valueOf(hour.now()
                                           .getHour());
        }else{
            throw new DateTimeCallException("Null value at setHour!!");
        }
    }

    public String getMin(){
        if(this.min != null){
            return this.min;
        }else{
            throw new DateTimeCallException("Null value getMin!");
        }
    }

    public void setMin(LocalDateTime min){
        if(min != null){
            this.min = String.valueOf(min.now()
                                         .getMinute());
        }else{
            throw new DateTimeCallException("Null value at setMin!!");
        }
    }

    public String getSec(){
        if(this.sec != null){
            return this.sec;
        }else{
            throw new DateTimeCallException("Null value getSec!");
        }
    }

    public void setSec(LocalDateTime sec){
        if(sec != null){
            this.sec = String.valueOf(sec.now()
                                         .getSecond());
        }else{
            throw new DateTimeCallException("Null value at setSec!!");
        }
    }*/
    //##############################


    public String getGeoData(){
        if(this.geoData != null){
            return this.geoData.replace('"', ' ');
        }else{
            throw new DateTimeCallException("Null value getGeoData!");
        }
    }

    public void setGeoData(){
        String[] tempLocal;
        if(!unix){
            tempLocal = new String[]{"powershell.exe", "-Command", "(Get-WinHomeLocation).HomeLocation"};
        }else{
            tempLocal = new String[]{"bash", "-c", "curl -s ipinfo.io | jq '.region'"};
        }

        try{
            Process process = Runtime.getRuntime()
                                     .exec(tempLocal);
            BufferedReader br3 = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line3;
            while((line3 = br3.readLine()) != null){
                System.out.println(line3);
                this.geoData = line3;
            }
            if(this.geoData.contains("sterreich")){
                this.geoData = "Austria / Österreich";
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }


    public String getLanguage(){
        if(this.language != null){
            return this.language;
        }else{
            throw new DateTimeCallException("Null value getLanguage!");
        }

    }

    public void setLanguage(){
        String[] tempLang2;
        if(!unix){
            //        String[] tempLang = {"cmd", "/c", "Get-WinHomeLocation"};
            //        String[] tempLang2 = {"powershell.exe", "-Command", "(Get-WinSystemLocale).DisplayName"};
            tempLang2 = new String[]{"powershell.exe", "-Command", "(Get-WinSystemLocale).Name"};
        }else{
            tempLang2 = new String[]{"bash", "-c", "echo $LANG"};
        }
            //        String[] tempLang = {"cmd", "/c", "Get-WinHomeLocation"};
            //        String[] tempLang2 = {"powershell.exe", "-Command", "(Get-WinSystemLocale).DisplayName"};
        try{

//            Process process = Runtime.getRuntime()
//                                     .exec(tempLang2);
            ProcessBuilder processBuilder = new ProcessBuilder(tempLang2);
            Process        tempStart          = processBuilder.start();

            BufferedReader br4_2 = new BufferedReader(new InputStreamReader(tempStart.getInputStream()));

//            BufferedReader br4 = new BufferedReader(new InputStreamReader(process.getInputStream()));

//            String line4;
//            while((line4 = br4.readLine()) != null){
//                System.out.println(line4);
//                this.language = line4;
//            }

            String line4_2;
            while((line4_2 = br4_2.readLine()) != null){
                System.out.println(line4_2);
                this.language = line4_2;
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}

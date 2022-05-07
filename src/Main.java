//Import a scanner to read in the input the user gives into a scanner variable
import java.util.Scanner;
//Import the math library so that this program can do math
import java.lang.Math;
//Create the main class
public class Main {
    //    Create the main function
    public static void main(String[] args) {

//        Create a scanner object so that java can interpret user input
        Scanner myObj = new Scanner(System.in);
//        Create a global variable to be used throughout the program for unit Temperature
        String unitTemperature = "";

        //        Set a condition so that the program will execute as long as the
        //        User puts in the correct kind of weather mesurement
        while(true) {
            System.out.println("What will the unit of measurement for the weather data you will provide be in? Fahrenheit or Celsius (F/C)? ");
//            read the user input and store it
            String unitUser = myObj.nextLine();
//            conver the user input to be read as lowercase
            unitTemperature = unitUser.toLowerCase();
//            check and see if the user entered only 'f' or 'c' as their desired temperature
            if (unitTemperature.equals("f") || unitTemperature.equals("c")) {
                break;
            } else {
//                The while loop keep displaying please only print f or c for temperature
                System.out.println("Please enter Celcius or Fahrenheit as 'f' or 'c'");
            }
        }

//        Define the lowest temperature that the user will give you
        System.out.println("What is the lowest temperature of the day provided? (Please use numbers and not letters): ");
        //            read the user input and store it
        String strVarLowTemp = myObj.nextLine();
        //        Convert user input so that it can be used as a float in the program
        Float floatVarLowTemp = Float.parseFloat(strVarLowTemp);

//        Define the high temperature given from the user
        System.out.println("What is the hightest temperature of the day provided? (Please use numbers and not letters): ");
        //            read the user input and store it
        String strVarHighTemp = myObj.nextLine();
        //        Convert user input so that it can be used as a float in the program
        Float floatVarHighTemp = Float.parseFloat(strVarHighTemp);

//        Convert the low celcius & high celcius
//        temperatures to be fahrenheit so
//        that the program can compute the math
//        needed with fahrenheit temperature
        if(unitTemperature.equals("c")) {
//            Convert the low celcius temperature to fahrenheit so that the program
//            can do the math for the temperature in fahrenheit
            floatVarLowTemp = celConvert(floatVarLowTemp);
            //            Convert the high celcius temperature to fahrenheit so that the program
//            can do the math for the temperature in fahrenheit
            floatVarHighTemp = celConvert(floatVarHighTemp);
        }

//        Define whether or not there is sun shining by
//        Ask the user if there is sunshine
        System.out.println("Will it be sunny during the high temperature? (Y/N): ");
        //            read the user input and store it
        String userSunny = myObj.nextLine();
//        pass the high temperature given and the user declared variable on whether its sunny or not
//        into the isSunny to compute the sunshine
        float varTempSunny = isSunny(floatVarHighTemp, userSunny);

        //        Get the windspeed from the user during the coldest part of the day
        System.out.println("How fast is the wind blowing, (in miles per hour), during the colderst part of the day? : ");
        //            read the user input and store it
        String strVarWindLow = myObj.nextLine();
        //        Convert user input so that it can be used as a float in the program
        Float floatVarWindLow = Float.parseFloat(strVarWindLow);

        //        Get the windspeed from the user during the warmest part of the day
        System.out.println("How fast is the wind blowing, (in miles per hour), during the warmest part of the day? : ");
        //            read the user input and store it
        String strVarWindHigh = myObj.nextLine();
//        Convert user input so that it can be used as a float in the program
        float floatVarWindHigh = Float.parseFloat(strVarWindHigh);

//        Pass in the get windchill function here to get get the windchill
//        at the coldest part of the day
        float windchillLow = getWindchillFunc(floatVarLowTemp, floatVarWindLow);
//
//        Pass in the get windchill function here to get the windchill
//        at the warmest part of the day
        float windchillHigh = getWindchillFunc(varTempSunny, floatVarWindHigh);
//
//        #check to see if the original temperature the user
//        #entered was Celcius otherwise the default temperature
//        #like the program does math in is in Fahrenheit
        if(unitTemperature.equals("c")) {
//            set the unitTemperature to equal Celcius to use latter when
//            displaying back to the user
            unitTemperature = "Celcius";
        }
        else {
//            The temperaature will remain what it computed itself in at fahrenheit
            unitTemperature = "Fahrenheit";
        }
//
//        #print spacing line
        System.out.println("");
//
//        #print real feel banner
        System.out.println(" -_-_-_-_-_-_-_-_-_-_-_-_\\/REAL FEEL TEMPERATURES\\/-_-_-_-_-_-_-_-_-_-_-_-_ ");
//
//        #print spacing line
        System.out.println("");

//        #pass in the get windchill function here to get the windchill
//        #at the coldest part of the day
        float finalWindchillLow = getWindchillFunc(floatVarLowTemp, floatVarWindLow);
//
//        #pass in the get windchill function here to get get the windchill
//        #at the warmest part of the day
        float finalWindchillHigh = getWindchillFunc(floatVarHighTemp, floatVarWindHigh);

//      This if statement is to see if the temperature needs to be displayed back into
//      the temperature that the user delared at the beginning as Celcius. If its not celius
//      the program wont convert it back because it does math in fahrenheit.
        if (unitTemperature.equals("Celcius")){
//            covert the windchill low back to Celcius if that is what the user selected at the beginning
            finalWindchillHigh = fahrConvert(finalWindchillLow);
//            convert the windchill high back to celcius if that is what the user selected at the beginning
            finalWindchillHigh = fahrConvert(finalWindchillHigh);
        }
//
//        #print back the real feel temperature in the unit of
//        #temperature the user orgininally entered it in
//        #for the warmest part of the day
        System.out.println("The temperature during the warmest part of the day will approximately feel like " + finalWindchillHigh +" degrees " + unitTemperature +" with windchill and sunshine factored.");
//
//        #print spacing line
        System.out.println("");
//
//        #print back the real feel temperature in the unit of
//        #temperature the user orgininally entered it in
//        #for the coldest part of the day
        System.out.println("The temperature during the coldest part of the day will approximately feel like "+ finalWindchillLow +" degrees " + unitTemperature +" with windchill and sunshine factored.");
    }

    //        Define the sunny function
    public static float isSunny(Float varHighTemp, String userSunny){
//        Run a series of checks at different temperature intervales that will
//        add more or less to the temperature depending on what the high temperature is
        if(userSunny.equals("y")){
            //        #as long as it is above freezing, sunshine will
//        #give a small boost to how the temperature feels
//        #no more than 5 degrees alone
            if(varHighTemp >= 32){
                varHighTemp += 5;
                //        #sunshine can begin to beat down on the skin above 72 degrees
//        #and cause the temperature to feel much warmer than it really is
            } else if (varHighTemp >= 72) {
                varHighTemp += 10;
                //        #All sun and no clouds begins to cause the the heat from earth's
//        #surface to escape faster than the sunlight coming in, no more
//        #than a 5 degree difference in how it will feel like just below freezeing
            } else if (varHighTemp <= 32) {
                varHighTemp -= 5;
                //        #Temperatures below zero will loose even more of earth's heat when no clouds
//        #are present and truly cause the day to feel that much colder outside.
            } else if (varHighTemp <= 0){
                varHighTemp -= 10;
            }
            //        #return the temperature following the proper condition of sunlight
//            In the if statement
            return varHighTemp;
        }
        //        #return the temperature following the proper condition of sunlight
//        for use outside of the sunny function
        return varHighTemp;
    }

    //        #define windchill function
    public static float getWindchillFunc(float T, float windspeed) {

//        # provide the windchill equation for windchill
        float windchill = (float) (35.74 + (0.6215 * T) - (35.75 * (Math.pow(windspeed, 0.16))) + (0.4275 * T * (Math.pow(windspeed, 0.16))));
//        #return the temperature following the equation of windchill
        return windchill;
    }


    //        Convert from celcius to fahrenheit
    public static float celConvert(float celTemp) {
        //        #return the temperature following its conversion to fahrenheit
        return (float) (celTemp * (9.0 / 5.0) + 32.0);
    }


    //        Convert from fahrenheit to Celcius
    public static float fahrConvert(float fahrTemp) {
//        Do the math for converting back to celcius
        double celTemp = (fahrTemp - 32.0) * (5.0 / 9.0);
        //        #return the temperature following its conversion to celcius
        return (float) celTemp;
    }
}

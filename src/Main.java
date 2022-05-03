public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}



//        #set a condition so that the program will execute as long as the
//        #user puts in the correct kind of weather mesurement
//        while True:
//
//        #first ask the user to give you the unit of measurment
//        #they are going to give their data in
//        unit = input("What will the unit of measurement for the weather data you will provide be in? Fahrenheit or Celsius (F/C)? ")
//
//        #set unit.lower built in python function to be equal to a variable
//        unit_temperature = unit.lower()
//
//        # this if statment determines if the user enter only
//        # Fahrenheit of Celsius correctly
//        if unit_temperature == 'f' or unit_temperature == 'c':
//        break
//        else:
//        print("Please enter only Celcius or Fahrenheit for a unit of measurement: ")
//
//
//        #define the low temperature given from the user
//        var_low_temp = float(input("What is the lowest temperature of the day provided? "))
//
//        #define the high temperature givne from the user
//        var_high_temp = float(input("What is the high temperature of the day provided? "))
//
//        var_sunny = sunny_func(var_high_temp)
//
//        #get the windspeed from the user during the coldest part of the day
//        var_wind_low = float(input("How fast is the wind blowing, (in miles per hour), during the colderst part of the day? : "))
//
//        #get the windspeed from the user during the warmest part of the day
//        var_wind_high = float(input("How fast is the wind blowing, (in miles per hour), during the warmest part of the day? : "))
//
//        #pass in the get windchill function here to get get the windchill
//        #at the coldest part of the day
//        windchill_low = get_windchill_func(var_low_temp, var_wind_low)
//
//        #pass in the get windchill function here to get get the windchill
//        #at the warmest part of the day
//        windchill_high = get_windchill_func(var_sunny, var_wind_high)
//
//        if unit_temperature == 'f':
//        print(f"The windchill during the hottest part of the day will actually feel like {windchill_high:.2f} degrees Fahrenheit.")
//        print(f"The windchill during the coldest part of the day will actually feel like {windchill_low:.2f} degrees Fahrenheit.")
//
//        elif unit_temperature == 'c':
//        print(f"The windchill during the hottest part of the day will actually feel like {windchill_high:.2f} degrees Celcius.")
//        print(f"The windchill during the coldest part of the day will actually feel like {windchill_low:.2f} degrees Celcius.")
//        else:
//        print("You never gave a proper unit of measurement")
//
//
//        #define windchill function
//        def get_windchill_func(T, windspeed):
//
//        # provide the windchill equation for windchill
//        windchill = 35.74+0.6215*T-35.75*(windspeed**0.16)+0.4275*T*(windspeed**0.16)
//        return windchill
//
//
//        #convert from fahrenheit to celcius
//        def fahr_convert(fahr_temp):
//        cel_temp = fahr_temp *(9/5)+32
//        return cel_temp
//
//
//        #convert from celcius to fahrenheit
//        def cel_convert(cel_temp):
//        fahr_temp=(cel_temp-32)*(5/9)
//        return fahr_temp
//
//
//        #define the frost bite given at the actual temperature given
//        def get_frost_bite():
//        pass
//
//
//        #define the sunny function to see if there was sun
//        def sunny_func(high_temp):
//        var_sun = input("Will it be sunny during the high temperature? (Y/N): ")
//        if var_sun.lower() == 'y':
//        if high_temp >= 32:
//        high_temp += 5
//        if high_temp >= 72:
//        high_temp += 10
//        if high_temp <= 32:
//        high_temp -= 5
//        if high_temp <= 0:
//        high_temp -= 10
//        else:
//        pass
//        return high_temp
//
//        if __name__ == "__main__":
//        main()

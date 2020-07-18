public class Application {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

        // limitations:-
        // 1. Cannot add Observable to class that has a superclass (as java does not support multiple inheritance)
        // 2. As Observable is a class and not a interface can't change implementation flexibly and at run time too,
        //    remember Composition over inheritance
        // 3. Also violates above as to change the setChanged() method we have to extend Observable class
    }
}

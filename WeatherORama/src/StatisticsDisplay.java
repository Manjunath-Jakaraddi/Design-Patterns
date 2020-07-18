public class StatisticsDisplay implements DisplayElement, Observer {
    private float minTemperature;
    private float maxTemperature;
    private float avgTemperature;
    private int numberOfSamples;
    private Subject weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this();
        weatherData.registerObserver(this);
    }

    private StatisticsDisplay() {
        minTemperature = Integer.MAX_VALUE;
        maxTemperature = 0;
        avgTemperature = 0;
        numberOfSamples = 0;
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + avgTemperature + "/" + maxTemperature + "/" + minTemperature);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        updateMinTemperature(temperature);
        updateMaxTemperature(temperature);
        updateAvgTemperature(temperature);
        display();
    }

    private void updateMinTemperature(float temperature) {
        minTemperature = Math.min(minTemperature, temperature);
    }

    private void updateMaxTemperature(float temperature) {
        maxTemperature = Math.max(maxTemperature, temperature);
    }

    private void updateAvgTemperature(float temperature) {
        float sumUntilPrevious = avgTemperature * numberOfSamples;
        numberOfSamples++;
        avgTemperature = ( sumUntilPrevious + temperature ) / numberOfSamples;
    }
}

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float minTemperature;
    private float maxTemperature;
    private float avgTemperature;
    private int numberOfSamples;
    private Observable observable;

    public StatisticsDisplay(Observable observable) {
        this();
        this.observable = observable;
        observable.addObserver(this);
    }

    private StatisticsDisplay() {
        minTemperature = Integer.MAX_VALUE;
        maxTemperature = 0;
        avgTemperature = 0;
        numberOfSamples = 0;
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

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            // only gets the temperature data where as in previous we were getting the entire state
            // pull in this case is better than push earlier
            float temperature = weatherData.getTemperature();
            updateMinTemperature(temperature);
            updateMaxTemperature(temperature);
            updateAvgTemperature(temperature);
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + avgTemperature + "/" + maxTemperature + "/" + minTemperature);
    }
}

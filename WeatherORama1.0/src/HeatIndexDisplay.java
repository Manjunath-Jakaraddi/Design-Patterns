import java.util.Observable;
import java.util.Observer;

public class HeatIndexDisplay implements DisplayElement, Observer {
    // no need to save but saving if later need to deregister
    private float heatIndex;
    private Observable observable;

    public HeatIndexDisplay(Observable observable) {
        this();
        this.observable = observable;
        observable.addObserver(this);
    }

    private HeatIndexDisplay() {
        this.heatIndex = 0;
    }

    private float computeHeatIndex(float t, float rh) {
        return (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) +
                (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) +
                (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
                (0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *
                (rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
                (0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
                0.000000000843296 * (t * t * rh * rh * rh)) -
                (0.0000000000481975 * (t * t * t * rh * rh * rh)));

    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            float temperature = weatherData.getTemperature();
            float humidity = weatherData.getHumidity();
            heatIndex = computeHeatIndex(temperature, humidity);
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Heat Index is " + heatIndex);
    }
}

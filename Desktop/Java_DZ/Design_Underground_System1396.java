import java.util.HashMap;
import java.util.Map;

public class Design_Underground_System1396 {
    class Client {
        private String statIn;
        private int timeIn;

        Client(String statIn, int timeIn) {
            this.timeIn = timeIn;
            this.statIn = statIn;
        }

        public String getStatIn() {
            return statIn;
        }

        public int getTimeIn() {
            return timeIn;
        }

    }

    class Route {
        private int totalTime;
        private int count;

        public double getAvgTime() {
            return 1.0 * totalTime / count;
        }

        public void addTime(int t) {
            totalTime += t;
            count++;
        }

    }

    Map<Integer, Client> clientMap;
    Map<String, Route> routeMap;

    public Design_Underground_System1396() {
        clientMap = new HashMap<>();
        routeMap = new HashMap<>();

    }

    public void checkIn(int id, String stationName, int t) {
        clientMap.put(id, new Client(stationName, t));

    }

    public void checkOut(int id, String stationName, int t) {
        Client client = clientMap.get(id);
        String stationKey = getRouteKey(client.getStatIn(), stationName);
        routeMap.putIfAbsent(stationKey, new Route());
        routeMap.get(stationKey).addTime(t - client.getTimeIn());
    }

    private String getRouteKey(String stateFrom, String stateEnd) {
        return stateFrom + "-" + stateEnd;
    }

    public double getAverageTime(String startStation, String endStation) {
        return routeMap.get(getRouteKey(startStation, endStation)).getAvgTime();
    }
}

package sample;

public class TrainTableRow {
    private Integer id;
    private String name;
    private String type;
    private String route;
    private String departureTime;
    private String arrivalTime;
    private Integer numberOfCars;

    public TrainTableRow(Integer id, String name, String type, String route, String departureTime, String arrivalTime, Integer numberOfCars) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.route = route;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.numberOfCars = numberOfCars;
    }

    public TrainTableRow() {
        this.id = 0;
        this.name = "ERROR";
        this.type = "ERROR";
        this.route = "ERROR";
        this.departureTime = "ERROR";
        this.arrivalTime = "ERROR";
        this.numberOfCars = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars(Integer numberOfCars) {
        this.numberOfCars = numberOfCars;
    }
}

package hiber.model;

import javax.persistence.*;


@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long car_id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;
    @OneToOne(mappedBy = "car")
    private User user;

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}

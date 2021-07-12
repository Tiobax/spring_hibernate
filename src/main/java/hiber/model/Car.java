package hiber.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "cars")
public class Car implements Serializable {

    @Id
    @Column(name = "model")
    private String model;

    @Id
    @Column(name = "series")
    private String series;

    public Car() {
    }

    public Car(String model, String series) {
        this.model = model;
        this.series = series;
    }

}

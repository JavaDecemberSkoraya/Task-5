package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "serias")
    private int serias;

    @OneToOne(mappedBy = "car")
    private User owner;

    public Car() {
    }

    public Car(String model, int serias) {
        this.model = model;
        this.serias = serias;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getSerias() {
        return serias;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSerias(int serias) {
        this.serias = serias;
    }

    @Override
    public String toString(){
        return model + ' ' + serias;
    }

}

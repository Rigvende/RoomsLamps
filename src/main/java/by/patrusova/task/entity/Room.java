package by.patrusova.task.entity;

import org.hibernate.annotations.Proxy;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rooms")
@Proxy(lazy=false)
public class Room implements Serializable, Cloneable {

    private static final long serialVersionUID = 4648287772613080698L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "room", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Lamp lamp;

    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "country")
    private String country;

    public Room() {
    }

    public Room(String name, String country) {
        this.name = name;
        this.country = country;
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
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public Lamp getLamp() {
        return lamp;
    }
    public void setLamp(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Room room = (Room) o;
        return id != null && id.equals(room.id)
                && lamp != null && lamp.equals(room.lamp)
                && name != null && name.equals(room.name)
                && country != null && country.equals(room.country);
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + name.hashCode();
        result = prime * result + country.hashCode();
        result = prime * result + lamp.hashCode();
        result = prime * result + id;
        return result;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Room{");
        sb.append("id=").append(id).append(", name='").append(name)
                .append("', country='").append(country).append("'}");
        return sb.toString();
    }
}
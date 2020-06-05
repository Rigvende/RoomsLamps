package by.patrusova.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lamps")
@Proxy(lazy=false)
public class Lamp implements Cloneable, Serializable {

    private static final long serialVersionUID = 4648287444413080698L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "lamp_condition")
    private String lampCondition;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_room")
    @JsonIgnore
    private Room room;

    public Lamp() {}

    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLampCondition() {
        return lampCondition;
    }
    public void setLampCondition(String condition) {
        this.lampCondition = condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lamp lamp = (Lamp) o;
        return id != null && id.equals(lamp.id) &&
                lampCondition != null && lampCondition.equals(lamp.lampCondition) &&
                room != null && room.equals(lamp.room);
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + lampCondition.hashCode();
        result = prime * result + room.hashCode();
        result = prime * result + id;
        return result;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Lamp{");
        sb.append("id=").append(id).append(", condition='").append(lampCondition)
                .append("', room=").append(room.getId()).append("}");
        return sb.toString();
    }
}
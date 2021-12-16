package fr.m2i.santagiftapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="url")
    private String url;
    @ManyToOne(cascade = {CascadeType.MERGE })
    private User santa;
    @ManyToOne(cascade = {CascadeType.MERGE })
    private User child;
    private boolean isBooked = false;
    private Date createdAt;
    public void setIsBooked(){
        this.isBooked = false;
    }
    public void setCreatedAt() {
        this.createdAt = Calendar.getInstance().getTime();
    }
}

package by.sakhonchik.bot.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Simple JavaBean domain object that represents City.
 *
 * @author Dmitry Sakhonchik
 * @version 1.0
 */

@Data
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "info")
    private String info;


}

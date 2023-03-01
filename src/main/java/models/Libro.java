package models;
import lombok.*;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="biblioteca")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String autor;
    private String categoria;
    @Column(name = "anho")
    private Integer año;
    private String ISBN;
    private String estado;


}

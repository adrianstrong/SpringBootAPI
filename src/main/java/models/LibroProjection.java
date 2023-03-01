package models;

import lombok.Data;

@Data
public class LibroProjection {
        Integer id;
        String nombre;

        public LibroProjection(Integer id, String nombre) {
                this.id = id;
                this.nombre = nombre;
        }
}

package az.edu.ada.wm2.AS1application.model;

import lombok.*;

import jakarta.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "DEPARTMENTS")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

}

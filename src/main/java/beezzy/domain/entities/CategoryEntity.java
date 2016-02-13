package beezzy.domain.entities;

import javax.persistence.*;

/**
 * Created by oleh on 13.02.2016.
 */
@Entity
@Table(name = "CATEGORY")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;



}

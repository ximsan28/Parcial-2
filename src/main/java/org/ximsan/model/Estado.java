package org.ximsan.model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

@ToString(callSuper = true)
@Entity
@Table( name="TBL_ESTADO" )

public class Estado extends Catalogo implements Serializable
{
    @Column(name = "ESTADO", nullable = false )
    private String estado;
}

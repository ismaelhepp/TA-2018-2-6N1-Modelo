package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "colaborador")
public class Colaborador implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_colaborador", 
            sequenceName = "seq_colaborador_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_colaborador", 
            strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "carga_horaria", nullable = false)
    @Min(value = 0, 
            message = "A carga horária não pode ter menos que {value} horas")
    private Integer cargaHoraria;
    
    @Column(name = "gestor", nullable = false)
    @NotNull(message = "O gestor não pode ser nulo")
    private Boolean gestor;
    
    @ManyToOne
    @JoinColumn(name="usuario", referencedColumnName = "nome_usuario", 
            nullable = false,
            foreignKey = @ForeignKey(name="fk_colaborador_usuario"))
    private Usuario usuario;

    public Colaborador() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Boolean getGestor() {
        return gestor;
    }

    public void setGestor(Boolean gestor) {
        this.gestor = gestor;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Colaborador other = (Colaborador) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

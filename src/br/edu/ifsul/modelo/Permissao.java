package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "permissao")
public class Permissao implements Serializable {
    
    @Id
    @Column(name = "nome", length = 20, nullable = false)
    @NotNull(message= "O nome não pode ser nulo")
    @NotBlank(message= "O nome não pode ser em branco")
    @Length(max = 20, message = "O nome não pode ter mais que {max} caracteres")
    private String nome;
    
    @Column(name = "descricao", length = 40)
    @NotNull(message= "A descrição não pode ser nulo")
    @NotBlank(message= "A descrição não pode ser em branco")
    @Length(max = 40, message = "A descrição não pode ter mais que {max} caracteres")
    private String descricao;

    public Permissao() {
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
        @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.nome);
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
        final Permissao other = (Permissao) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
}

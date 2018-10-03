package br.edu.ifsul.modelo;

import java.util.Set;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    
    @Id
    @Column(name = "nome_usuario", length = 20, nullable = false)
    @NotNull(message= "O nome de usuário não pode ser nulo")
    @NotBlank(message= "O nome de usuário não pode ser em branco")
    @Length(max = 20, message = "O nome não pode ter mais que {max} caracteres")
    private String nomeUsuario;
    
    @Column(name = "nome", length = 50, nullable = false)
    @NotNull(message= "O nome não pode ser nulo")
    @NotBlank(message= "O nome não pode ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    private String nome;
    
    @Column(name = "email", length = 50, nullable = false)
    @Email(message = "O e-mail deve ser válido")
    @NotNull(message= "O e-mail não pode ser nulo")
    @NotBlank(message= "O e-mail não pode ser em branco")
    @Length(max = 50, message = "O e-mail não pode ter mais que {max} caracteres")
    private String email;
    
    @Column(name = "senha", length = 20, nullable = false)
    @NotNull(message= "A senha não pode ser nulo")
    @NotBlank(message= "A senha não pode ser em branco")
    @Length(max = 20, message = "A senha não pode ter mais que {max} caracteres")
    private String senha;
    
    @Column(name = "nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message= "O nascimento não pode ser nulo")
    private Calendar nascimento;
    
    @ManyToOne
    @JoinColumn(name="setor", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name="fk_usuario_setor"))
    private Setor setor;
    
    @ManyToMany
    @JoinTable(name = "permissoes", 
            joinColumns = 
            @JoinColumn(
                    name="usuario", 
                    referencedColumnName = "nome_usuario", 
                    nullable = false),
            inverseJoinColumns = 
            @JoinColumn(
                    name = "permissao",
                    referencedColumnName = "nome",
                    nullable = false)
            )
    private Set<Permissao> permissoes = new HashSet<>();

    public Usuario() {
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nomeUsuario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nomeUsuario, other.nomeUsuario)) {
            return false;
        }
        return true;
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
}

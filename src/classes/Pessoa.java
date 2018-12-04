package classes;

import java.util.List;
import java.util.Objects;

public class Pessoa {

    private Integer id;
    private String name;
    private List<String> telefones;

    public Pessoa() {
    }

    public Pessoa(Integer id, String name, List<String> telefones) {
        this.id = id;
        this.name = name;
        this.telefones = telefones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) &&
                Objects.equals(name, pessoa.name) &&
                Objects.equals(telefones, pessoa.telefones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, telefones);
    }
}

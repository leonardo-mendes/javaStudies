package classes;

import java.util.List;

public class Pessoa {

    private String id;
    private String name;
    private List<String> telefones;

    public Pessoa() {
    }

    public Pessoa(String id, String name, List<String> telefones) {
        this.id = id;
        this.name = name;
        this.telefones = telefones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}

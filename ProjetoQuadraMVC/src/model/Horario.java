package model;

public class Horario {
    private int id;
    private String descricaoHorario;
    private double valor;

    public Horario(int id, String descricaoHorario, double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor do horário não pode ser negativo");
        }
        this.id = id;
        this.descricaoHorario = descricaoHorario;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getDescricaoHorario() {
        return descricaoHorario;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return descricaoHorario + " - R$ " + valor;
    }
}

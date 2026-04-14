import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluguel {
    private int id;
    private LocalDate data;
    private Cliente cliente;
    private List<Horario> horarios;
    private double valorTotal;
    private boolean pago;

    public Aluguel(int id, LocalDate data, Cliente cliente, List<Horario> horarios, boolean pago) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.horarios = new ArrayList<>(horarios);
        this.pago = pago;
        this.valorTotal = calcularValorTotal();
    }

    private double calcularValorTotal() {
        double total = 0;
        for (Horario horario : horarios) {
            total += horario.getValor();
        }
        return total;
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public boolean isPago() {
        return pago;
    }

    @Override
    public String toString() {
        return "Aluguel{id = " + id +
                ", data = " + data +
                ", cliente = " + cliente.getNome() +
                ", horarios = " + horarios +
                ", valorTotal = " + valorTotal +
                ", pago = " + pago + "}";
    }
}

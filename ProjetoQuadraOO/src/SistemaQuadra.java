import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaQuadra {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Horario> horarios = new ArrayList<>();
    private List<Aluguel> alugueis = new ArrayList<>();

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void cadastrarHorario(Horario horario) {
        horarios.add(horario);
    }

    public Aluguel registrarAluguel(int id, LocalDate data, Cliente cliente, List<Horario> horariosEscolhidos, boolean pago) {
        for (Horario horario : horariosEscolhidos) {
            if (horarioOcupado(data, horario)) {
                throw new IllegalArgumentException("O horario " + horario.getDescricaoHorario() + " ja esta ocupado nesta data");
            }
        }

        Aluguel aluguel = new Aluguel(id, data, cliente, horariosEscolhidos, pago);
        alugueis.add(aluguel);
        return aluguel;
    }

    private boolean horarioOcupado(LocalDate data, Horario horarioDesejado) {
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getData().equals(data)) {
                for (Horario horario : aluguel.getHorarios()) {
                    if (horario.getId() == horarioDesejado.getId()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<Aluguel> consultarAlugueisPorDia(LocalDate data) {
        List<Aluguel> resultado = new ArrayList<>();
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getData().equals(data)) {
                resultado.add(aluguel);
            }
        }
        return resultado;
    }
}

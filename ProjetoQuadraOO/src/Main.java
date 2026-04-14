import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SistemaQuadra sistema = new SistemaQuadra();

        Cliente c1 = new Cliente(1, "Eduardo Ferrari", "44999375053");
        Cliente c2 = new Cliente(2, "Rafael Souza", "4499606677");

        Horario h1 = new Horario(1, "08:00 às 09:00", 100.0);
        Horario h2 = new Horario(2, "09:00 às 10:00", 100.0);
        Horario h3 = new Horario(3, "10:00 às 11:00", 120.0);

        sistema.cadastrarCliente(c1);
        sistema.cadastrarCliente(c2);

        sistema.cadastrarHorario(h1);
        sistema.cadastrarHorario(h2);
        sistema.cadastrarHorario(h3);

        LocalDate hoje = LocalDate.now();

        Aluguel aluguel1 = sistema.registrarAluguel(1, hoje, c1, Arrays.asList(h1, h2), true);
        System.out.println("Aluguel realizado com sucesso:");
        System.out.println(aluguel1);

        try {
            sistema.registrarAluguel(2, hoje, c2, Arrays.asList(h2), false);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao registrar aluguel: " + e.getMessage());
        }

        System.out.println("\nAlugueis do dia " + hoje + ":");
        List<Aluguel> alugueisDoDia = sistema.consultarAlugueisPorDia(hoje);
        for (Aluguel aluguel : alugueisDoDia) {
            System.out.println(aluguel);
        }
    }
}

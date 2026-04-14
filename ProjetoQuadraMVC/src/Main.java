import controller.QuadraController;
import model.Aluguel;
import model.Cliente;
import model.Horario;
import view.QuadraView;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        QuadraController controller = new QuadraController();
        QuadraView view = new QuadraView();

        Cliente cliente1 = new Cliente(1, "Eduardo Ferrari", "44999375053");
        Cliente cliente2 = new Cliente(2, "Rafael Souza", "4499606677");

        Horario horario1 = new Horario(1, "08:00 às 09:00", 80.0);
        Horario horario2 = new Horario(2, "09:00 às 10:00", 80.0);
        Horario horario3 = new Horario(3, "10:00 às 11:00", 90.0);

        controller.cadastrarCliente(cliente1);
        controller.cadastrarCliente(cliente2);

        controller.cadastrarHorario(horario1);
        controller.cadastrarHorario(horario2);
        controller.cadastrarHorario(horario3);

        LocalDate data = LocalDate.now();

        try {
            Aluguel aluguel = controller.registrarAluguel(
                    1,
                    data,
                    cliente1,
                    Arrays.asList(horario1, horario2),
                    true
            );

            view.mostrarMensagem("Aluguel registrado com sucesso:");
            view.mostrarAluguel(aluguel);

        } catch (IllegalArgumentException e) {
            view.mostrarMensagem("Erro: " + e.getMessage());
        }

        try {
            controller.registrarAluguel(
                    2,
                    data,
                    cliente2,
                    Arrays.asList(horario2),
                    false
            );
        } catch (IllegalArgumentException e) {
            view.mostrarMensagem("Erro ao tentar reservar horário ocupado: " + e.getMessage());
        }

        view.mostrarMensagem("\nConsulta de aluguéis do dia:");
        view.mostrarListaAlugueis(controller.consultarAlugueisPorDia(data));
    }
}

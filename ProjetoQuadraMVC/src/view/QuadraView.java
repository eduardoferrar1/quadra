package view;

import model.Aluguel;

import java.util.List;

public class QuadraView {
    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void mostrarAluguel(Aluguel aluguel) {
        System.out.println(aluguel);
    }

    public void mostrarListaAlugueis(List<Aluguel> alugueis) {
        for (Aluguel aluguel : alugueis) {
            System.out.println(aluguel);
        }
    }
}

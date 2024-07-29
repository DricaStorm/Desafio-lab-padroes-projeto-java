import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Configuração do padrão Singleton
        GerenciadorDeContas gerenciador = GerenciadorDeContas.getInstancia();

        // Configuração do padrão Strategy
        System.out.println("Escolha a estratégia de juros (1 para Simples, 2 para Compostos): ");
        int escolha = scanner.nextInt();
        Strategy estrategia = null;

        if (escolha == 1) {
            estrategia = new JurosSimples(5.0); // 5% de juros simples
        } else if (escolha == 2) {
            estrategia = new JurosCompostos(5.0); // 5% de juros compostos
        }

        // Configuração do padrão Facade
        SistemaBancarioFacade facade = new SistemaBancarioFacade();
        System.out.println("Configurar conta com saldo inicial de 1000.0 e aplicar juros...");
        facade.configurarConta(1000.0, estrategia);

        // Processar uma operação usando o padrão Singleton
        System.out.println("Processar uma operação...");
        facade.processarOperacao("Saque de 200.0");

        scanner.close();
    }
}

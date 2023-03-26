import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercentDeposit(double amount, double percent, int period) {
        double pay = amount * Math.pow((1 + percent / 12), 12 * period);
        return round(pay, 2);
    }

    double calculateSimplePercentDeposit(double amount,double percent, int period) {
        return round(amount + amount * percent * period, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateEarning() {

        int period;
        int action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double result;

        if (action == 1) {
            result = calculateSimplePercentDeposit(amount, 0.06, period);
        }
        else if (action == 2) {
            result = calculateComplexPercentDeposit(amount, 0.06, period);
        }
        else {
            System.out.println("Ошибка. Такого действия нет.");
            return;
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + result);
    }

    public static void main(String[] args) {

        DepositCalculator depositCalculator = new DepositCalculator();
        depositCalculator.calculateEarning();

    }
}
